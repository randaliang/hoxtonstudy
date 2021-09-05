package com.beanshell;


import bsh.EvalError;
import bsh.Interpreter;

import java.util.regex.Pattern;

/**
 * @author randaliang
 * @date 2021-07-23 10:42
 **/
public class BeanShellTest {
    public static void main(String[] args){
        String s = "Pattern.CASE_INSENSITIVE | Pattern.DOTALL";
        int falg = getFlags(s);
        s = " Pattern.DOTALL";
        falg = getFlags(s);
        System.out.print("end");


    }

    private static int getFlags( String pattern ){
        if(pattern == null){
            return Pattern.CASE_INSENSITIVE;
        }
        Interpreter interpreter = new Interpreter();
        try{
            interpreter.eval("import java.util.regex.Pattern;");
            interpreter.set("result", interpreter.eval(pattern));
            int i = (int)interpreter.get("result");
            return i;
        }catch(EvalError e){
            return Pattern.CASE_INSENSITIVE;
        }
    }

}