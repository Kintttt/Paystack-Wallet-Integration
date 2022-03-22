package com.example.paystackwalletintegration.controller;

import com.example.paystackwalletintegration.dto.SignUpDto;
import com.example.paystackwalletintegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/home")
    public String Home(){
        System.out.println("got to login");
        return "Welcome Home";
    }

}
