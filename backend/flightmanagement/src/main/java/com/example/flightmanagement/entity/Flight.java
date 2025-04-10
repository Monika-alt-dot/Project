package com.example.flightmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "flights")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;  // ✅ Unique Flight ID

    @Column(nullable = false)
    private String airlineName;  // ✅ Airline Name

    @Column(nullable = false, unique = true)
    private String airlineNumber;  // ✅ Unique Flight Number

    @Column(nullable = false)
    private String source;  // ✅ Source City

    @Column(nullable = false)
    private String destination;  // ✅ Destination City

    @Column(nullable = false)
    private LocalDate date;  // ✅ Flight Date

    @Column(nullable = false)
    private double price;  // ✅ Ticket Price

    @Column(nullable = false)
    private int availableSeats;  // ✅ Available Seats

    @Column(nullable = false)
    private String departureTime;  // ✅ Departure Time

    @Column(nullable = false)
    private String arrivalTime;  // ✅ Arrival Time

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineNumber() {
        return airlineNumber;
    }

    public void setAirlineNumber(String airlineNumber) {
        this.airlineNumber = airlineNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
