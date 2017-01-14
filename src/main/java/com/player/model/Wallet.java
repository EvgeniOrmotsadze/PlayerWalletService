package com.player.model;

/**
 * Created by root_pc on 1/14/2017.
 */

public class Wallet {

    private long id;
    private long playerId;
    private double balance;
    private String name;


    public Wallet(){}

    public void createWallet(long playerId, double balance){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getPlayerId(){
        return this.playerId;
    }

    public void setPlayerId(long playerId){
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

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        this.balance -= amount;
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
