package com.generic.dogTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author randaliang
 * @date 2021-09-05 15:46
 **/
public class ToArray {

    public static void main( String args[] ){
        List<String> list = new ArrayList<>();
        list.add("1333");
        list.add("456");
        String[] s = list.toArray(new String[0]);
        System.out.println(s.length);
        System.out.println(s[1]);

    }
}