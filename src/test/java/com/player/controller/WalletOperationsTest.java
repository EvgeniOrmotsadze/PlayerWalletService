package com.player.controller;

import com.player.repository.DatabaseServiceImpl;
import com.player.service.WalletService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

/**
 * Created by root_pc on 1/14/2017.
 */


public class WalletOperationsTest {

    @Mock private DatabaseServiceImpl dbServices;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositWallet(){
        WalletService walletService = new WalletService(1,dbServices);
        walletService.createWallet("test");
        walletService.deposit(10);
        assertEquals(walletService.retrievalBalance(), 10.0, 0.0);
    }

    @Test
    public void withdrawWallet(){
        WalletService walletService = new WalletService(1,dbServices);
        walletService.createWallet("test");
        walletService.deposit(100);
        walletService.withdraw(80);
        assertEquals(walletService.retrievalBalance(), 20.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositNegative(){
        WalletService walletService = new WalletService(2,dbServices);
        walletService.createWallet("test");
        walletService.deposit(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawNegative(){
        WalletService walletService = new WalletService(2,dbServices);
        walletService.createWallet("test");
        walletService.deposit(-10);
    }

}
