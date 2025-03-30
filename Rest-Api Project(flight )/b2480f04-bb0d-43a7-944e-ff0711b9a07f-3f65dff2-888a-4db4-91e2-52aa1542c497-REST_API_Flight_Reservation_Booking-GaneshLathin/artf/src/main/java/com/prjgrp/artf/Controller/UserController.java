package com.prjgrp.artf.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prjgrp.artf.Model.User;
import com.prjgrp.artf.Service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {
        
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
      
        return userService.deleteUser(id) ? "User Deleted" : "User Not Found";
    }
    @GetMapping("/users/sorted")
    public Page<User> getAllSortedUser(@RequestParam int page, @RequestParam int size,@RequestParam String sortBy ,@RequestParam String sortDirection) {
        return userService.getAllSortedUser(page, size,sortBy,sortDirection);
    }
    @GetMapping("/sorted/{address}")
    public List<User> getSortedBookings(@PathVariable String address) {
        return userService.getBookingsSortedByDate(address);
    }
}