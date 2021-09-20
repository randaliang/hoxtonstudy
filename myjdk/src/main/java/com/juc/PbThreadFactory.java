package com.juc;

import org.springframework.util.StringUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author randaliang
 * @date 2021-09-07 15:36
 **/
public class PbThreadFactory implements ThreadFactory {

    /**
     *匿名保护
     */
    private static final AtomicInteger threadNumber=new AtomicInteger(1);

    /**
     * 定义线程不成福
     */
    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private final String prefix;

    private final boolean daemoThread;

    private final ThreadGroup threadGroup;

    /**
     * 控制输入数量
     */
    private Semaphore semaphore;

    public PbThreadFactory() {
        this("rpcserver-threadpool-" + threadNumber.getAndIncrement(), false);
    }

    public PbThreadFactory(String prefix) {
        this(prefix, false);
    }



    public PbThreadFactory(String prefix, boolean daemo) {
        this(prefix,daemo,0);
    }

    public PbThreadFactory(String prefix, int inputSize) {
        this(prefix,false,inputSize);
    }

    public PbThreadFactory(String prefix, boolean daemo,int inputSize){
        this.prefix = !StringUtils.isEmpty(prefix) ? prefix + "-thread-" : "";
        daemoThread = daemo;
        SecurityManager s = System.getSecurityManager();
        threadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();

    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefix + mThreadNum.getAndIncrement();
        Thread ret = new Thread(threadGroup, runnable, name, 0);
        ret.setDaemon(daemoThread);
        return ret;
    }
}

