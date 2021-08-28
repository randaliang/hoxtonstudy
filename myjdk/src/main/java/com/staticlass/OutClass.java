package com.staticlass;

/**
 * @author randaliang
 * @date 2021-08-28 10:47
 **/
public class OutClass {

    /**
     *  全局静态变量
     */
    private static final String msg = "i love java";
    // 创建静态类
    public static class staticInnerClass{

        private int i;
        public void setI(int i ){
            this.i = i;
        }
        public void showI() {
            System.out.println("静态内部类展示信息:"+i);
        }
        public void showMsg() {
            System.out.println("静态内部类展示信息:"+msg);
        }

    }
    // 创建非静态内部类
    public class InnerClass{
        public void disPlayMsg() {
            System.out.println("非静态内部类展示信息:"+msg);
        }
    }

    public static void main(String[] args) {
        // 创建静态内部类实例
        staticInnerClass sic = new OutClass.staticInnerClass();
        sic.setI(100);
        sic.showI();

        staticInnerClass sic1 = new OutClass.staticInnerClass();
        sic1.showI();
//        sic.showMsg();

        // 创建非静态内部类实例,需要先创建外部类的实例 OutClass().new
        InnerClass ic = new OutClass().new InnerClass();
        ic.disPlayMsg();

    }
}