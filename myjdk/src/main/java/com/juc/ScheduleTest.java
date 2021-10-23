package com.juc;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author randaliang
 * @date 2021-10-12 14:01
 **/
public class ScheduleTest {

    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);


    public ScheduledFuture startThread(Runnable r ){
        return scheduledThreadPool.scheduleAtFixedRate(r,0,2, TimeUnit.SECONDS);
    }

    public void removeThread(Runnable r){
        ((ScheduledThreadPoolExecutor)scheduledThreadPool).remove(r);
    }

    public static void main(String[] args) {
        ScheduleTest s = new ScheduleTest();
        ScheduledFuture a = s.startThread(new MyTask());
//        s.removeThread(a);
//        a.toString()
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class MyTask implements  Runnable{

    int i = 0;
    @Override
    public void run() {
        i++;
        System.out.println("start=====" + i +new Date());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end  =====" + i +new Date());
    }
}