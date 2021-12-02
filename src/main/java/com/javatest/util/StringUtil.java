package com.javatest.util;

public class StringUtil {
    public static String repeat(String str, int times){
        String result = "";

        if(times < 0)
        {
            throw new IllegalArgumentException("negatives times not allowed");
        }
        for (int i = 0; i < times; i++) {
            result +=str;

        }
        return result;
    }
}
