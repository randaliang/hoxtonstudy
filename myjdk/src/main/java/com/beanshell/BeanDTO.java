package com.beanshell;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.math.BigDecimal;

/**
 * @author randaliang
 * @date 2021-08-29 10:03
 **/
public class BeanDTO {
    private BigDecimal money;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}