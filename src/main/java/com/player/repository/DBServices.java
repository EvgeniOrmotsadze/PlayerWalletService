package com.player.repository;

import com.player.model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by root_pc on 1/14/2017.
 */


public class DBServices {

    public int createWallet(int playerId,String walletName){
        Connection conn = null;
        try {
            conn = DBProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into wallet.player_wallet (player_id,balance,name) values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, playerId);
            ps.setDouble(2, 0.0);
            ps.setString(3, walletName);
            int rs = ps.executeUpdate();
            ps.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Wallet getWallet(int playerId){
        Connection conn = null;
        Wallet wallet = null;
        try {
            conn = DBProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from wallet.player_wallet where player_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, playerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                wallet = new Wallet();
                wallet.setName(rs.getString("name"));
                wallet.setPlayerId(playerId);
                wallet.setBalance(rs.getDouble("balance"));
            }
            ps.close();
            return wallet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallet;
    }

    public int updateWallet(int playerId,double amount){
        Connection conn = null;
        try {
            conn = DBProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double oldBalance = getWallet(playerId).getBalance();
        double newBalance = oldBalance + amount;
        String sql = "update wallet.player_wallet set balance = ? where player_id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, newBalance);
            ps.setInt(2, playerId);
            int code = ps.executeUpdate();
            ps.close();
            return code;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
