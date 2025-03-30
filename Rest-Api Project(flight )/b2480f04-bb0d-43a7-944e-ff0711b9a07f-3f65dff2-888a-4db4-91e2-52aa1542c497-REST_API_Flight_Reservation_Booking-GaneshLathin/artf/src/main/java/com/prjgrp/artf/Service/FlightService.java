package com.prjgrp.artf.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.*;
import org.springframework.stereotype.Service;

import com.prjgrp.artf.Model.Flight;
import com.prjgrp.artf.Repository.FlightRepository;
@Service
public class FlightService {
@Autowired
FlightRepository flightRepository;
public Flight postFlight(Flight flight)
{
    return flightRepository.save(flight);
}
public List<Flight> getFlight()
{
    return flightRepository.findAll();
}
public Optional<Flight> getFlightById(int id) {
  return flightRepository.findById(id);
}
public Flight updateFlight(int id, Flight updated) {
    updated.setId(id);
  return flightRepository.save(updated);
}
public boolean deleteFlight(int id) {
   if(flightRepository.existsById(id)){
    flightRepository.deleteById(id);
        return true;
   }
   return false;
}
public Page<Flight> getAllSortedFlight(int page,int size,String sortBy,String sortDirection)
    {
        Sort sort = Sort.by(sortDirection.equalsIgnoreCase("desc") ? Direction.DESC : Direction.ASC, sortBy);
        return flightRepository.findAll(PageRequest.of(page,size,sort));
    }
}
