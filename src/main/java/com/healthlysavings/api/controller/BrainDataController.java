package com.healthlysavings.api.controller;

import com.healthlysavings.api.domain.*;
import com.healthlysavings.api.repository.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

/**
 * Created by simonhamermesh on 3/12/16.
 */
@RestController
public class BrainDataController {


    @Autowired
    private BrainDataDAO brainDataDAO;

    @RequestMapping("/get-brain-data")
    @ResponseBody
    public String getBrainData(){

        String retStr = "";
        Iterable<BrainData> brainDatas = brainDataDAO.findAll();
        Gson gson = new Gson();
        return gson.toJson(brainDatas);

        /*for(BrainData b : brainDatas){
            retStr += b.toString();
            retStr += System.lineSeparator();
        }

        return retStr;*/
    }

    @RequestMapping("/get-brain-by-id")
    @ResponseBody
    public String getBrainDataByID(String userId){

        Gson gson = new Gson();
        return gson.toJson(brainDataDAO.findByUserId(userId));
        //return userId;
    }

    @RequestMapping("/get-brain-data-by-IdAndDate")
    @ResponseBody
    public int getBrainDataByIDandDate(String userId, Date date){

        Gson gson = new Gson();
        BrainData brainData = brainDataDAO.findByUserIdAndDate(userId,date);
        return brainData.getScore();
    }

    @RequestMapping("/get-brain-data-by-score")
    @ResponseBody
    public String getBrainDataByScore(int score){

        Gson gson = new Gson();
        return gson.toJson(brainDataDAO.findByScore(score));
    }

    @RequestMapping("/get-brain-data-by-date")
    @ResponseBody
    public String getBrainDataByDate(Date date){

        Gson gson = new Gson();
        return gson.toJson(brainDataDAO.findByDate(date));
    }

    @RequestMapping("/create-brain_data")
    @ResponseBody
    public void createBrainData(String userId, Date date, int score){

        BrainData brainData = new BrainData(userId,date,score);
        brainDataDAO.save(brainData);
    }
}
