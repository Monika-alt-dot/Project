package com.example.flightmanagement.controller;

import com.example.flightmanagement.dto.BookingDTO;
import com.example.flightmanagement.entity.Booking;
import com.example.flightmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookFlight(@RequestBody BookingDTO bookingDTO) {
        bookingService.bookFlight(bookingDTO);
        return ResponseEntity.ok("Booking successful!");
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Booking>> getBookingHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }
}
