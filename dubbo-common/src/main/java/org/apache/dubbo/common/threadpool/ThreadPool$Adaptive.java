package org.apache.dubbo.common.threadpool;

import java.util.concurrent.Executor;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.threadpool.ThreadPool;

public class ThreadPool$Adaptive implements ThreadPool {
    @Override
    public Executor getExecutor(URL uRL) {
        if (uRL == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL uRL2 = uRL;
        String string = uRL2.getParameter("threadpool", "fixed");
        if (string == null) {
            throw new IllegalStateException(new StringBuffer().append("Failed to get extension (org.apache.dubbo.common.threadpool.ThreadPool) name from url (").append(uRL2.toString()).append(") use keys([threadpool])").toString());
        }
        ThreadPool threadPool = (ThreadPool) ExtensionLoader.getExtensionLoader(ThreadPool.class).getExtension(string);
        return threadPool.getExecutor(uRL);
    }
}