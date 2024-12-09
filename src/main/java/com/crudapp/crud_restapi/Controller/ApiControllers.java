package com.crudapp.crud_restapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return "This is a RestAPI for CRUD operations";
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

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setDepartment(user.getDepartment());
        userRepository.save(updatedUser);
        return "Updated user...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "Delete user with the id:"+id;
    }
}
