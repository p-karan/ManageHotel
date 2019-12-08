package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Users;
import com.stays.hotelmanagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean checkUserExist(String userName) {
        boolean isUserPresent = false;
        Optional<Users> user = Optional.ofNullable(this.userRepository.findUsersByUserName(userName));
        if (user.isPresent()) {
            isUserPresent = true;
        }
        return isUserPresent;
    }

    //Update an existing User
    public boolean updateUser(Users existingUser) {
        this.userRepository.save(existingUser);
        return true;
    }

    //Find All Users
    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    //Find User by User_Id
    public Users getUserById(String userId) {
        Users userFoundById = new Users();
        Optional<Users> user = this.userRepository.findById(userId);
        log.info("User entered :" + userId);
        log.info("DB returned :" + userId);
        if (user.isPresent()) {
            userFoundById = user.get();
        } else {
            // Add logic to check for null user.
        }
        log.info(String.valueOf(userFoundById));
        return userFoundById;
    }

    //Find User by User_Name
    public Users getUserByUserName(String userName) {
        Users userFoundByUserName = new Users();
        Optional<Users> user = Optional.ofNullable(this.userRepository.findUsersByUserName(userName));
        log.info("User entered :" + userName);
        log.info("DB returned :" + userName);
        if (user.isPresent()) {
            userFoundByUserName = user.get();
        } else {
            // Add logic to check for null user.
        }
        log.info(String.valueOf(userFoundByUserName));
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
    public boolean deleteUserbyUserName(String userName) {
        boolean isdeleteSuccessfull = false;
        Optional<Users> user = Optional.ofNullable(this.userRepository.findUsersByUserName(userName));
        this.userRepository.deleteById(user.get().getUserId());
        boolean isPresent = this.userRepository.existsById(user.get().getUserId());
        if(!isPresent){
            isdeleteSuccessfull = true;
        }
        return isdeleteSuccessfull;
    }
}