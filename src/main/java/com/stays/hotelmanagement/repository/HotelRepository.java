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
            "r.roomId, h.hotelId ,h.address.addressCity, r.roomType) from Room as r join Hotel as h " +
            "on h.hotelId = r.hotelId and h.address.addressCity = ?1 and " +
            "r.roomId not in " +
            "(select r.roomId from Booking as b join Room as r " +
            "on b.roomId = r.roomId and b.bookedFromDate <?3 and b.bookedToDate > ?2)")
    public List<SearchResult> findBcyCityDateRangeRoomType(String location, LocalDate fromDate, LocalDate toDate);


}
