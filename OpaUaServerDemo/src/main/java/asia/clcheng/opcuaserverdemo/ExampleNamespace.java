package asia.clcheng.opcuaserverdemo;

import org.eclipse.milo.opcua.sdk.core.AccessLevel;
import org.eclipse.milo.opcua.sdk.core.Reference;
import org.eclipse.milo.opcua.sdk.server.LifecycleManager;
import org.eclipse.milo.opcua.sdk.server.OpcUaServer;
import org.eclipse.milo.opcua.sdk.server.UaNodeManager;
import org.eclipse.milo.opcua.sdk.server.api.DataItem;
import org.eclipse.milo.opcua.sdk.server.api.ManagedAddressSpaceFragmentWithLifecycle;
import org.eclipse.milo.opcua.sdk.server.api.ManagedNamespaceWithLifecycle;
import org.eclipse.milo.opcua.sdk.server.api.MonitoredItem;
import org.eclipse.milo.opcua.sdk.server.nodes.UaFolderNode;
import org.eclipse.milo.opcua.sdk.server.nodes.UaVariableNode;
import org.eclipse.milo.opcua.sdk.server.nodes.filters.AttributeFilters;
import org.eclipse.milo.opcua.sdk.server.util.SubscriptionModel;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

import java.util.List;
import java.util.Random;

public class ExampleNamespace extends ManagedNamespaceWithLifecycle {
    /**
     * 指定命名空间URL
     */
    public static final String NAMESPACE_URI = "urn:eclipse:milo:hello-world";

    private final Random random = new Random();

    private final SubscriptionModel subscriptionModel;

    public ExampleNamespace(OpcUaServer server) {
        super(server, NAMESPACE_URI);
        /**
         *  管理地址空间的生命周期管理器
         */
        LifecycleManager lifecycleManager = getLifecycleManager();
        lifecycleManager.addStartupTask(this::createAndAddNodes);

        subscriptionModel = new SubscriptionModel(server, this);
        getLifecycleManager().addLifecycle(subscriptionModel);

    }

    private void createAndAddNodes() {
        // 创建 Hello World 文件夹
        NodeId folderNodeId = newNodeId("HelloWorld"); // 默认使用this的NamespaceIndex，identifier为HelloWorld

        /**
         * 命名：三个标记是独立的
         * Identifier
         * BrowseName
         * DisplayName
         */
        UaFolderNode folderNode = new UaFolderNode(
                getNodeContext(),
                folderNodeId,
                newQualifiedName("HelloWorld"), // 指定BrowseName
                LocalizedText.english("你好，世界！")
        );

        /**
         * 节点管理器
         */
        UaNodeManager nodeManager = getNodeManager();

        nodeManager.addNode(folderNode);

        /**
         * 确保新文件夹会显示在Objects文件夹下
         */
        folderNode.addReference(new Reference(
                folderNodeId,
                Identifiers.Organizes,
                Identifiers.ObjectsFolder.expanded(), //Convert this NodeId to a relative ExpandedNodeId.
                false
        ));

        /**
         * 添加剩下节点
         */
        UaFolderNode scalarTypesFolder = new UaFolderNode(
                getNodeContext(),
                newNodeId("HelloWorld/ScalarTypes"),
                newQualifiedName("ScalarTypes"),
                LocalizedText.english("标量类型")
        );

        UaFolderNode dynamicFolder = new UaFolderNode(
                getNodeContext(),
                newNodeId("HelloWorld/Dynamic"),
                newQualifiedName("Dynamic"),
                LocalizedText.english("Dynamic")
        );

        getNodeManager().addNode(dynamicFolder);
        folderNode.addOrganizes(dynamicFolder);

        getNodeManager().addNode(scalarTypesFolder);
        // Add an 'Organizes' reference from this folder to node and an inverse 'Organized By' reference from node back to this folder.
        folderNode.addOrganizes(scalarTypesFolder);


        // Dynamic Boolean
        {
            String name = "Boolean";
            NodeId typeId = Identifiers.Boolean;
            Variant variant = new Variant(false);

            UaVariableNode node = new UaVariableNode.UaVariableNodeBuilder(getNodeContext())
                    .setNodeId(newNodeId("HelloWorld/Dynamic/" + name))
                    .setAccessLevel(AccessLevel.READ_WRITE)
                    .setBrowseName(newQualifiedName(name))
                    .setDisplayName(LocalizedText.english(name))
                    .setDataType(typeId)
                    .setTypeDefinition(Identifiers.BaseDataVariableType)
                    .setMinimumSamplingInterval(1000.0)
                    .build();

            node.setValue(new DataValue(variant));

            node.getFilterChain().addLast(
                    new AttributeLoggingFilter(),
                    AttributeFilters.getValue(
                            ctx ->
                                    new DataValue(new Variant(random.nextBoolean()))
                    )
            );

            getNodeManager().addNode(node);
            dynamicFolder.addOrganizes(node);
        }

        // Dynamic Int32
        {
            String name = "Int32";
            NodeId typeId = Identifiers.Int32;
            Variant variant = new Variant(0);

            UaVariableNode node = new UaVariableNode.UaVariableNodeBuilder(getNodeContext())
                    .setNodeId(newNodeId("HelloWorld/Dynamic/" + name))
                    .setAccessLevel(AccessLevel.READ_WRITE)
                    .setBrowseName(newQualifiedName(name))
                    .setDisplayName(LocalizedText.english(name))
                    .setDataType(typeId)
                    .setTypeDefinition(Identifiers.BaseDataVariableType)
                    .setMinimumSamplingInterval(1000.0)
                    .build();

            node.setValue(new DataValue(variant));

            node.getFilterChain().addLast(
                    new AttributeLoggingFilter(),
                    AttributeFilters.getValue(
                            ctx ->
                                    new DataValue(new Variant(random.nextInt()))
                    )
            );

            getNodeManager().addNode(node);
            dynamicFolder.addOrganizes(node);
        }

    }

    @Override
    public void onDataItemsCreated(List<DataItem> dataItems) {
        subscriptionModel.onDataItemsCreated(dataItems);
    }

    @Override
    public void onDataItemsModified(List<DataItem> dataItems) {
        subscriptionModel.onDataItemsModified(dataItems);
    }

    @Override
    public void onDataItemsDeleted(List<DataItem> dataItems) {
        subscriptionModel.onDataItemsDeleted(dataItems);

    }

    @Override
    public void onMonitoringModeChanged(List<MonitoredItem> monitoredItems) {
        subscriptionModel.onMonitoringModeChanged(monitoredItems);

    }


}
