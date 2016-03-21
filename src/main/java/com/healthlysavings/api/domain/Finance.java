package com.healthlysavings.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Doc on 3/14/16.
 */

@Entity
public class Finance{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private java.sql.Date date;

    @NotNull
    @Column(unique = true)
    private String userId;

    @NotNull
    private double balance;

    @NotNull
    private double dailyAccrual;

    @NotNull
    private double bonusAPY;

    @NotNull
    private double bonusAccrual;

    public Finance(){

    }

    public Finance(java.sql.Date date, String userId, int score){
        setUserId(userId);
        setDate(date);
        setFinances(score);
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDailyAccrual() {
        return dailyAccrual;
    }

    public void setDailyAccrual(double dailyAccrual) {
        this.dailyAccrual = dailyAccrual;
    }

    public double getBonusAPY() {
        return bonusAPY;
    }

    public void setBonusAPY(double bonusAPY) {
        this.bonusAPY = bonusAPY;
    }

    public double getBonusAccrual() {
        return bonusAccrual;
    }

    public void setBonusAccrual(double bonusAccrual) {
        this.bonusAccrual = bonusAccrual;
    }

    public void setFinances(int score){

        /**
         * Set the balance as the previous day's balance. For now the first Finance Object for each User will be created on new User creation.
         * In the future,
         * **/
    }

}
