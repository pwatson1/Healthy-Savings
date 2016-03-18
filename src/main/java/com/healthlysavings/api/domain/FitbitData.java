package com.healthlysavings.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by yash.
 */
@Entity
@Table(name = "FitbitData")
public class FitbitData {


    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String userId;

    @NotNull
    private Date date;

    @NotNull
    private int score;

    //Constructor
    public FitbitData(String userId, Date date, int score) {
        this.userId = userId;
        this.date = date;
        this.score = score;
    }

    public FitbitData(){}

    @Override
    public String toString(){
        return "UserID: " + userId + "Date: " + date + "Score: ";
    }


    //Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}
}
