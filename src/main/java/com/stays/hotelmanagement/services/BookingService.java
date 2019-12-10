package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    //Find all Booking details
    public List<Booking> getAllBooking(){
        return this.bookingRepository.findAll();
    }

    //Find Booking details by BookingId
    public Booking getBookingById(Integer bookingId){

        Booking bookingFoundById = new Booking();
        Optional<Booking> booking = this.bookingRepository.findByBookingId(bookingId);
        if(booking.isPresent()) {
            bookingFoundById = booking.get();
        }else{
            // Add logic to check for null user.
        }
        return bookingFoundById;
    }

    //Add a Booking
    public Booking addBooking(Booking booking){
        return this.bookingRepository.save(booking);
    }

    //Update a Booking record
    public Booking updateBooking(Booking booking){
        return this.bookingRepository.save(booking);
    }

    //Delete a booking using  booking Id.
    public String deleteBookingById(Integer bookingId){
        String result = "Booking : " + bookingId + " not found.";
        Boolean isBookingAvailable=this.bookingRepository.existsByBookingId(bookingId);

        if(isBookingAvailable){
            this.bookingRepository.deleteByBookingId(bookingId);
            result = "User : " + bookingId + " deleted.";
        }
        return result;
    }

    //Find Booking details by HotelId
    public List<Booking> findBookingByHotelId(String hotelId){
        return this.bookingRepository.findAllBookingDetailsByHotelId(hotelId);
    }

    //Find Booking details by RoomId
    public List<Booking> findBookingByRoomId(String roomId){
        return this.bookingRepository.findAllBookingDetailsByRoomId(roomId);
    }

    //Find Booking details between bookingFromDate and bookingToDate
    public List<Booking> findBookingByDateRange(LocalDate bookedFromDate, LocalDate bookedToDate){
        return this.bookingRepository.findAllBookingDetailsByBookedByBetween(bookedFromDate, bookedToDate);
    }

    /*//Find Booking details by paymentId
    public Booking findBookingByPaymentId(String paymentId){
        return this.bookingRepository.findBookingDetailsByPaymentSet(paymentId);
    }*/
}
