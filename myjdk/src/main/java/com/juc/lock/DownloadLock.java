package com.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author randaliang
 * @date 2021-10-15 17:17
 **/
public class DownloadLock {

    public static void main(String[] args) {



    }

    public List<String> queryList(){
        List<String> sList = new ArrayList<>();
        CountDownLatch cdl = new CountDownLatch(5);
        MyTread myTread= new MyTread(cdl);
        myTread.start();
        for( int i = 0; i < 10; i++ ){
            //发送获取流水信息 file_name

            myTread.addFileName("ss");
        }
//        cdl.await();
        return sList;
    }
}

class MyTread extends Thread{

    CountDownLatch countDownLatch;

    public MyTread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    public void addFileName(String fileName){

    }

    @Override
    public void run(){
        while( countDownLatch.getCount() > 0){
            //1.遍历所有的filename
            //2.调用下载接口，查看文件是否应返回
            //3.如果已经返回，则进行解析文件，并调用public List<AccountFlowVoucher> createDailyFlowComm(Session sc,BankAccount bankAccount, String startDate, String endDate,List<AccountFlowDetail> flows) throws Exception {
            //4.如果解析并成功  countDownLatch.countDown();
            //5.remove掉已经下载的filename
        }

    }
}