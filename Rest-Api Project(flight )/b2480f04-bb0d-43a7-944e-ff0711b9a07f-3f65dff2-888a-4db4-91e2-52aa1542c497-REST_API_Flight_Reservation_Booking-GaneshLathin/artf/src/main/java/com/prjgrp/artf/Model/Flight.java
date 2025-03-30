package com.prjgrp.artf.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Flight {
@Id
private int id;
private int flightNumber;
private String airlineName;
private String departureLocation;
private String arrivalLocation;
private String arrivalTime;
private String departureTime;
private int totalSeats;
private int availableSeats;
private int totalPrice;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
@JsonIgnoreProperties("flight")
private List<History> history;

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getFlightNumber() {
    return flightNumber;
}
public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
}
public String getAirlineName() {
    return airlineName;
}
public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
}
public String getDepartureLocation() {
    return departureLocation;
}
public void setDepartureLocation(String departureLocation) {
    this.departureLocation = departureLocation;
}
public String getArrivalLocation() {
    return arrivalLocation;
}
public void setArrivalLocation(String arrivalLocation) {
    this.arrivalLocation = arrivalLocation;
}
public String getArrivalTime() {
    return arrivalTime;
}
public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
}
public String getDepartureTime() {
    return departureTime;
}
public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
}
public int getTotalSeats() {
    return totalSeats;
}
public void setTotalSeats(int totalSeats) {
    this.totalSeats = totalSeats;
}
public int getAvailableSeats() {
    return availableSeats;
}
public void setAvailableSeats(int availableSeats) {
    this.availableSeats = availableSeats;
}
public int getTotalPrice() {
    return totalPrice;
}
public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
}
// public List<History> getHistory() {
//     return history;
// }
// public void setHistory(List<History> history) {
//     this.history = history;
// }

}
