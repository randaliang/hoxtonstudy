package com.juc;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author randaliang
 * @date 2021-09-13 19:10
 **/
public class BatchPayVoucherCallBack implements BatchProcess<BatchPayVoucher,BatchPayRequest>{
    @Override
    public Callable newCallable(BatchPayRequest batchPayRequest) {
        return null;
    }

    @Override
    public List<BatchPayRequest> loadDetails(BatchPayVoucher batchPayVoucher) {
        return null;
    }

    @Override
    public void processBill(BatchPayVoucher batchPayVoucher) {
        //设置发放中
    }

    @Override
    public void processAfterBill(BatchPayVoucher batchPayVoucher) {
        //update 总数量
        //是否发送
    }

    @Override
    public int getBatchSize() {
        return 0;
    }
}

class BatchPayVoucher{

}
class BatchPayRequest{

}

class PayService{
//    public void setBillStateus( BatchPayVoucher b  );
}