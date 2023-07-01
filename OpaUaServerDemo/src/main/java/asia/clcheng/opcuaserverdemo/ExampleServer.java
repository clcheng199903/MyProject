package asia.clcheng.opcuaserverdemo;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.milo.opcua.sdk.server.OpcUaServer;
import org.eclipse.milo.opcua.sdk.server.api.config.OpcUaServerConfig;
import org.eclipse.milo.opcua.sdk.server.api.config.OpcUaServerConfigBuilder;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.server.EndpointConfiguration;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * milo是java实现的一个opcua协议的框架，提供了server和client
 */
@Slf4j
public class ExampleServer {

    private static OpcUaServer server;

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        // 配置构建器
        OpcUaServerConfigBuilder opcUaServerConfigBuilder = new OpcUaServerConfigBuilder();
        // 设置服务器uri
        opcUaServerConfigBuilder.setApplicationUri("urn:qtc:uaServer");
        // 创建默认端点配置
        EndpointConfiguration defaultEndpointConfiguration = EndpointConfiguration.newBuilder().build();

        Set<EndpointConfiguration> endpointConfigurations = new HashSet<>();
        // 添加默认端点配置
        endpointConfigurations.add(defaultEndpointConfiguration);
        // 配置端点
        opcUaServerConfigBuilder.setEndpoints(endpointConfigurations);
        // 构建默认配置
        OpcUaServerConfig opcUaServerConfig = opcUaServerConfigBuilder.build();

        // 实例化server
        server = new OpcUaServer(opcUaServerConfig);
        CompletableFuture<OpcUaServer> future = server.startup();
        future.get();
        printNameSpaceTable();
        latch.await();
    }

    public static void printNameSpaceTable() {
        NamespaceTable namespaceTable = server.getNamespaceTable();

        int length = namespaceTable.toArray().length;

        for (int i=0;i<length;i++) {
            String uri = namespaceTable.getUri(i);
            log.info("namespace index: {}, uri: {}", i, uri);
        }
    }
}
