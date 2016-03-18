package com.healthlysavings.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private long userId;

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

    public Finance(java.sql.Date date, long userId, double balance, double dailyAccrual, double bonusAPY, double bonusAccrual){
        setUserId(userId);
        setBalance(balance);
        setDailyAccrual(dailyAccrual);
        setBonusAPY(bonusAPY);
        setBonusAccrual(bonusAccrual);
        setDate(date);
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
}
