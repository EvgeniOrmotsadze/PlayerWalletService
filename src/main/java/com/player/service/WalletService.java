package com.player.service;

import com.player.model.Wallet;
import com.player.repository.DatabaseService;
import com.player.repository.DatabaseServiceImpl;

/**
 * Created by root_pc on 1/14/2017.
 */

public class WalletService {

    private int playerId;
    private DatabaseService dbServices;
    private MemoryCache memoryCache;

    public WalletService(int playerId,DatabaseService dbServices){
        this.playerId = playerId;
        this.dbServices = dbServices;
        this.memoryCache = MemoryCache.getInstance();
    }

    public int createWallet(String walletName){
        Wallet wallet = new Wallet();
        wallet.setPlayerId(playerId);
        wallet.setName(walletName);
        wallet.setBalance(0.0);
        //create in memory
        memoryCache.putWallet(playerId, wallet);

        //create in DB
        DatabaseServiceImpl dbServices = new DatabaseServiceImpl();
        return dbServices.createWallet(wallet);
    }

    public void deposit(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Negative deposit doesn't supported");
        }

        //update in memory
        Wallet wallet = this.memoryCache.getWallet(playerId);
        wallet.setBalance(wallet.getBalance() + amount);

        //update in DB
        dbServices.updateWallet(wallet);
    }

    public void withdraw(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Positive withdraw doesn't supported");
        }

        Wallet wallet = this.memoryCache.getWallet(playerId);

        if (amount > wallet.getBalance()) {
            throw new IllegalArgumentException("Not enough balance");
        }

        //update in memory
        wallet.setBalance(wallet.getBalance() - amount);

        //update in DB
        dbServices.updateWallet(wallet);
    }

    public Double retrievalBalance(){
        //retrieve from memory
        Wallet wallet = this.memoryCache.getWallet(playerId);
        return wallet.getBalance();
    }

}
