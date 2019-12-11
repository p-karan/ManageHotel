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
    public Booking getBookingById(int bookingId){

        Booking bookingFoundById = new Booking();
        Optional<Booking> booking = this.bookingRepository.findById(bookingId);
        if(booking.isPresent()) {
            bookingFoundById = booking.get();
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
    public Optional<Booking> deleteBookingById(int bookingId){
        boolean isBookingAvailable=this.bookingRepository.existsById(bookingId);
        Optional<Booking> bookingToBeDeleted = Optional.of(new Booking());
        if(isBookingAvailable){
            bookingToBeDeleted = this.bookingRepository.findById(bookingId);
            this.bookingRepository.deleteById(bookingId);
        }
        return bookingToBeDeleted;
    }

    //Delete a booking
    public Booking deleteBooking(Booking existingBooking){
        Booking deletedBooking = new Booking();
        Boolean isBookingAvailable=this.bookingRepository.existsById(existingBooking.getBookingId());
        if(isBookingAvailable){
            this.bookingRepository.delete(existingBooking);
            deletedBooking = existingBooking;
        }
        return deletedBooking;
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
