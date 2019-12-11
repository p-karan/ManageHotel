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
    /*public boolean checkUserExist(String userIdd) {
        boolean isUserPresent = false;
        Optional<Users> user = Optional.ofNullable(this.userRepository.findUsersByUserName(userName));
        if (user.isPresent()) {
            isUserPresent = true;
        }
        return isUserPresent;
    }*/

    //Update an existing User
    public Users updateUser(Users existingUser) {
        return this.userRepository.save(existingUser);
    }

    //Find All Users
    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    //Find User by User_Id
    public Users getUserById(int userId) {
        Users userFoundById = new Users();
        Optional<Users> user = this.userRepository.findById(userId);
        if (user.isPresent()) {
            userFoundById = user.get();
        }
        return userFoundById;
    }

    //Find User by User_Name
    public Users getUserByUserName(String userName) {
        Users userFoundByUserName = new Users();
        Optional<Users> user = this.userRepository.findUsersByUserName(userName);
        if (user.isPresent()) {
            userFoundByUserName = user.get();
        }
        return userFoundByUserName;
    }

    //Delete User
    public Users deleteUser(Users existingUser){
        Users deletedUser = new Users();
        Boolean isUserAvailable=this.userRepository.existsById(existingUser.getUserId());
        if(isUserAvailable){
            this.userRepository.delete(existingUser);
            deletedUser = existingUser;
        }
        return deletedUser;
    }

    //Delete User by UserName
    public Users deleteUserByUserName(String userName) {
        Users userDeletedByUserName = new Users();
        Optional<Users> user = this.userRepository.findUsersByUserName(userName);
        if(user.isPresent()){
            this.userRepository.deleteByUserName(userName);
            userDeletedByUserName = user.get();
        }
        return userDeletedByUserName;
    }

}
