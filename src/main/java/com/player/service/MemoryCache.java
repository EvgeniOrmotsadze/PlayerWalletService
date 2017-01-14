package com.player.service;

import com.player.model.Wallet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root_pc on 1/14/2017.
 */
public class MemoryCache {

    private static final MemoryCache instance = new MemoryCache();

    private final Map<Integer, Wallet> wallets = new HashMap<Integer, Wallet>();

    private MemoryCache () {}

    public static MemoryCache getInstance() {
        return instance;
    }

    public Wallet getWallet(Integer playerId) {
        return wallets.get(playerId);
    }

    public void putWallet(Integer playerId, Wallet wallet) {
        wallets.put(playerId, wallet);
    }

}
