package com.udacity.jdnd.course1.service;

public class BuzzFizzService {
    public int buzzFizz(String input, int occurrence) {
        if (input.equals("Fizz")) {
            return 3 * occurrence;
        } else if (input.equals("Buzz")) {
            return 5 * occurrence;
        } else if (input.equals("FizzBuzz")) {
            return 15 * occurrence;
        } else {
            return Integer.valueOf(input);
        }
    }
}
