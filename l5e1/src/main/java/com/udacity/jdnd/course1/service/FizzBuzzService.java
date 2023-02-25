package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) {
        if( number < 1){
            throw  new IllegalArgumentException();
        }
        String returnValue = "";
        if(number %3 == 0){
            returnValue+= "Fizz";
        }
        if(number % 5 == 0){
            returnValue += "Buzz";
        }
        if(number %3 != 0 && number %5 != 0){
            returnValue += number;
        }

        return returnValue;
    }
}
