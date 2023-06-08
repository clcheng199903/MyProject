package com.example.milodemo;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.sdk.client.subscriptions.OpcUaSubscriptionManager;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

/**
 * milo线程池用的daemo线程
 * identifier有两种类型：Numeric和String
 */
@Slf4j
public class Main {

    private static final CountDownLatch latch = new CountDownLatch(1);

    private static final String url = "opc.tcp://milo.digitalpetri.com:62541/milo";
    private static final Double publishingInterval = 1000.0;
    private static final Double samplingInterval = 1000.0;
    private static final Integer queueSize = 10;

    private static Connection conn = null;

    private static AtomicInteger count = new AtomicInteger(0);
    private static AtomicInteger insertCount = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.taosdata.jdbc.TSDBDriver");
            String jdbcUrl = "jdbc:TAOS://tdengine-server:6030/test?user=root&password=taosdata";
//            String jdbcUrl = "jdbc:TAOS-RS://www.clcheng.asia:16041/datacollector?user=root&password=taosdata";
            conn = DriverManager.getConnection(jdbcUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        OpcUaClient client = OpcUaClient.create(url);
        client.connect().get(); // 进行连接操作
        OpcUaSubscriptionManager subscriptionManager = client.getSubscriptionManager();

        // 创建订阅对象
        UaSubscription subscription = subscriptionManager.createSubscription(publishingInterval).join();

        subscribe(subscription, getNodeIdList(), samplingInterval, queueSize);

        latch.await();
    }

    public static void subscribe(UaSubscription subscription, List<NodeId> nodeIdList, double samplingInterval, int queueSize) throws Exception {

        if (nodeIdList == null || nodeIdList.size() == 0) {
            return;
        }

        List<MonitoredItemCreateRequest> requestList = new ArrayList<>();

        for (NodeId nodeId : nodeIdList) {
            ReadValueId readValueId = new ReadValueId(
                    nodeId,
                    AttributeId.Value.uid(), null, QualifiedName.NULL_VALUE
            );

            UInteger clientHandle = subscription.nextClientHandle();
            MonitoringParameters parameters = new MonitoringParameters(
                    clientHandle,
                    samplingInterval,     // sampling interval
                    null,       // filter, null means use default
                    uint(queueSize),   // queue size
                    true        // discard oldest
            );

            MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(
                    readValueId,
                    MonitoringMode.Reporting,
                    parameters
            );

            requestList.add(request);
        }
        UaSubscription.ItemCreationCallback onItemCreated =
                (item, id) -> item.setValueConsumer(Main::onSubscriptionValue);

        subscription.createMonitoredItems(
                TimestampsToReturn.Both,
                requestList,
                onItemCreated
        );
    }

    public static void onSubscriptionValue(UaMonitoredItem item, DataValue value) {
//        UInteger identifier = (UInteger)item.getReadValueId().getNodeId().getIdentifier();
        String id = item.getReadValueId().getNodeId().getIdentifier().toString();
        Object idObj = item.getReadValueId().getNodeId().getIdentifier();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = value.getServerTime().getJavaDate();

        Variant opcValue = value.getValue();
        Object value1 = opcValue.getValue();
        String stringVaule = value1.toString();

        double v = Double.parseDouble(stringVaule);

        insert(conn, date, v);


        log.info("{} {} {} {} {}", id, dateFormat.format(date), v, stringVaule, count.getAndIncrement());

        if (count.get() % 10 == 0) {
            select(conn);
        }


//        log.info("stringVaule: {}", stringVaule );
//        ExpandedNodeId expandedNodeId = opcValue.getDataType().get();
//        log.info("{} {} {}", id, value1, expandedNodeId,);

//        String id;
//        if (idObj instanceof UInteger) {
//            id = ((UInteger)idObj).toString();
//        } else {
//            String id = (String)idObj;
//        }

//        log.info("subscription value received: item={}, value={}", item.getReadValueId().getNodeId(), value.getValue());
//
//
//        Optional<ExpandedNodeId> dataType = value.getValue().getDataType();
//        log.info(dataType.toString());
    }

    public static List<NodeId> getNodeIdList() {
        List<NodeId> list = new ArrayList<>();
        NodeId floatNode = new NodeId(2, "Dynamic/RandomFloat");
        NodeId doubleNode = new NodeId(2, "Dynamic/RandomDouble");
        NodeId int32Node = new NodeId(2, "Dynamic/RandomInt32");
//        NodeId int64Node = new NodeId(2, "Dynamic/RandomInt64");
//        NodeId currentTimeNode = new NodeId(0, 2258); // Identifiers.Server_ServerStatus_CurrentTime
        list.add(floatNode);
        list.add(doubleNode);
        list.add(int32Node);
//        list.add(int64Node);
//        list.add(currentTimeNode);
        return list;
    }

    /**
     * 索引从1开始，ResultSet也是从1开始
     * @param conn
     * @param ts
     * @param value
     * @return
     */
    public static int insert(Connection conn, Date date, Double value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String ts = dateFormat.format(date);

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("insert into tb_db_1001 values(?,?)");
            preparedStatement.setString(1, ts);
            preparedStatement.setDouble(2, value);

            int result = preparedStatement.executeUpdate();

            log.info("{}", insertCount.addAndGet(result));
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        }

    }

    public static void select(Connection conn) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(" select ts, value from tb_db_1001 order by ts desc limit 1");

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
               Date ts = result.getDate(1);
               Double value = result.getDouble(2);
               log.info("{} {}", dateFormat.format(ts), value);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        }
    }
}
