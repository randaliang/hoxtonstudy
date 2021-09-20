package com.designpattern.singleton;

/**
 * 枚举值单例模式
 * @author randaliang
 * @date 2021-09-20 9:55
 **/
public enum EnumContext {

    INSTANCE("127.0.0.1",8080);

    private final String ip;

    private final int port;

    private EnumContext(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public String getIp(){
        return this.ip;
    }

    public int getPort(){
        return this.port;
    }

    public static void main(String[] args) {
        System.out.println();

    }

}