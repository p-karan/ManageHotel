package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public List<Booking> getBookingByBookingId(@PathVariable("bookingId") int bookingId){
        return this.bookingService.getBookingById(bookingId);
    }

    //Find Booking details by PrimaryKey
    @GetMapping(value = "/booking/primaryKey/{bookingId}/{roomId}")
    public Booking getBookingByPrimaryId(@PathVariable("bookingId") int bookingId, @PathVariable("roomId") int roomId){
        return this.bookingService.getBookingByPrimaryId(bookingId, roomId);
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


    //Delete a booking
    @DeleteMapping(value="/booking", produces = "application/json", consumes = "application/json")
    public Booking deleteBooking(@RequestBody Booking existingBooking){
        return this.bookingService.deleteBooking(existingBooking);
    }

    //Delete a booking using primary Key.
    @DeleteMapping(value="/booking/primaryKey/{bookingId}/{roomId}")
    public Optional<Booking> deleteBookingByPrimaryId(@PathVariable("bookingId") int bookingId, @PathVariable("roomId") int roomId){
        return this.bookingService.deleteBookingByPrimaryId(bookingId, roomId);
    }

    //Delete a booking using booking Id.
    @DeleteMapping(value="/booking/{bookingId}")
    public List<Booking> deleteBookingByBookingId(@PathVariable("bookingId") int bookingId){
        return this.bookingService.deleteAllBookingByBookingId(bookingId);
    }

    //Find Booking details by HotelId
    @GetMapping(value = "/booking/hotel/{hotel}")
    public List<Booking> getAllBookingByHotelId(@PathVariable("hotel") int hotelId){

        return this.bookingService.findBookingByHotelId(hotelId);
    }

    //Find Booking details by RoomId
    @GetMapping(value = "/booking/room/{room}")
    public List<Booking> getAllBookingByRoomId(@PathVariable("room") int roomId){

        return this.bookingService.findBookingByRoomId(roomId);
    }

    //Find Booking details by UserName
    @GetMapping(value = "/booking/userName/{userName}")
    public List<Booking> getAllBookingByUserName(@PathVariable("userName") String userName){

        return this.bookingService.findBookingByUserName(userName);
    }

    //Find Booking details by BookedBy
    @GetMapping(value = "/booking/bookedBy/{bookedBy}")
    public List<Booking> getAllBookingByBookedBy(@PathVariable("bookedBy") String bookedBy){

        return this.bookingService.findBookingByBookedBy(bookedBy);
    }

    //Find Booking details between bookingFromDate and bookingToDate
    @GetMapping(value = "/booking/date/{bookFrom}/{bookTo}")
    public List<Booking> getAllBookingByDateRange(
            @PathVariable("bookFrom") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate bookedFromDate,
            @PathVariable("bookTo") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate bookedToDate){

        return this.bookingService.findBookingByDateRange(bookedFromDate, bookedToDate);
    }

}
