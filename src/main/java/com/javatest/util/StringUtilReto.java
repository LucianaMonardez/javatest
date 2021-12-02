package com.javatest.util;

public class StringUtilReto {
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() <= 0;
    }
}
