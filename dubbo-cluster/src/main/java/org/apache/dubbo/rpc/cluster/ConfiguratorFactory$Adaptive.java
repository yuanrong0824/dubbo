package org.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class ConfiguratorFactory$Adaptive implements ConfiguratorFactory {
    @Override
    public Configurator getConfigurator(URL uRL) {
        if (uRL == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL uRL2 = uRL;
        String string = uRL2.getProtocol();
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.rpc.cluster.ConfiguratorFactory) name from url (").append(uRL2.toString()).append(") use keys([protocol])").toString());
        }
        ConfiguratorFactory configuratorFactory = (ConfiguratorFactory) ExtensionLoader.getExtensionLoader(ConfiguratorFactory.class).getExtension(string);
        return configuratorFactory.getConfigurator(uRL);
    }
}