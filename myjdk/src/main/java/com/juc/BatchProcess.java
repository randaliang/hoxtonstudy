package com.juc;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author randaliang
 * @date 2021-09-13 18:58
 **/
public interface BatchProcess<B,D> {
    /**
     * 构建明细处理逻辑
     * @param d
     * @return
     */
    public Callable newCallable(D d);

    public List<D> loadDetails( B b);

    public void processBill( B b );

    public void processAfterBill( B b );

    public int getBatchSize();
}