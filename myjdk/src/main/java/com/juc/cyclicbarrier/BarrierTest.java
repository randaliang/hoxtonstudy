package com.juc.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author randaliang
 * @date 2021-10-14 18:37
 **/
public class BarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for(int i = 0; i < 5; i++ ){
            new MyRandomThread(cyclicBarrier).start();
        }
        System.out.println("over");
    }
}


class MyRandomThread extends Thread{

    CyclicBarrier cyclicBarrier;
    MyRandomThread(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println("begin");
        Random r = new Random();
        int s = r.nextInt(5);
        try {
            Thread.sleep(s*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}