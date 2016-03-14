package com.healthlysavings.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Doc on 3/14/16.
 */
public class Finance{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    private long userId;
    private double balance;
    private double dailyAccrual;
    private double bonusAPY;
    private double bonusAccrual;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
