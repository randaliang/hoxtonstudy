package com.beanshell;
import bsh.Interpreter;
//import groovy.lang.Binding;
//import groovy.lang.GroovyShell;
//import groovy.lang.Script;
//import grp.pt.pb.payment.PayVoucher;
import org.openjdk.jol.info.ClassLayout;
/**
 * @author randaliang
 * @date 2021-08-30 9:30
 **/
public class ClassLayoutTest {

//    public static void main(String[] args) {
//
//        PayVoucher p = new PayVoucher();
//        p.setVt_code("20011");
//
//        Interpreter interPerter = new Interpreter();
//
//        try {
//            interPerter.set("bill", p);
//            Boolean ret = (Boolean) interPerter.eval("");
//            boolean a = ret.booleanValue();
//        }catch (Exception e){
//
//        }
//
//        GroovyShell groovyShell = new GroovyShell();
//        System.out.println(ClassLayout.parseInstance(interPerter).toPrintable());
//        // 解析动态groovy script，脚本以string形式传入
//        Script script = groovyShell.parse("bill.getVt_code().equals(\"2001\")");
//        // 创建运行环境上下文的变量绑定
//        Binding binding = new Binding();
//        // 上下文放入bill变量，值为clazz
//        binding.setProperty("bill", p);
//        // 设置绑定
//        script.setBinding(binding);
//        // 执行脚本，获取脚本执行结果
//        Object result = script.run();
//        System.out.println("--------");
//        System.out.println(result);
//
//        System.out.println(ClassLayout.parseInstance(binding).toPrintable());
//        System.out.println(ClassLayout.parseInstance(script).toPrintable());
//        System.out.println(ClassLayout.parseInstance(groovyShell).toPrintable());
//    }
}
