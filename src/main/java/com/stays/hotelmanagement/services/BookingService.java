package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.entities.BookingIdentity;
import com.stays.hotelmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    //Add for BookingId
    //Find Booking details by BookingId
    public List<Booking> getBookingById(int bookingId){
        return this.bookingRepository.findAllBookingDetailsByBookingId(bookingId);
    }

    //Find Booking details by Primary key <Added to accommodate composite key>
    public Booking getBookingByPrimaryId(int bookingId, int roomId){

        Booking bookingFoundById = new Booking();
//        Changed to accommodate composite key
        Optional<Booking> booking = this.bookingRepository.findById(new BookingIdentity(bookingId, roomId));
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

    //Delete a booking using primary Id.
    //Changed to accommodate composite key
    public Optional<Booking> deleteBookingByPrimaryId(int bookingId, int roomId){
        boolean isBookingAvailable=this.bookingRepository.existsById(new BookingIdentity(bookingId, roomId));
        Optional<Booking> bookingToBeDeleted = Optional.of(new Booking());
        if(isBookingAvailable){
            bookingToBeDeleted = this.bookingRepository.findById(new BookingIdentity(bookingId, roomId));
            this.bookingRepository.deleteById(new BookingIdentity(bookingId, roomId));
        }
        return bookingToBeDeleted;
    }

    //Delete a booking using booking Id.
    //Add to accommodate composite key
    @Transactional
    public List<Booking> deleteAllBookingByBookingId(int bookingId){
        List<Booking> bookingList = new ArrayList<>();
//        List<Booking> bookingList = Collections.<Booking>emptyList();
        List<Booking> bookingToBeDeleted = this.bookingRepository.findAllBookingDetailsByBookingId(bookingId);

        if(bookingToBeDeleted.size()!=0){
            this.bookingRepository.deleteAllBookingDetailsByBookingId(bookingId);
            bookingList = bookingToBeDeleted;
        }
        return bookingList;
    }

    //Delete a booking
    //Changed to accommodate composite key
    public Booking deleteBooking(Booking existingBooking){
        Booking deletedBooking = new Booking();
        Boolean isBookingAvailable=this.bookingRepository.existsById(new BookingIdentity(existingBooking.getBookingId(), existingBooking.getRoomId()));
        if(isBookingAvailable){
            this.bookingRepository.delete(existingBooking);
            deletedBooking = existingBooking;
        }
        return deletedBooking;
    }

    //Find Booking details by HotelId
    public List<Booking> findBookingByHotelId(int hotelId){
        return this.bookingRepository.findAllBookingDetailsByHotelId(hotelId);
    }

    //Find Booking details by RoomId
    public List<Booking> findBookingByRoomId(int roomId){
        return this.bookingRepository.findAllBookingDetailsByRoomId(roomId);
    }

    //Find Booking details by UserName
    public List<Booking> findBookingByUserName(String userName){
        return this.bookingRepository.findAllBookingDetailsByUserName(userName);
    }

    //Find Booking details by BookedBy
    public List<Booking> findBookingByBookedBy(String bookedBy){
        return this.bookingRepository.findAllBookingDetailsByBookedBy(bookedBy);
    }

    //Find Booking details between bookingFromDate and bookingToDate
    public List<Booking> findBookingByDateRange(LocalDate bookedFromDate, LocalDate bookedToDate){
        return this.bookingRepository.findAllByBookedFromDateGreaterThanEqualAndBookedToDateLessThanEqual(bookedFromDate, bookedToDate);
    }

}
