package com.example.paystackwalletintegration.controller;

import com.example.paystackwalletintegration.dto.SignUpDto;
import com.example.paystackwalletintegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> createUser(@RequestBody SignUpDto signUpDto){
        System.out.println(signUpDto);
        String signUp = userService.registerUser(signUpDto);

        return new ResponseEntity<>(signUp, HttpStatus.CREATED);
    }

}
