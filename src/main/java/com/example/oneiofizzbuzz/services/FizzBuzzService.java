package com.example.oneiofizzbuzz.services;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {

    public String generate(Integer number) {

        return IntStream.rangeClosed(1, number).mapToObj(i -> getString(i)).collect(Collectors.joining(", "));
    }

    public String getString(Integer number) {
        return number % 3 == 0 ?
            (number % 5 == 0 ? "FizzBuzz" : "Fizz") :
            (number % 5 == 0 ? "Buzz" : Integer.toString(number));
    }
}
