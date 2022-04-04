package com.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author randaliang
 * @date 2021-10-27 11:15
 **/
public class ListTest {
    public static void main(String[] args) {
        Map<Object,String> map = new HashMap<>();
        map.put("1","1");
        map.put(1,"1");
        System.out.println(map.get(1));;

    }
}