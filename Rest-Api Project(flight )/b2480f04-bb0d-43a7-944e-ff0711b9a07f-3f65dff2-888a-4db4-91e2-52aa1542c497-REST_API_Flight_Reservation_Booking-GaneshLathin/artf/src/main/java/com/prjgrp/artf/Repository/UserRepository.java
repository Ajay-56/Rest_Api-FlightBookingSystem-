package com.prjgrp.artf.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prjgrp.artf.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u ORDER BY u.address")
    List<User> findAllSortedByBookingDate(@Param("address")String address);
    }


