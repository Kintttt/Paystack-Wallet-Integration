package com.example.paystackwalletintegration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Message {

    @GetMapping("/")
    public String message(){
        return "Hello, this project is built using Spring Security and Webclient to call the paystack's api";
    }
}
