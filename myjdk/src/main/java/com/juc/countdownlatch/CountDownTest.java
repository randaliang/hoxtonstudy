package com.juc.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author randaliang
 * @date 2021-10-14 18:12
 **/
public class CountDownTest {
    public static void main(String[] args) {
        int threadNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for( int i = 0; i< threadNum; i++ ){
            new MyRandomThread(countDownLatch).start();
        }
        try {
            System.out.println("over1");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over2");

    }
}

class MyRandomThread extends Thread{

    CountDownLatch countDownLatch;
    MyRandomThread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
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
        countDownLatch.countDown();
    }
}