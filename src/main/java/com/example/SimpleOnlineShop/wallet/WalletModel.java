package com.example.SimpleOnlineShop.wallet;

import com.example.SimpleOnlineShop.user.UserModel;
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
