package com.example.paystackwalletintegration.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class WalletModel {
    @Id
    private Long walletId;
}
