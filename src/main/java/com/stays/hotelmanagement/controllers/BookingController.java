package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //Find all Booking details
    @GetMapping(value="/booking")
    public List<Booking> getAllBooking(){
        return this.bookingService.getAllBooking();
    }

    //Find Booking details by BookingId
    @GetMapping(value = "/booking/{bookingId}")
    public Booking getBookingById(@PathVariable("bookingId") String bookingId){
        return this.bookingService.getBookingById(bookingId);
    }

    //Add a Booking
    @PostMapping(value = "/booking")
    public Booking addBooking(Booking booking){
        return this.bookingService.addBooking(booking);
    }

    //Update a Booking record
    @PutMapping(value = "/booking")
    public Booking updateBooking(Booking booking){
        return this.bookingService.addBooking(booking);
    }

    //Delete a booking using  booking Id.
    @DeleteMapping(value="/booking/{bookingId}")
    public String deleteBookingById(@PathVariable("bookingId") String bookingId){
        return this.bookingService.deleteBookingById(bookingId);
    }
}
