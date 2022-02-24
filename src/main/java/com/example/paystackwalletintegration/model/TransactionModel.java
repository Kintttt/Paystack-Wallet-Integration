package com.example.paystackwalletintegration.model;

import com.example.paystackwalletintegration.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id")
    @SequenceGenerator(name = "transaction_id", initialValue = 10000, allocationSize = 1)
    private Long transactionId;

    @ManyToOne
    private WalletModel walletModel;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int prevBalance;

    @Column(nullable = false)
    private int newBalance;

    @ManyToOne
    private UserModel user;

    @Column(nullable = false)
    private TransactionStatus transactionStatus;



}
