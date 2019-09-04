package org.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;

public class Cluster$Adaptive implements Cluster {
    @Override
    public Invoker join(Directory directory) throws RpcException {
        if (directory == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.cluster.Directory argument == null");
        }
        if (directory.getUrl() == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.cluster.Directory argument getUrl() == null");
        }
        URL uRL = directory.getUrl();
        String string = uRL.getParameter("cluster", "failover");
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.rpc.cluster.Cluster) name from url (").append(uRL.toString()).append(") use keys([cluster])").toString());
        }
        Cluster cluster = (Cluster) ExtensionLoader.getExtensionLoader(Cluster.class).getExtension(string);
        return cluster.join(directory);
    }
}