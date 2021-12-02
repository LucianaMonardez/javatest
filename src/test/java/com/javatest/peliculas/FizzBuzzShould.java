package com.javatest.peliculas;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzShould {

    //Si el número es divisible por 3, retorna “Fizz”
    //Si el número es divisible por 5, retorna “Buzz”
    //Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
    //En otro caso, retorna el mismo número


    @Test
    public void number_is_divisible_by_3() {
        assertThat(FizzBuzz.ValidateFizzbuzz(3), CoreMatchers.is("Fizz"));
    }
    @Test
    public void number_is_divisible_by_5() {
        assertThat(FizzBuzz.ValidateFizzbuzz(5), CoreMatchers.is("Buzz"));
    }
    @Test
    public void number_is_divisible_by_5_and_by_3() {
        assertThat(FizzBuzz.ValidateFizzbuzz(15), CoreMatchers.is("FizzBuzz"));
    }
    @Test
    public void number_is_other() {
        assertThat(FizzBuzz.ValidateFizzbuzz(2), CoreMatchers.is( "2"));
    }
    //extra

}