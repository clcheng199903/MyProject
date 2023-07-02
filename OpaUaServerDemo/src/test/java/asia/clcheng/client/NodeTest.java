package asia.clcheng.client;

import org.eclipse.milo.opcua.sdk.client.AddressSpace;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.model.nodes.objects.ServerTypeNode;
import org.eclipse.milo.opcua.sdk.client.nodes.UaNode;
import org.eclipse.milo.opcua.sdk.client.nodes.UaObjectNode;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceDescription;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class NodeTest {

    private static final String url = "opc.tcp://localhost:12685";
    @Test
    void nodeTest() throws UaException, ExecutionException, InterruptedException {
        OpcUaClient client = OpcUaClient.create(url);
        client.connect().get();

        /**
         * 地址空间
         */
        AddressSpace addressSpace = client.getAddressSpace();

        UaNode node = addressSpace.getNode(Identifiers.Server_ServerStatus_CurrentTime); // 抽象类，不能读值readValue()
        /**
         * 属性
         */
        System.out.println(node.getNodeId());
        System.out.println(node.getNodeClass());
        System.out.println(node.getDescription());
        System.out.println(node.getBrowseName());
        System.out.println(node.getDisplayName());

        List<ReferenceDescription> browse = node.browse();
        System.out.println(browse);

        /**
         * 有些属性值取值是用的缓存值，并没有从server实时获取
         */
        UaVariableNode variableNode = addressSpace.getVariableNode(Identifiers.Server_ServerStatus);
        /**
         * get
         */
        System.out.println(variableNode.getDisplayName()); // LocalizedText LocalizedText{text=ServerStatus, locale=en}
        /**
         * read
         */
        System.out.println(variableNode.readValue()); // DataValue
        System.out.println(variableNode.readDataType()); // NodeId NodeId{ns=0, id=862}
        System.out.println(variableNode.readHistorizing()); // Boolean false


        List<ReferenceDescription> browse1 = variableNode.browse();
        System.out.println(browse1);
        ReferenceDescription startTime = browse1.get(0); // 引用对象
        Boolean isForward = startTime.getIsForward();
        System.out.println(isForward);

        UaObjectNode objectNode = addressSpace.getObjectNode(Identifiers.TypesFolder);


        UaNode node1 = addressSpace.getNode(new NodeId(0, 63));
        System.out.println(node1.getBrowseName());
    }

    @Test
    void testIdentifier() throws ExecutionException, InterruptedException, UaException {
        OpcUaClient client = OpcUaClient.create(url);
        client.connect().get();

        AddressSpace addressSpace = client.getAddressSpace();
        UaNode rootFolder = addressSpace.getNode(Identifiers.RootFolder);
        UaNode server = addressSpace.getNode(Identifiers.Server);
        UaNode objectsFolder = addressSpace.getNode(Identifiers.ObjectsFolder);
        UaNode typeFolder = addressSpace.getNode(Identifiers.TypesFolder);
        UaNode viewsFolder = addressSpace.getNode(Identifiers.ViewsFolder);
        UaNode dataTypesFolder = addressSpace.getNode(Identifiers.DataTypesFolder);
        UaNode eventTypesFolder = addressSpace.getNode(Identifiers.EventTypesFolder);

    }

    @Test
    void testNodeType() {

    }

    @Test
    void testRead() throws ExecutionException, InterruptedException, UaException {
        OpcUaClient client = OpcUaClient.create(url);
        client.connect().get();

        /**
         * 地址空间
         */
        AddressSpace addressSpace = client.getAddressSpace();

        UaVariableNode variableNode = addressSpace.getVariableNode(new NodeId(2, "Hello/Int32"));

        while (true) {
            DataValue dataValue = variableNode.readValue();
            System.out.println(dataValue.getValue().getValue());
        }


    }
}
