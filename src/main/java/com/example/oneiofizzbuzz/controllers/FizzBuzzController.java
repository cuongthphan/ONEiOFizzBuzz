package com.example.oneiofizzbuzz.controllers;

import com.example.oneiofizzbuzz.services.FizzBuzzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buzzfizz")
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping
    public String getBuzzFizz(Integer number) {
        return fizzBuzzService.generate(number);
    }
}
