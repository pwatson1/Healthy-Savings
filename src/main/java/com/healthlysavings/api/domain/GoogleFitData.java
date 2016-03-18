package com.healthlysavings.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by pwatson on 3/14/16.
 */

    @Entity
    @Table(name = "GoogleFitData")
    public class GoogleFitData{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long Id;

    @NotNull
    private String userId;

        @NotNull
        private Date date;

        @NotNull
        private int score;

        //Constructor
        public GoogleFitData(String userId, Date date, int score) {
            this.userId = userId;
            this.date = date;
            this.score = score;


    }

    public GoogleFitData() {}

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

        public long getId() {return Id;}

        public void setId(long id) {this.Id = id;}
}

