package com.juc.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author randaliang
 * @date 2021-10-20 10:24
 **/
public class MyHashMap {


    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.remove(map,"2");

    }

    public void remove(HashMap<String,String> map, String key){
        for(Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(key)){
                map.remove(entry.getKey());
            }
        }
    }

    public void removeit(HashMap<String,String> map, String key){
        Iterator<Map.Entry<String, String>>  it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String>  a = it.next();
            if(a.getKey().equalsIgnoreCase(key)){
                it.remove();
            }
        }
        map.keySet();
        map.toString();

    }
}