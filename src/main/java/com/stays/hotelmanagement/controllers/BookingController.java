package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //Find all Booking details
    @GetMapping(value = "/booking")
    public List<Booking> getBooking(){
        return this.bookingService.getAllBooking();
    }

    //Find Booking details by BookingId
    @GetMapping(value = "/booking/{Id}")
    public Booking getAllBookingById(@PathVariable("Id") String id){

        return this.bookingService.findBookingById(id);
    }

    //Add a Booking
    @PostMapping(value = "/booking",produces = "application/json", consumes = "application/json")
    public Booking addBooking(@RequestBody Booking booking){

        return this.bookingService.addBooking(booking);
    }

    //Update a Booking record
    @PutMapping(value = "/booking",produces = "application/json", consumes = "application/json")
    public Booking updateBooking(@RequestBody Booking booking){

        return this.bookingService.updateBooking(booking);
    }

    //Delete a Booking record
    @DeleteMapping(value = "/booking",produces = "application/json", consumes = "application/json")
    public String removeBooking(@RequestBody Booking booking){

        return this.bookingService.deleteBooking(booking);
    }

    //Delete a Booking by Booking Id
    @DeleteMapping(value = "/booking/{Id}",produces = "application/json", consumes = "application/json")
    public String removeBookingById(@PathVariable("Id") String id){
        return this.bookingService.deleteBookingById(id);
    }

    //Find Booking details by UserId
    @GetMapping(value = "/booking/user/{user}")
    public List<Booking> getAllBookingByUserId(@PathVariable("user") String userId){

        return this.bookingService.findBookingByUserId(userId);
    }

        //Find Booking details by HotelId
    @GetMapping(value = "/booking/hotel/{hotel}")
    public List<Booking> getAllBookingByHotelId(@PathVariable("hotel") String hotelId){

        return this.bookingService.findBookingByHotelId(hotelId);
    }

    //Find Booking details by RoomId
    @GetMapping(value = "/booking/room/{room}")
    public List<Booking> getAllBookingByRoomId(@PathVariable("room") String roomId){

        return this.bookingService.findBookingByRoomId(roomId);
    }

    //Find Booking details between bookingFromDate and bookingToDate
    @GetMapping(value = "/booking/date/{bookFrom}/{bookTo}")
    public List<Booking> getAllBookingByDateRange(@PathVariable("bookFrom") LocalDate bookedFromDate, @PathVariable("bookTo")LocalDate bookedToDate){

        return this.bookingService.findBookingByDateRange(bookedFromDate,bookedToDate);
    }

    //Find Booking details by paymentId
//    @GetMapping(value = "/booking/payment/{payment}")
//    public Booking getAllBookingByPaymentId(@PathVariable("payment") String paymentId){
//
//        return this.bookingService.findBookingByPaymentId(paymentId);
//    }
}
