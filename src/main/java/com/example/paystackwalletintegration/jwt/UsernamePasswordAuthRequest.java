package com.example.paystackwalletintegration.jwt;

import lombok.Data;

@Data
public class UsernamePasswordAuthRequest {
    private String username;
    private String password;

    public UsernamePasswordAuthRequest() {
    }
}
