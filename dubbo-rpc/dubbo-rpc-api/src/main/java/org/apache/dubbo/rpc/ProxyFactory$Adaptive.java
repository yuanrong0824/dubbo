package org.apache.dubbo.rpc;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class ProxyFactory$Adaptive implements ProxyFactory {
    @Override
    public Invoker getInvoker(Object object, Class class_, URL uRL) throws RpcException {
        if (uRL == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL uRL2 = uRL;
        String string = uRL2.getParameter("proxy", "javassist");
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.rpc.ProxyFactory) name from url (").append(uRL2.toString()).append(") use keys([proxy])").toString());
        }
        ProxyFactory proxyFactory = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(string);
        return proxyFactory.getInvoker(object, class_, uRL);
    }

    @Override
    public Object getProxy(Invoker invoker, boolean bl) throws RpcException {
        if (invoker == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        }
        if (invoker.getUrl() == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        }
        URL uRL = invoker.getUrl();
        String string = uRL.getParameter("proxy", "javassist");
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.rpc.ProxyFactory) name from url (").append(uRL.toString()).append(") use keys([proxy])").toString());
        }
        ProxyFactory proxyFactory = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(string);
        return proxyFactory.getProxy(invoker, bl);
    }

    @Override
    public Object getProxy(Invoker invoker) throws RpcException {
        if (invoker == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        }
        if (invoker.getUrl() == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        }
        URL uRL = invoker.getUrl();
        String string = uRL.getParameter("proxy", "javassist");
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.rpc.ProxyFactory) name from url (").append(uRL.toString()).append(") use keys([proxy])").toString());
        }
        ProxyFactory proxyFactory = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(string);
        return proxyFactory.getProxy(invoker);
    }
}
