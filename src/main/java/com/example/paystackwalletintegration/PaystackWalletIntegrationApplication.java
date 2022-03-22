package com.example.paystackwalletintegration;

import com.example.paystackwalletintegration.jwt.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(JwtConfig.class)
@SpringBootApplication
public class PaystackWalletIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaystackWalletIntegrationApplication.class, args);
    }

}
