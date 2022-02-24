package com.example.paystackwalletintegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WalletModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_id")
    @SequenceGenerator(name = "wallet_id", initialValue = 1000, allocationSize = 1)
    private Long walletId;

    @Column(nullable = false)
    private int accountBalance;
}
