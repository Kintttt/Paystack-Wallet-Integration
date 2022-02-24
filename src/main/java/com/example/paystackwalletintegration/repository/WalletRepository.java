package com.example.paystackwalletintegration.repository;

import com.example.paystackwalletintegration.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel, Long> {
}
