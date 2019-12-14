package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.entities.BookingIdentity;
import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.entities.Room;
import com.stays.hotelmanagement.transactionalObject.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, BookingIdentity> {

    //Search Functions
    public List<Booking> findAllBookingDetailsByBookingId(int bookingId);
    public List<Booking> findAllBookingDetailsByUserId(int userId);
    public List<Booking> findAllBookingDetailsByHotelId(int hotelId);
    public List<Booking> findAllBookingDetailsByRoomId(int roomId);
    public List<Booking> findAllBookingDetailsByUserName(String userName);
    public List<Booking> findAllBookingDetailsByBookedBy(String BookedBy);
    public List<Booking> findAllByBookedFromDateGreaterThanEqualAndBookedToDateLessThanEqual(LocalDate bookedFromDate, LocalDate bookedToDate);

    //Delete Functions
    public List<Booking> deleteAllBookingDetailsByBookingId(int bookingId);

}
