package com.example.SimpleOnlineShop.feature.wallet.controller;

import com.example.SimpleOnlineShop.feature.wallet.dto.WalletModelDto;
import com.example.SimpleOnlineShop.feature.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping
    public WalletModelDto getWallet(){
        return walletService.getWalletForLoggedUser();
    }

    @PostMapping
    public WalletModelDto createWallet(@RequestBody WalletModelDto walletModelDto){
        return walletService.createWallet(walletModelDto);
    }

    @DeleteMapping("{walletId}")
    public void deleteWallet(@PathVariable Long walletId){
        walletService.deleteWallet(walletId);
    }
}
