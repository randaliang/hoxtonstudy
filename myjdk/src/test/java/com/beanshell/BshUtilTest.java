package com.beanshell;

import bsh.EvalError;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BshUtilTest {

   static BshUtil bshUtil = null;
    @BeforeAll
    public static void init(){
        bshUtil = new BshUtil();
    }

    @Test
    @Disabled
    @DisplayName("proxy模式test")
//    @RepeatedTest(100000)
    void proxyBsh() {
        BeanDTO beanDTO = new BeanDTO();
        beanDTO.setMoney( new BigDecimal(10));
        beanDTO.setNum(10);
        for( int i = 0; i < 20; i++){
            beanDTO.setNum(i);
            bshUtil.proxyBsh(beanDTO);
        }
    }

    @Test
    @DisplayName("script模式test")
    @Disabled
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void isBillFitBizType() {
        BeanDTO beanDTO = new BeanDTO();
        beanDTO.setMoney( new BigDecimal(10));
        beanDTO.setNum(10);
        for( int i = 0; i < 20; i++){
            beanDTO.setNum(i);
            bshUtil.scriptBsh(beanDTO);
        }
    }

    @Test
    @DisplayName("script模式test")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testFuction(){
        BeanDTO beanDTO = new BeanDTO();
        beanDTO.setMoney( new BigDecimal(100));
        beanDTO.setNum(101);
        String script = "apply(bill){ return bill.getMoney().signum() * bill.getNum();}";
        Function<Object,Boolean> f = null;
        try {
            f = bshUtil.proxyBshFuction(script);
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }
        Boolean t = f.apply(beanDTO);
        System.out.print( "res" + t);
    }




    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("参数化测试")
    void paramTest(int a) {
        assertTrue(a > 0 && a < 4);
    }




}