package com.healthlysavings.api.controller;



/**
 * Created by jrdavis on 3/14/16.
 */

import com.healthlysavings.api.domain.CapitalOneCustomer;
import com.healthlysavings.api.domain.User;
import com.healthlysavings.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jrdavis on 3/7/16.
 */



@Controller
public class UserController {


    @Autowired
    private UserRepository userDao;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /create  --> Create a new user and save it in the database.
     *
     * @param email User's email
     * @param Firstname User's first name
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping(value ="/user/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody CapitalOneCustomer capitalOneCustomer, String email, Double userHeight, Double userWeight, String ThirdPartyChoice, String userGender) {
      User user;
        try {
            user = new User(capitalOneCustomer, email, userHeight, userWeight, ThirdPartyChoice, userGender);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    /**
     * /delete  --> Delete the user having the passed id.
     *
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/user/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        String userName;
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
            userName = String.valueOf(user.getFirst_name());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId + "user name: " + userName;
    }
    @RequestMapping("/get-by-id")
    @ResponseBody
    public String getByID(Long id) {

        String userEmail;
        String userName;
        try {
            User user = userDao.findById(id);
            userEmail = String.valueOf(user.getEmail());
            userName = String.valueOf(user.getFirst_name());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user email is: " + userEmail+ "user name: " + userName;
    }
    /**
     * /update  --> Update the email and the name for the user in the database
     * having the passed id.
     *
     * @param id The id for the user to update.
     * @param email The new email.
     * @param first_name The new name.
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping("/user/update")
    @ResponseBody
    public String updateUser(long id, String email, String third_party, String first_name, String last_name,  String userGender, Double userHeight, Double userWeight) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setThirdPartyChoice(third_party);
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            user.setUserWeight(userWeight);
            user.setUserHeight(userHeight);
            user.setUserGender(userGender);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }


    //** Update ---> update the third party app for the user
    //having the passed id.User
    //

    @RequestMapping("/user/updatethirdparty")
    @ResponseBody
    public String updateUser(long id, String third_party) {
        try {
            User user = userDao.findOne(id);
            user.setThirdPartyChoice(third_party);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the third party application: " + ex.toString();
        }
        return "Third Party Application succesfully updated!";
    }
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------



}