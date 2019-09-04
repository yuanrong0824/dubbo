package org.apache.dubbo.remoting;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class Dispatcher$Adaptive implements Dispatcher {
    @Override
    public ChannelHandler dispatch(ChannelHandler channelHandler, URL uRL) {
        if (uRL == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL uRL2 = uRL;
        String string = uRL2.getParameter("dispatcher", uRL2.getParameter("dispather", uRL2.getParameter("channel.handler", "all")));
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.remoting.Dispatcher) name from url (").append(uRL2.toString()).append(") use keys([dispatcher, dispather, channel.handler])").toString());
        }
        Dispatcher dispatcher = (Dispatcher)ExtensionLoader.getExtensionLoader(Dispatcher.class).getExtension(string);
        return dispatcher.dispatch(channelHandler, uRL);
    }
}