package com.crudapp.crud_restapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.crud_restapi.Models.User;
import com.crudapp.crud_restapi.Repository.UserRepository;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    } 

    @GetMapping(value = "/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }
    @PostMapping(value = "/save")
    public String saveUser (@RequestBody User user){
        userRepository.save(user);
        return "Saved....";
    }
}
