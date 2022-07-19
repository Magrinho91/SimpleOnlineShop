package com.example.SimpleOnlineShop.feature.wallet.service;

import com.example.SimpleOnlineShop.feature.user.model.UserModel;
import com.example.SimpleOnlineShop.feature.user.service.UserService;
import com.example.SimpleOnlineShop.feature.wallet.dto.WalletModelDto;
import com.example.SimpleOnlineShop.feature.wallet.model.WalletModel;
import com.example.SimpleOnlineShop.feature.wallet.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {

    private WalletRepository walletRepository;
    private UserService userService;

    public WalletModelDto getWalletForLoggedUser() {
        UserModel loggedUser = userService.getLoggedAccount();

        return WalletModelDto.of(walletRepository.findByOwner(loggedUser).orElseThrow());
    }

    public WalletModelDto createWallet(WalletModelDto walletModelDto) {
        UserModel loggedUser = userService.getLoggedAccount();

        WalletModel walletModelToCreate = WalletModel.builder()
                .moneyAmount(walletModelDto.getMoneyAmount())
                .owner(loggedUser)
                .build();

        return WalletModelDto.of(walletRepository.save(walletModelToCreate));
    }

    public void deleteWallet (Long walletId) {
        UserModel loggedUser = userService.getLoggedAccount();

        WalletModel walletToDelete = walletRepository.findByOwnerAndId(loggedUser, walletId).orElseThrow();

        walletRepository.delete(walletToDelete);
    }
}
