package com.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author randaliang
 * @date 2021-09-13 19:02
 **/
public class BatchThreadExecutor<B,D> {

    private ThreadPoolExecutor detailPool;
    BatchProcess batchProcess = null;
    public void submmit( B b){
        try{
            batchProcess.processBill(b);
            while(true){
                List<D> detailList =  batchProcess.loadDetails(b);
                List<Callable<Boolean>> runList = new ArrayList();
//                detailList.forEach( x->batchProcess.newCallable(x) );
                detailPool.invokeAll(runList);
                if(detailList.size()<batchProcess.getBatchSize()){
                    break;
                }
            }
            batchProcess.processAfterBill(b);


        }catch(RejectedExecutionException e){
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}