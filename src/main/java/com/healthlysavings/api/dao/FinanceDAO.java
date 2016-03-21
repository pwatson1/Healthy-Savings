package com.healthlysavings.api.dao;

import com.healthlysavings.api.domain.Finance;
import com.healthlysavings.api.repository.FinanceRepository;
import com.healthlysavings.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by simonhamermesh on 3/21/16.
 */

public class FinanceDAO {

    @Autowired
    static FinanceRepository financeRepository;
    @Autowired
    static UserRepository userRepository;

    private static Date date;
    private static String userId;

    private static int score;

    private static double balance;

    private static double baseAPY = 0.6;
    private static double dailyAccrual;

    private static double scoreFactor;
    private static double maxBonusAPY = 0.6;

    private static double bonusAPY;
    private static double bonusAccrual;


    public static Finance firstFinanceRecordForNewUser(String userId, double balance){

        java.util.Date today = new java.util.Date();
        java.sql.Date sqltoday = new java.sql.Date(today.getTime());

        return new Finance(sqltoday, userId, balance,0,0,0);
    }

    public static Finance returnNewFinanceObject(java.sql.Date idate, String iuserId, int iscore){

        date = idate;
        userId = iuserId;
        score = iscore;

        makeBalance();
        makeDailyAccrual();
        makeBonus();

        return new Finance(date,userId,balance,dailyAccrual,bonusAPY,bonusAccrual);
    }

    private static void makeBalance(){

        /**
         * Set the balance as the previous day's balance. For now the first Finance Object for each User will be created on new User creation.
         * In the future, the balance will be updated at the end of the month to reflect monthly compounding.
         * **/

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        java.sql.Date yesterday = new java.sql.Date(calendar.getTime().getTime());


        balance = financeRepository.findByUserIdAndDate(userId,yesterday).getBalance();
    }

    private static void makeDailyAccrual(){
        dailyAccrual = (baseAPY/365) * balance;
    }

    private static void makeBonus(){
        calculateScoreFactor();
        bonusAPY = scoreFactor * score * maxBonusAPY;

        bonusAccrual = (bonusAPY/365) * balance;
    }

    private static void calculateScoreFactor(){
        scoreFactor = (userRepository.findById(userId).getUserWeight() / userRepository.findById(userId).getUserHeight());

        /** This is an example of a way to calculate a score factor. In this case, the user's weight is divided by their height.
         *  Taller people will have lower factor, heavier people will have a higher factor.
         *
         *  THIS MEANS NOTHING. DON'T WORRY ABOUT THIS. THIS SHOULD AVERAGE OUT TO ABOUT 0.3 WITH
         *  PEOPLE WEIGHING THREE TIMES MORE THAN THEIR HEIGHT.
         *
         *  AGAIN THIS MEANS NOTHING; THIS COULD JUST AS EASILY BE SET TO A STATIC NUMBER OR EXPANDED TO COMPLEX
         *  CALCULATIONS BASED ON THE USERS CHARACTERISTICS.
         */
    }

}
