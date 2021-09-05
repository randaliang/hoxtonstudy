package com.staticlass;

/**
 * @author randaliang
 * @date 2021-08-28 11:09
 **/
public class Singleton {

    private Singleton() { }

    // 内部静态类
    private static class SingletonHolder{

        private static final  Singleton instance=new Singleton();
    }

    public static  Singleton getInstance(){

        return SingletonHolder.instance;
    }

    public static void main( String args[] ){
        Singleton.getInstance();
        Object a = SingletonHolder.instance;

    }

}