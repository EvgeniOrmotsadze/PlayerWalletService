package com.player.service;

import com.player.model.Wallet;
import com.player.repository.DatabaseService;

import java.sql.SQLException;

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

    public void createWallet(String walletName) throws Exception {
        Wallet wallet = new Wallet();
        wallet.setPlayerId(playerId);
        wallet.setName(walletName);
        wallet.setBalance(0.0);
        //create in memory
        memoryCache.putWallet(playerId, wallet);

        //create in DB
        dbServices.createWallet(wallet);
    }

    public void deposit(double amount) throws SQLException {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative deposit doesn't supported");
        }

        //update in memory
        Wallet wallet = this.memoryCache.getWallet(playerId);
        synchronized (wallet) {  // for thread safe
            wallet.setBalance(wallet.getBalance() + amount);
            //update in DB
            dbServices.updateWallet(wallet);
        }
    }

    public void withdraw(double amount) throws SQLException {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative withdraw doesn't supported");
        }

        Wallet wallet = this.memoryCache.getWallet(playerId);

        if (amount > wallet.getBalance()) {
            throw new IllegalArgumentException("Not enough balance");
        }
        //update in memory
        synchronized (wallet) { // for thread safe
            wallet.setBalance(wallet.getBalance() - amount);
            //update in DB
            dbServices.updateWallet(wallet);
        }
    }

    /*
     * retrieve from memory
     */
    public Double retrievalBalance(){
        Wallet wallet = this.memoryCache.getWallet(playerId);
        return wallet.getBalance();
    }

}
