package com.prjgrp.artf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prjgrp.artf.Model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {

}
