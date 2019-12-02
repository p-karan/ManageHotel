package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    //Find all Booking details
    public List<Booking> getAllBooking(){
        return this.bookingRepo.findAll();
    }

    //Find Booking details by BookingId
    public Booking findBookingById(String bookingId){

        Booking bookingById = new Booking();
        Optional<Booking> booking = this.bookingRepo.findById(bookingId);
        if(booking.isPresent())
            bookingById = booking.get();
        return bookingById;
    }

    //Add a Booking
    public Booking addBooking(Booking booking){
        return this.bookingRepo.save(booking);
    }

    //Update a Booking record
    public Booking updateBooking(Booking booking){
        return this.bookingRepo.save(booking);
    }

    //Delete a Booking
    public String deleteBooking(Booking booking){
        String message = "No Such booking exists!!!";
        if(this.bookingRepo.existsById(booking.getBookingId())){
            message = "Booking deleted by Id: "+booking.getBookingId();
            this.bookingRepo.delete(booking);
        }
        return message;
    }

    //Delete a Booking by Booking Id
    public String deleteBookingById(String bookingId){
        String message = "No booking exists with " + bookingId;
        if(this.bookingRepo.existsById(bookingId)){
            message = "Booking deleted by Id: "+bookingId;
            this.bookingRepo.deleteById(bookingId);
        }
        return message;
    }

    //Find Booking details by UserId
    public List<Booking> findBookingByUserId(String userId){
        return this.bookingRepo.findAllBookingDetailsByUserId(userId);
    }

    //Find Booking details by HotelId
    public List<Booking> findBookingByHotelId(String hotelId){
        return this.bookingRepo.findAllBookingDetailsByHotelId(hotelId);
    }

    //Find Booking details by RoomId
    public List<Booking> findBookingByRoomId(String roomId){
        return this.bookingRepo.findAllBookingDetailsByRoomId(roomId);
    }

    //Find Booking details between bookingFromDate and bookingToDate
    public List<Booking> findBookingByDateRange(LocalDate bookedFromDate, LocalDate bookedToDate){
        return this.bookingRepo.findAllBookingDetailsByBookedByBetween(bookedFromDate, bookedToDate);
    }

    //Find Booking details by paymentId
    public Booking findBookingByPaymentId(String paymentId){
        return this.bookingRepo.findBookingDetailsByPaymentList(paymentId);
    }

}


   /*
   Find All Booking
   Find Booking By ID
   Add a booking
   update a booking
   delete a booking by Booking
   delete a booking by Booking ID
   Find Booking By user ID
   Find Booking By hotel ID
   Find Booking By Room ID
   Find Booking By bookingFromDate and bookingToDate

  - Need to check
  Find Booking By Payment ID

   delete a booking by user ID
   delete a booking by Hotel ID
   delete a booking by Room ID
   delete a booking by Payment ID
   Find Booking By bookingFromDate and bookingToDate*/