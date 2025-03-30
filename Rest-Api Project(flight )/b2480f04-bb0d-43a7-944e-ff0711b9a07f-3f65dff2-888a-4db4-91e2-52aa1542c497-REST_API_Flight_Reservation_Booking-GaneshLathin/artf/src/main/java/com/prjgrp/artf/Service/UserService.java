package com.prjgrp.artf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.prjgrp.artf.Model.User;
import com.prjgrp.artf.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
    public User updateUser(int id, User updatedUser) {
       updatedUser.setId(id);
       return userRepository.save(updatedUser);
        }
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Page<User> getAllSortedUser(int page,int size,String sortBy,String sortDirection)
    {
        Sort sort = Sort.by(sortDirection.equalsIgnoreCase("desc") ? Direction.DESC : Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(page,size,sort);
        return userRepository.findAll(pageable);
    }
    public List<User> getBookingsSortedByDate(String address) {
        return userRepository.findAllSortedByBookingDate(address);
    }
}

