package com.example.SimpleOnlineShop.feature.wallet.dto;

import com.example.SimpleOnlineShop.feature.wallet.model.WalletModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletModelDto {

    private Long id;
    private Double moneyAmount;

    public static WalletModelDto of(final WalletModel walletModel){
        return new WalletModelDto(
                walletModel.getId(),
                walletModel.getMoneyAmount()
        );
    }
}
