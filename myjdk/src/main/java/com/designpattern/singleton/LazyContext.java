package com.designpattern.singleton;

/**
 * 单例模式——懒汉模式——双重校验锁
 * @author randaliang
 * @date 2021-09-19 17:57
 **/
public class LazyContext {
    private String ip;
    private int port;

    private LazyContext(){
        init();
    }

    /**
     * 读取配置文件初始化ip port
     */
    private void init(){
        ip = "127.0.0.1";
        port = 8080;
    }

    /**
     * 静态变量,注意需要用volatile static 修饰，否则指令重排序可能会导致多线程重复初始化
     */
    private volatile static LazyContext lazyContext;

    public static LazyContext getInstance(){
        if(lazyContext != null){
            return lazyContext;
        }
        synchronized (LazyContext.class){
            if( lazyContext == null ){
                lazyContext = new LazyContext();
            }
        }
        return lazyContext;
    }

}