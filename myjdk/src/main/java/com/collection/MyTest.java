package com.collection;

import org.springframework.util.LinkedMultiValueMap;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author randaliang
 * @date 2021-07-23 17:07
 **/
public class MyTest {
    public static void main(String[] args) {
        LinkedMultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        List<String> s = map.get("1");
    }
}