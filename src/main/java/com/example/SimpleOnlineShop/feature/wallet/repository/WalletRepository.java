package com.example.SimpleOnlineShop.feature.wallet.repository;

import com.example.SimpleOnlineShop.feature.user.model.UserModel;
import com.example.SimpleOnlineShop.feature.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletModel, Long> {

    Optional<WalletModel> findByOwner(UserModel userModel);
    Optional<WalletModel> findByOwnerAndId(UserModel userModel, Long id);

}
