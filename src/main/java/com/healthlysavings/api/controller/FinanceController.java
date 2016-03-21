package com.healthlysavings.api.controller;

import com.healthlysavings.api.domain.Finance;
import com.healthlysavings.api.repository.FinanceDAO;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by Doc on 3/15/16.
 */

@RestController
public class FinanceController {
    @Autowired
    private FinanceDAO financeDAO;

    @RequestMapping("/finance/{user_id}")
    public ArrayList<Finance> getByUserID(@PathVariable(value="user_id") long id){
        return financeDAO.findByUserId(id);
    }


/**
    @RequestMapping(value = "/finance/{user_id}/", method = RequestMethod.POST)
    public Finance createFinancePost(@RequestBody Finance finance, @PathVariable(value="user_id") long id){
        finance.setUserId(id);
        try{
            return financeDAO.save(finance);
        }catch (Exception e){

        }
        return null;
    }
**/


    @RequestMapping(value = "/finance/create-finance")
    public Finance createFinancePost(java.sql.Date date, String userId, int score ){

        try{
            Finance newFinance = new Finance(date,userId,score);
            financeDAO.save(newFinance);
        }catch (Exception e){

        }
        return null;
}

}
