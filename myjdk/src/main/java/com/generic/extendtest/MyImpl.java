package com.generic.extendtest;

/**
 * @author randaliang
 * @date 2021-10-27 9:52
 **/
public class MyImpl implements MyInterface<String> {
    @Override
    public void test(String o) {
        System.out.println(o);
    }
}