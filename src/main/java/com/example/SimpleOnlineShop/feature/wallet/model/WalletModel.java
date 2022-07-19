package com.example.SimpleOnlineShop.feature.wallet.model;

import com.example.SimpleOnlineShop.feature.user.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double moneyAmount;

    @OneToOne
    private UserModel owner;
}
