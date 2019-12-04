package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

//  public List<Booking> findAllBookingDetailsByUserId(String userId);

    public List<Booking> findAllBookingDetailsByHotelId(String hotelId);
    public List<Booking> findAllBookingDetailsByRoomId(String roomId);
    public Booking findBookingDetailsByPaymentSet(String paymentId);
    public List<Booking> findAllBookingDetailsByBookedByBetween(LocalDate bookedFromDate, LocalDate bookedToDate);

//  public String deleteAllBookingDetailsByUserId(String userId);

    public String deleteAllBookingDetailsByHotelId(String hotelId);
    public String deleteAllBookingDetailsByRoomId(String roomId);
    public String deleteBookingDetailsByPaymentSet(String paymentId);
    public String deleteAllBookingDetailsByBookedByBetween(LocalDate bookedFromDate, LocalDate bookedToDate);
}

