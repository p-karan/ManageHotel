package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
    public Booking getBookingById(@PathVariable("bookingId") int bookingId){
        return this.bookingService.getBookingById(bookingId);
    }

    //Add a Booking
    @PostMapping(value = "/booking", produces = "application/json", consumes = "application/json")
    public Booking addBooking(@RequestBody Booking booking){
        return this.bookingService.addBooking(booking);
    }

    //Update a Booking record
    @PutMapping(value = "/booking" , produces = "application/json", consumes = "application/json")
    public Booking updateBooking(@RequestBody Booking booking){
        return this.bookingService.addBooking(booking);
    }

    //Delete a booking using  booking Id.
    @DeleteMapping(value="/booking/{bookingId}")
    public Optional<Booking> deleteBookingById(@PathVariable("bookingId") int bookingId){
        return this.bookingService.deleteBookingById(bookingId);
    }

    //Delete a booking
    @DeleteMapping(value="/booking", produces = "application/json", consumes = "application/json")
    public Booking deleteBooking(@RequestBody Booking existingBooking){
        return this.bookingService.deleteBooking(existingBooking);
    }


    //Find a booking betweeen From and To Date
    @GetMapping(value="booking/search/{fromDate}/{toDate}")
    public List<Booking> getAllBookingByDateRange(
            @PathVariable("fromDate")  @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate fromDate,
            @PathVariable("toDate") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate toDate)
         {
            return this.bookingService.findBookingByDateRange(fromDate, toDate);
    }

 /*   @GetMapping(value="booking/search/{fromDate}/{toDate}")
    public List<Booking> getAllBookingByDateRange(
            @PathVariable("fromDate") String fromDate,
            @PathVariable("toDate") String toDate)
         {
            return this.bookingService.findBookingByDateRange(fromDate, toDate);
    }*/

/*    @GetMapping(value="booking/search/{fromDate}/{toDate}")
    public List<Booking> getAllBookingByDateRange(@PathVariable("fromDate") String fromDate,
                                                  @PathVariable("toDate") String toDate) {
        DateTimeFormatter formatter = null;
        System.out.println(fromDate);
        formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate formattedFromDate = LocalDate.parse(fromDate, formatter);
        LocalDate formattedToDate = LocalDate.parse(toDate,formatter);
        System.out.println("From :" + formattedFromDate);
        System.out.println("From :" + formattedToDate);
        return this.bookingService.findBookingByDateRange(formattedFromDate, formattedToDate);
    }*/


}
