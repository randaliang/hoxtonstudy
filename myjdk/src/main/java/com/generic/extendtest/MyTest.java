package com.generic.extendtest;

/**
 * @author randaliang
 * @date 2021-10-27 9:53
 **/
public class MyTest {
    public static void main(String[] args) {
        try {
            MyInterface myInterface = (MyInterface)Class.forName("com.generic.extendtest.MyImpl").newInstance();
            myInterface.test("3");
            MyImpl m = new MyImpl();
            m.test("4");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}