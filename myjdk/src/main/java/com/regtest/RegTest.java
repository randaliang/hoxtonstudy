package com.regtest;

import java.util.regex.Pattern;

/**
 * @author randaliang
 * @date 2021-07-21 18:53
 **/
public class RegTest {

    public static void main( String argsp[] ){
        String s = "expression\\\\((.*?)\\\\)";
        System.out.println(s);
        System.out.println(Pattern.DOTALL);
    }
}