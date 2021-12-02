package com.javatest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilRetoTest {
    //no es vacio, string vacio, null tammbien es vacio

    @Test
    public void string_is_not_empty(){
        assertFalse(StringUtilReto.isEmpty("asad"));
    }
    @Test
    public void string_is_empty(){
        assertTrue(StringUtilReto.isEmpty(""));
    }
    @Test
    public void string_is_null(){
        assertTrue(StringUtilReto.isEmpty(null));
    }
//Extra: un string con espacios " " también lo queremos considerar como vacío (pista: puedes usar la función trim)
    @Test
    public void string_is_space(){
        assertTrue(StringUtilReto.isEmpty(" "));
    }

}