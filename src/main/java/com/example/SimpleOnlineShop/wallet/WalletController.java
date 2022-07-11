package com.example.SimpleOnlineShop.wallet;

import lombok.AllArgsConstructor;
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
