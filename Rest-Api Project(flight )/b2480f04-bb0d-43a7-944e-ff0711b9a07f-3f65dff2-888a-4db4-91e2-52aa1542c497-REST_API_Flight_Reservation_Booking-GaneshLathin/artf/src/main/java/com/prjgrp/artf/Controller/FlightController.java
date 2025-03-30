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

import com.prjgrp.artf.Model.Flight;
import com.prjgrp.artf.Service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @PostMapping
    public Flight postFlight(@RequestBody Flight flight){
         return flightService.postFlight(flight);
    }
    @GetMapping
    public List<Flight> getFlight(){
         return flightService.getFlight();
    }
     @GetMapping("/{id}")
    public Optional<Flight> getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestBody Flight updated) {
        return flightService.updateFlight(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable int id) {
        return 
        flightService.deleteFlight(id) ? "User Deleted" : "User Not Found";
    }
    @GetMapping("/sorted")
    public Page<Flight> getAllSortedFlight(@RequestParam int page, @RequestParam int size,@RequestParam String sortBy ,@RequestParam String sortDirection) {
        return flightService.getAllSortedFlight(page, size,sortBy,sortDirection);
    }
}
