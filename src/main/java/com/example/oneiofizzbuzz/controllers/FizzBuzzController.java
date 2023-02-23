package com.example.oneiofizzbuzz.controllers;

import com.example.oneiofizzbuzz.services.FizzBuzzService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/fizzbuzz")
public class FizzBuzzController {

    Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping
    @ResponseBody
    public String getBuzzFizz(@RequestParam() @Min(value = 1, message = "Number must be positive") Integer number) {
        logger.debug("Get fizzbuzz string for number {}", number);
        return fizzBuzzService.generateString(number);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleRunTimeException(RuntimeException ex) {
        logger.error("Run time exception error", ex);
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
