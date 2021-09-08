package com.juc;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

/**
 * @author randaliang
 * @date 2021-09-05 17:23
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Thread putThread= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put start");
                try{
                    queue.put(1);
                }catch( Exception e ){

                }
            }
        });
        Thread takeThread= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("take start");
                try{

                    System.out.print("take start"+queue.take());
                }catch( Exception e ){

                }
            }
        });
        putThread.start();
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeThread.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}