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

     public int createWallet(Wallet wallet) {
        Connection conn = null;
        try {
            conn = DatabaseProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into wallet.player_wallet (player_id,balance,name) values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, wallet.getPlayerId());
            ps.setDouble(2, 0.0);
            ps.setString(3, wallet.getName());
            int rs = ps.executeUpdate();
            ps.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateWallet(Wallet wallet){
        Connection conn = null;
        try {
            conn = DatabaseProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "update wallet.player_wallet set balance = ? where player_id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, wallet.getBalance());
            ps.setInt(2, wallet.getPlayerId());
            int code = ps.executeUpdate();
            ps.close();
            return code;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Wallet> getAllWallets(){
        Connection conn = null;
        List<Wallet> wallets = new ArrayList<Wallet>();
        try {
            conn = DatabaseProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from wallet.player_wallet ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Wallet wallet = new Wallet();
                wallet.setId(rs.getInt("id"));
                wallet.setName(rs.getString("name"));
                wallet.setPlayerId(rs.getInt("player_id"));
                wallet.setBalance(rs.getDouble("balance"));

                wallets.add(wallet);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallets;
    }

}
