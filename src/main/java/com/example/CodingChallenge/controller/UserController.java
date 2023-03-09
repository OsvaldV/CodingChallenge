package com.example.CodingChallenge.controller;

import com.example.CodingChallenge.model.User;
import com.example.CodingChallenge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

   @RequestMapping("/users")
    public List<User> getAllUsers(){
        //return userService.getAllUsers().stream().filter(u -> u.getStatus().equalsIgnoreCase("Active")).collect(Collectors.toList());
       return userService.getAllUsers();
    }

   @RequestMapping("/users/{id}")
   public User getUser(@PathVariable int id){
        return userService.getUser(id);
   }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public void updateUser(@Valid @RequestBody User user){
        userService.updateUser(user);
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
