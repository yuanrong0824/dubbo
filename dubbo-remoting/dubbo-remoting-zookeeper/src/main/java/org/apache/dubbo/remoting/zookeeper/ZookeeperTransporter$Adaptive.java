package org.apache.dubbo.remoting.zookeeper;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.remoting.zookeeper.ZookeeperClient;
import org.apache.dubbo.remoting.zookeeper.ZookeeperTransporter;

public class ZookeeperTransporter$Adaptive implements ZookeeperTransporter {

    @Override
    public ZookeeperClient connect(URL uRL) {
        if (uRL == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL uRL2 = uRL;
        String string = uRL2.getParameter("client", uRL2.getParameter("transporter", "curator"));
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.remoting.zookeeper.ZookeeperTransporter) name from url (").append(uRL2.toString()).append(") use keys([client, transporter])").toString());
        }
        ZookeeperTransporter zookeeperTransporter = (ZookeeperTransporter) ExtensionLoader.getExtensionLoader(ZookeeperTransporter.class).getExtension(string);
        return zookeeperTransporter.connect(uRL);
    }
}