package com.javatest.util;

import  org.junit.Assert;
import org.junit.Test;


public class StringUtilTest {
//test con libreria
@Test
//en el nombre de la funcion debemos indicar que es lo que estamos probando
    public void repeat_string_multiple_times() {

        //primero va el expeceted
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3) );
        /*
        System.out.println(StringUtil.repeat("hola",3));
        if (!StringUtil.repeat("hola",3).equals(("holaholahola"))){
            throw new RuntimeException("ERROR");
        }
         */
        //inline variable, se hace en refactor inline

        //System.out.println(StringUtil.repeat("hola",1));
    }

    /*private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equal to " + expected);
        }
    }
     */
    @Test
    public void repeat_string_once(){
        Assert.assertEquals("hola", StringUtil.repeat("hola",1));

    }
    @Test
    public void repeat_zero_times(){
        Assert.assertEquals("", StringUtil.repeat("hola",0));

    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_negative_times(){
        StringUtil.repeat("hola",-1);

    }


}