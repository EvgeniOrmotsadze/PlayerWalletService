package com.player.repository;

import com.player.model.Wallet;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by root_pc on 1/14/2017.
 */


public interface DatabaseService {

    void createWallet(Wallet wallet) throws Exception;

    void updateWallet(Wallet wallet) throws SQLException;

    List<Wallet> getAllWallets() throws SQLException;
}
