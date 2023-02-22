package com.example.oneiofizzbuzz.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzServiceTest {

    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @Test
    void testGenerateString() {
        String fizzBuzzStr = fizzBuzzService.generateString(16);
        String expected = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16";
        assertEquals(expected, fizzBuzzStr);
    }

}
