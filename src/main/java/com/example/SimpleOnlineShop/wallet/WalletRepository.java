package com.example.SimpleOnlineShop.wallet;

import com.example.SimpleOnlineShop.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletModel, Long> {

    Optional<WalletModel> findByOwner(UserModel userModel);
    Optional<WalletModel> findByOwnerAndId(UserModel userModel, Long id);

}
