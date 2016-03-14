package com.healthlysavings.api.controller;



/**
 * Created by jrdavis on 3/14/16.
 */

import com.healthlysavings.api.domain.User;
import com.healthlysavings.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String Firstname, String userAddress, String userGender, Double userHeight, Double userWeight) {
        User user = null;
        try {
            user = new User(email, Firstname, userAddress, userGender, userHeight, userWeight);
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
    @RequestMapping("/delete")
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
            userName = String.valueOf(user.getFirstName());
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
            userName = String.valueOf(user.getFirstName());
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
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String first_name, String userAddress, String userGender, Double userHeight, Double userWeight) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(first_name);
            user.setUserAddress(userAddress);
            user.setUserGender(userGender);
            user.setUserHeight(userHeight);
            user.setUserWeight(userWeight);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------



}