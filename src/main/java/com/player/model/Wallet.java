package com.player.model;

/**
 * Created by root_pc on 1/14/2017.
 */

public class Wallet {

    private long id;
    private Integer playerId;
    private double balance;
    private String name;


    public Wallet(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance(){
        return this.balance;
    }


    public void setBalance(double balance){
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", balance=" + balance +
                '}';
    }
}
