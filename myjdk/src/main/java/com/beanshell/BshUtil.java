package com.beanshell;


import bsh.EvalError;
import bsh.Interpreter;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.scripting.bsh.BshScriptUtils;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.regex.Pattern;

public class BshUtil {

    private static transient Interpreter interPerter = new Interpreter();
    public static void main( String args[] ){


    }

    private SayHello1 sh;

    public BshUtil()  {
        String scopeScript = "say(bill){ return bill.getMoney().signum() * bill.getNum();}";
        try {
            sh = (SayHello1) BshScriptUtils.createBshObject(scopeScript, new Class[] { SayHello1.class });
//            BeanDTO beanDTO = new BeanDTO();
//            beanDTO.setMoney( new BigDecimal(10));
//            beanDTO.setNum(10);
//            this.proxyBshFuction(beanDTO);
        } catch (EvalError e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("e",e);
        }
    }


    public int proxyBsh(BeanDTO beanDTO){
//        String srciptText = "say(name){ return \"hello,\"+name;}";
        String scopeScript = "say(bill){ return bill.getMoney().signum() * bill.getNum();}";
        try {
//            System.out.print(ClassLayout.parseInstance(sh).toPrintable());

            return sh.say(beanDTO);
        } catch (Exception e) {
            return -1;
        }
    }


//    public Function<Integer,Boolean> proxyBshFuction(BeanDTO beanDTO){
//        String scopeScript = "apply(bill){ return bill.getMoney().signum() * bill.getNum();}";
//        try {
//            Function f  = (Function) BshScriptUtils.createBshObject(scopeScript, new Class[] { Function.class });
//            return f;
//        } catch (EvalError evalError) {
//            evalError.printStackTrace();
//        }
//        return null;
//    }


//    public <T,R> Function<T,R> proxyBshFuction(String scopeScript ){
//        try {
//            Function f1  = (Function) BshScriptUtils.createBshObject( scopeScript,  Function.class );
//            return f1;
//        } catch (EvalError evalError) {
//            evalError.printStackTrace();
//        }
//
//        return null;
//
//    }

    public int scriptBsh(Object bill) {
        String scopeScript = "bill.getMoney().signum() * bill.getNum()";
       try {
            interPerter.set("bill", bill);
            Integer ret = (Integer) interPerter.eval( scopeScript );
           ret = (Integer) interPerter.eval( scopeScript );
            return ret.intValue();
        } catch (EvalError e) {
            return 0;
        }
    }

    public static <T, R> Function<T, R>  proxyBshFuction(String scopeScript)
            throws EvalError {
        @SuppressWarnings("unchecked")
        Function<T,R> f1 = (Function<T,R>) BshScriptUtils.createBshObject(scopeScript,
                new Class[] { Function.class });
        return f1;

    }

}



interface SayHello1 {
    public int say(Object bill);
}