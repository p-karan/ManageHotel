package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.transactionalObject.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {


    @Query(value = "select new com.stays.hotelmanagement.transactionalObject.SearchResult(" +
            "r.roomId, r.roomType, r.ratePerNight, r.roomDescription, h.hotelId, " +
            "h.hotelName, h.hotelDescription, h.rating, h.discount, h.hotelOperationalStatus, " +
            "h.addresses.addressBldgFlat, h.addresses.addressStreet, h.addresses.addressCity, h.addresses.addressState, " +
            "h.addresses.addressPincode, h.addresses.email, h.addresses.mobileNo, h.addresses.primaryPhone, " +
            "h.addresses.secondaryPhone) from Room as r join Hotel as h " +
            "on h.hotelId = r.hotelId and h.addresses.addressCity = ?1 and " +
            "r.roomId not in " +
            "(select r.roomId from Booking as b join Room as r " +
            "on b.roomId = r.roomId and b.bookedFromDate <?3 and b.bookedToDate > ?2)")
    public List<SearchResult> findByCityDateRangeRoomType(String location, LocalDate fromDate, LocalDate toDate);


    public List<Hotel> findAllByAddresses_AddressCity(String city);

}

