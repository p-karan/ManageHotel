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
    @PostMapping(value="/user")
    public Users addUser(Users newUser){
        return this.userService.addUser(newUser);
    }

    //Update an existing User
    @PutMapping(value = "/user")
    public Users updateUser(Users existingUser){
        return this.userService.updateUser(existingUser);
    }

    //Find All Users
    @GetMapping(value = "/user")
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }

    //Find User by User_Id
    @GetMapping(value = "user/{userId}")
    public Users getUserById(@PathVariable("userId") String userId){
        return this.userService.getUserById(userId);
    }

    //Find User by User_Name
    @GetMapping(value="user/{userName}")
    public Users getUserByUserName(@PathVariable("userName") String userName){
        return this.userService.getUserByUserName(userName);
    }

    //Delete User by User_Id
    @DeleteMapping(value = "user/{userId}")
    public String deleteUserById(@PathVariable("userId") String userId){
        return this.userService.deleteUserById(userId);
    }

    //Delete User by User_Name
    @DeleteMapping(value = "user/{userName}")
    public String deleteUserByName(@PathVariable("userName") String userName){
        return this.userService.deleteUserByName(userName);
    }
}
