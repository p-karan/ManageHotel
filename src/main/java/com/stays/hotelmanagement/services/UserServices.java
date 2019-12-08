package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Users;
import com.stays.hotelmanagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    //Add a new User
    public Users addUser(Users newUser) {
        return this.userRepository.save(newUser);
    }

    //Check user exists, before updating.
    public int checkUserExist(String checkUser) {
 /*       boolean isUserPresent = false;
        Optional<Users> user = Optional.ofNullable(this.userRepository.findUsersByUserName(checkUser));
        if (user.isPresent()) {
            isUserPresent = true;
        }
        return isUserPresent;*/

        //Users userFoundById = new Users();
        ArrayList<Users> userList = (ArrayList<Users>) getAllUsers();
       // int userFound = userList.indexOf(checkUser);
        int userFound = userList.indexOf(checkUser);
        System.out.println(userFound+"Fake");
        return userFound;
    }

    //Update an existing User
    public Users updateUser(Users existingUser) {
        return this.userRepository.save(existingUser);
    }

    //Find All Users
    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    //Find User by User_Id
    public Users getUserById(String userId) {
        Users userFoundById;
        int userFound=checkUserExist(userId);
        if(userFound!=0){
            userFoundById = this.userRepository.findById(userId).get();
        }else{
            userFoundById = new Users();
        }

        /*Optional<Users> user = this.userRepository.findById(userId);
        log.info("User entered :" + userId);
        log.info("DB returned :" + userId);
        if (user.isPresent()) {
            userFoundById = user.get();
        } else {
            // Add logic to check for null user.
        }
        log.info(String.valueOf(userFoundById));
        return userFoundById;*/

        /*boolean isUserPresent=checkUserExist(userId);
        System.out.println(isUserPresent);
        if(isUserPresent){
            userFoundById = this.userRepository.findById(userId).get();
        }*/
        return userFoundById;
    }

    //Find User by User_Name
    public Users getUserByUserName(String userName) {
        Users userFoundByUserName=new Users();
        int userFound=checkUserExist(userName);
        if(userFound!=0){
            userFoundByUserName = this.userRepository.findUsersByUserName(userName);
        }





/*        Users userFoundByUserName = new Users();
        Optional<Users> user = Optional.ofNullable(this.userRepository.findUsersByUserName(userName));
        log.info("User entered :" + userName);
        log.info("DB returned :" + userName);
        if (user.isPresent()) {
            userFoundByUserName = user.get();
        } else {
            // Add logic to check for null user.
        }
        log.info(String.valueOf(userFoundByUserName));*/
        return userFoundByUserName;
    }

    /*//Delete User by User_Id
    public String deleteUserById(String userId){
        String result = "User : " + userId + " not found.";
        Boolean isUserAvailable=this.userRepository.existsById(userId);

        if(isUserAvailable){
            this.userRepository.deleteById(userId);
            result = "User : " + userId + " deleted.";
        }
        return result;
    }*/
    
    //Delete User 
    public boolean deleteUserByUserId(String userId) {
        boolean isDeleteSuccessful = false;
        int userFound=checkUserExist(userId);
        if(userFound!=0){
            this.userRepository.deleteById(userId);
            boolean isUserPresent=this.userRepository.existsById(userId);
            if(!isUserPresent){
                isDeleteSuccessful=true;
            }
        }
        return isDeleteSuccessful;
    }
}