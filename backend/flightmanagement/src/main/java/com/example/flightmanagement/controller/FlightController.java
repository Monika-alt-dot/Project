package com.example.flightmanagement.controller;

import com.example.flightmanagement.entity.Flight;
import com.example.flightmanagement.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // ✅ Add a new flight
    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }

    // ✅ Search for flights by source, destination, and date
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date) {

        LocalDate flightDate = LocalDate.parse(date);
        List<Flight> flights = flightService.searchFlights(source, destination, flightDate);

        return ResponseEntity.ok(flights);
    }
}
