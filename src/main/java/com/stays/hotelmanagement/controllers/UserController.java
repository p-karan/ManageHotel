package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Users;
import com.stays.hotelmanagement.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServices userService;

    //Add a new User
    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
    public Users addUser(@RequestBody Users newUser) {
        return this.userService.addUser(newUser);
    }

    //Update an existing User
    @PutMapping(value = "/user", produces = "application/json", consumes = "application/json")
    public String updateUser(@RequestBody Users existingUser) {
        String usertoUpdate = existingUser.getUserName();
        String userNotFound = "User : " + usertoUpdate + " not found";
        String updateStatus = "User record updated successfully.";

        boolean isUserPresent = this.userService.checkUserExist(usertoUpdate);
        if (isUserPresent) {
            this.userService.updateUser(existingUser);
        } else {
            return userNotFound;
        }
        return updateStatus;
    }

    //Find All Users
    @GetMapping(value = "/user")
    public List<Users> getAllUsers() {
        return this.userService.getAllUsers();
    }

    //Find User by User_Id
    @GetMapping(value = "/user/userId/{id}")
    public Users getUserById(@PathVariable("id") String userId) {
        return this.userService.getUserById(userId);
    }

    //Find User by User_Name
    @GetMapping(value = "user/userName/{userName}")
    public Users getUserByUserName(@PathVariable("userName") String userName) {
        return this.userService.getUserByUserName(userName);
    }

    /*//Delete User by User_Id
    @DeleteMapping(value = "user/{userId}")
    public String deleteUserById(@PathVariable("userId") String userId){
        return this.userService.deleteUserById(userId);
    }*/

    //Delete User by User_Name
    @DeleteMapping(value = "user/{userName}")
    public String deleteUserByName(@PathVariable("userName") String userName) {
        String userNotFound = "User : " + userName + " not found";
        String deleteSuccess = "User record deleted successfully.";
        String deleteFailure = "Delete operation failed.";
        boolean isUserPresent = this.userService.checkUserExist(userName);
        if (isUserPresent) {
            boolean isdeleteSuccessFul = this.userService.deleteUserbyUserName(userName);
            if (isdeleteSuccessFul) {
                return deleteSuccess;
            } else {
                return deleteFailure;
            }
        } else {
            return userNotFound;
        }
    }
}
