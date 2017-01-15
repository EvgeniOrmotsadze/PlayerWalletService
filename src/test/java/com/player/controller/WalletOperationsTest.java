package com.player.controller;

import com.player.repository.DatabaseService;
import com.player.service.WalletService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

/**
 * Created by root_pc on 1/14/2017.
 * Tests are for wallet operations
 */


public class WalletOperationsTest {

    @Mock private DatabaseService dbServices;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositWallet() throws Exception {
        WalletService walletService = new WalletService(100,dbServices);
        walletService.createWallet();
        walletService.deposit(10.0);
        assertEquals(walletService.retrievalBalance(), 10.0, 0.0);
    }

    @Test
    public void withdrawWallet() throws Exception {
        WalletService walletService = new WalletService(100,dbServices);
        walletService.createWallet();
        walletService.deposit(100);
        walletService.withdraw(80);
        assertEquals(walletService.retrievalBalance(), 20.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositNegative() throws Exception {
        WalletService walletService = new WalletService(100,dbServices);
        walletService.createWallet();
        walletService.deposit(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawNegative() throws Exception {
        WalletService walletService = new WalletService(100,dbServices);
        walletService.createWallet();
        walletService.withdraw(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEnoughBalance() throws Exception {
        WalletService walletService = new WalletService(100,dbServices);
        walletService.createWallet();
        walletService.deposit(10);
        walletService.withdraw(16);
    }


}
