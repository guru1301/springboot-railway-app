package com.railgo.controller;

import com.railgo.model.BookingModel;
import com.railgo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // ✅ Save a new booking
    @PostMapping("/save")
    public ResponseEntity<?> saveBooking(@RequestBody BookingModel booking) {
        try {
            // Generate a PNR
            String pnr = generatePNR();
            booking.setPnr(pnr);

            // Save to MongoDB
            BookingModel savedBooking = bookingRepository.save(booking);

            // Return booking ID and PNR
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("bookingId", savedBooking.getId());
            response.put("pnr", pnr);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Failed to save booking: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // ✅ Fetch booking by ID (for confirmation.html)
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable String id) {
        Optional<BookingModel> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            return ResponseEntity.ok(booking.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        }
    }

    // Utility to generate a simple PNR
    private String generatePNR() {
        return "RG" + System.currentTimeMillis() % 10000000;
    }
}
