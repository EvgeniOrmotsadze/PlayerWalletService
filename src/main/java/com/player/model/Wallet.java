package com.player.model;

/**
 * Created by root_pc on 1/14/2017.
 */

public class Wallet {

    private long id;
    private long playerId;
    private double balance;


    public Wallet(){}

    public void createWallet(long playerId, int balance){

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


    public double getBalance(){
        return this.balance;
    }

    public int deposit(double amount){
        if(amount > 0) {
            this.balance += amount;
            return 0;
        }else {
            return -1;
        }
    }

    public int withdrawal(double amount){
        if(this.balance < amount ||amount <= 0 ){
            return  -1;
        }else{
            this.balance -= amount;
            return 0;
        }
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
