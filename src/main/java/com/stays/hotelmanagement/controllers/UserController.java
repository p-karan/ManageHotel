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
    public Users updateUser(@RequestBody Users existingUser) {
        return this.userService.updateUser(existingUser);
    }

    //Find All Users
    @GetMapping(value = "/user")
    public List<Users> getAllUsers() {
        return this.userService.getAllUsers();
    }

    //Find User by User_Id
    @GetMapping(value = "/user/userId/{id}")
    public Users getUserById(@PathVariable("id") int userId) {
        return this.userService.getUserById(userId);
    }

    //Find User by User_Name
    @GetMapping(value = "user/userName/{userName}")
    public Users getUserByUserName(@PathVariable("userName") String userName) {
        return this.userService.getUserByUserName(userName);
    }

    //Delete User
    @DeleteMapping(value = "/user", produces = "application/json", consumes = "application/json")
    public Users deleteUser(@RequestBody Users existingUser){
        return this.userService.deleteUser(existingUser);
    }

    //Delete User by User_Name
    @DeleteMapping(value = "user/{userName}", produces = "application/json")
    public Users deleteUserByName(@PathVariable("userName") String userName) {
       return this.userService.deleteUserByUserName(userName);
    }
}
