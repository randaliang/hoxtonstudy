package com.juc;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author randaliang
 * @date 2021-09-05 17:37
 **/
public class ThreadLinkedTest {
    public ThreadPoolExecutor t = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    private LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);

    public void start( int i ){
        try {
            blockingQueue.put(i);
//            t.submit(new TThread(blockingQueue));
            t.invokeAll(null);//明細所有的值


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean startT( int i ){
        try {
            blockingQueue.put(i);
            if(!blockingQueue.offer(i)){
                return false;
            }
            t.submit(new TThread(blockingQueue));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
    public void startSuper( int i){
        t.submit(new TThread(i));
    }
    public static void main(String[] args) {
        ThreadLinkedTest t = new ThreadLinkedTest();
        for( int i = 0; i < 10000; i++ ){
            t.start(i);
            if(i == 10){
                t.startSuper(i);
                System.out.println("start11======================"+i);
            }
            System.out.println("start"+i);
        }

        for( int i = 100; i < 200; i++ ){

        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TThread implements Runnable{
    LinkedBlockingQueue<Integer> blockingQueue;
    public TThread(LinkedBlockingQueue<Integer> blockingQueue ){
        this.blockingQueue = blockingQueue;
    }

    private  int i;
    public TThread(int i ){
        this.i = i;
    }
    @Override
    public void run() {

        if(blockingQueue == null){
            System.out.println("begin==============================="+i);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end=="+i);
            return;
        }

        try {
            int i = blockingQueue.take();
            System.out.println("begin=="+i);
            Thread.sleep(100L);
            System.out.println("end=="+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
