package com.example.oneiofizzbuzz.controllers;

import com.example.oneiofizzbuzz.services.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {FizzBuzzController.class, FizzBuzzService.class})
@WebMvcTest
public class FizzBuzzControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetFizzBuzz() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/fizzbuzz")
                .param("number", "15"))
            .andExpect(status().isOk())
            .andReturn();

        String resultStr = result.getResponse().getContentAsString();
        String expected = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz";

        assertEquals(expected, resultStr);
    }

    @Test
    public void testGetFizzBuzzInvalidParam() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/fizzbuzz")
                .param("number", "-5"))
            .andExpect(status().isBadRequest())
            .andReturn();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/fizzbuzz")
                .param("number", "abc"))
            .andExpect(status().isBadRequest())
            .andReturn();
    }
}
