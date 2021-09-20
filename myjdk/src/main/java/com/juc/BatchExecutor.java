package com.juc;

import java.util.Collection;
import java.util.concurrent.*;

/**
 * @author randaliang
 * @date 2021-09-07 18:56
 **/
public class BatchExecutor<T> {
    public ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    public ThreadPoolExecutor detailExecutor = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    public void submmit( Object o  ){
//        poolExecutor.submit(null);
    }

    Semaphore cacheSizeSemaphore = null;

    boolean isOverRefuse = false;

    BatchExeCallBack batchExeCallBack;
    public BatchExecutor(int coreSize,int cacheSize,boolean isOverRefuse,BatchExeCallBack batchExeCallBack ){
        this.cacheSizeSemaphore = new Semaphore(cacheSize );
        this.batchExeCallBack = batchExeCallBack;
    }

    public boolean invokeAll( T t ){
        if(isOverRefuse){
            boolean b = cacheSizeSemaphore.tryAcquire();
            if(!b){
                return false;
            }
        }

        try {
            while(true){
                poolExecutor.invokeAll( batchExeCallBack.getTask(t));
                if(batchExeCallBack.afterComplete(null)){
                    break;
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            cacheSizeSemaphore.release();
        }
        return true;
    }

}

interface BatchExeCallBack<M>{
    public Collection<? extends Callable<M>> getTask( Object obj );
    public boolean afterComplete(Object obj);

}

class MyRun<T> implements Runnable{
    BatchExeCallBack batchExeCallBack;
    T t;

    @Override
    public void run() {

    }
}