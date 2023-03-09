package com.example.CodingChallenge.service;

import com.example.CodingChallenge.model.User;
import com.example.CodingChallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

   public List<User> getAllUsers(){
        //return userRepository.findAll().stream().filter(u -> u.getStatus() == "Active").collect(Collectors.toList());
       return userRepository.findAll().stream().filter(u -> u.getStatus().equalsIgnoreCase("ACTIVE")).collect(Collectors.toList());
    }

   public User getUser(int id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not in DB"));
        return user;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
