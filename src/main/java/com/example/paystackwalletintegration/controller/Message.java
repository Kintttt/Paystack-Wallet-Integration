package com.example.paystackwalletintegration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Message {

    @GetMapping("")
    public String message(){
        return "Hello, this project is built using Spring Security and Webclient to call the paystack's api";
    }

//    @GetMapping("/login")
//    public String Login(){
//        System.out.println("got to login in Message class");
//        return "Welcome Home";
//    }
}
