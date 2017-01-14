package com.player.repository;

import com.player.model.Wallet;

import java.util.List;

/**
 * Created by root_pc on 1/14/2017.
 */


public interface DatabaseService {

    int createWallet(Wallet wallet);

    int updateWallet(Wallet wallet);

    List<Wallet> getAllWallets();
}
