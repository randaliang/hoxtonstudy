package com.file;

import java.io.File;

/**
 * @author randaliang
 * @date 2021-10-20 11:33
 **/
public class FileExists {
    public static void main(String[] args) {
        File f = new File("/usr/local/","./");
        System.out.println(f.getAbsolutePath());
    }
}