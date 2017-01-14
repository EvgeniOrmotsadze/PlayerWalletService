package com.player.controller;

import com.player.model.Wallet;
import com.player.repository.DatabaseService;
import com.player.repository.DatabaseServiceImpl;
import com.player.service.MemoryCache;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by root_pc on 1/14/2017.
 */

@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ContextListener() {}

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        MemoryCache memoryCache = MemoryCache.getInstance();
        DatabaseService databaseService = new DatabaseServiceImpl();
        List<Wallet> wallets = null;
        try {
            wallets = databaseService.getAllWallets();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Wallet wallet : wallets){
            memoryCache.putWallet(wallet.getPlayerId(),wallet);
            System.out.println(wallet);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
