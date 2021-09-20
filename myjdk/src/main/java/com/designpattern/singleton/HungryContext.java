package com.designpattern.singleton;

/**
 * 单例模式——恶汉，传统说法是需要配置文件之类的不太方便,个人觉得如果不需要在getInstance传递参数其实无所谓
 * @author randaliang
 * @date 2021-09-20 9:02
 **/
public class HungryContext {

    private String ip;
    private int port;

    private HungryContext() {
        init();
    }

    /**
     * 读取配置文件初始化ip port
     */
    private void init() {
        ip = "127.0.0.1";
        port = 8080;
    }

    /**
     * 静态变量,注意需要用volatile static 修饰
     */
    private static HungryContext hungryContext = new HungryContext();

    public HungryContext getInstance() {
        return hungryContext;
    }
}