package com.example.flightmanagement.service;

import com.example.flightmanagement.dto.BookingDTO;
import com.example.flightmanagement.entity.Booking;
import com.example.flightmanagement.entity.Flight;
import com.example.flightmanagement.entity.User;
import com.example.flightmanagement.repository.BookingRepository;
import com.example.flightmanagement.repository.FlightRepository;
import com.example.flightmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Booking bookFlight(BookingDTO bookingDTO) {
        Optional<User> user = userRepository.findById(bookingDTO.getUserId());
        Optional<Flight> flight = flightRepository.findById(bookingDTO.getFlightId());

        if (user.isPresent() && flight.isPresent()) {
            Booking booking = new Booking();
            booking.setUser(user.get());
            booking.setFlight(flight.get());
            booking.setPassengerName(bookingDTO.getPassengerName());
            booking.setAge(bookingDTO.getPassengerAge());
            booking.setEmail(bookingDTO.getPassengerEmail());
            booking.setPhoneNumber(bookingDTO.getPassengerPhone());
            booking.setStatus("CONFIRMED");

            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("User or Flight not found!");
        }
    }

    public List<Booking> getUserBookings(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(bookingRepository::findByUser)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
