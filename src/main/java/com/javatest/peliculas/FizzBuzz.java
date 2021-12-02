package com.javatest.peliculas;

public class FizzBuzz {


    public static String ValidateFizzbuzz(int number) {
        String result = "";
        if (number % 3 == 0 ) result = "Fizz";
        if (number % 5 == 0 ) result += "Buzz";
        return result.isEmpty() ?  String.valueOf(number) : result;
    }
}
