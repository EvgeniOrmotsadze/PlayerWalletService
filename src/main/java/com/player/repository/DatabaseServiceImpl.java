package com.player.repository;

import com.player.model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root_pc on 1/14/2017.
 */


public class DatabaseServiceImpl implements DatabaseService{

     public void createWallet(Wallet wallet) throws Exception {
        Connection conn = null;
        try {
            conn = DatabaseProvider.getConnection();
        } catch (SQLException e) {
            throw new SQLException("can't open connection");
        }
         String sql = "select * from wallet.player_wallet where player_id = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1,wallet.getPlayerId());
         ResultSet rs = ps.executeQuery();
         if(rs.next()){
             throw new Exception("already has wallet");
         }
         sql = "insert into wallet.player_wallet (player_id,balance) values (?,?)";
         try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, wallet.getPlayerId());
            ps.setDouble(2, 0.0);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw  new Exception("can't update wallet");
        }
    }

    public void updateWallet(Wallet wallet) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseProvider.getConnection();
        } catch (SQLException e) {
            throw new SQLException("can't open connection");
        }
        String sql = "update wallet.player_wallet set balance = ? where player_id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, wallet.getBalance());
            ps.setInt(2, wallet.getPlayerId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException("can't update wallet");
        }
    }

    public List<Wallet> getAllWallets() throws SQLException {
        Connection conn = null;
        List<Wallet> wallets = new ArrayList<Wallet>();
        try {
            conn = DatabaseProvider.getConnection();
        } catch (SQLException e) {
            throw new SQLException("can't open connection");
        }
        String sql = "select * from wallet.player_wallet ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Wallet wallet = new Wallet();
                wallet.setId(rs.getInt("id"));
                wallet.setPlayerId(rs.getInt("player_id"));
                wallet.setBalance(rs.getDouble("balance"));
                wallets.add(wallet);
            }
            ps.close();
        } catch (SQLException e) {
            throw new SQLException("can't get all wallet");
        }
        return wallets;
    }


}
