package com.prjgrp.artf.Model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class History {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String bookingDate;
private String status;
private int amountPaid;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_id")
@JsonIgnoreProperties("history")
private User user;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="flight_id")
@JsonIgnoreProperties("history")
private Flight flight;

public Flight getFlight() {
    return flight;
}
public void setFlight(Flight flight) {
    this.flight = flight;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getBookingDate() {
    return bookingDate;
}
public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public int getAmountPaid() {
    return amountPaid;
}
public void setAmountPaid(int amountPaid) {
    this.amountPaid = amountPaid;
}
public User getUser() {
    return user;
}
public void setUser(User user) {
    this.user = user;
}

// public Flight getFlight() {
//     return flight;
// }
// public void setFlight(Flight flight) {
//     this.flight = flight;
// }

}
