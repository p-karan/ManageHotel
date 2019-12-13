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
            "R.ROOM_ID, H.HOTEL_ID ,H.ADDRESS_CITY, R.ROOM_TYPE) from HBMS_ROOMS R, HBMS_HOTELS H " +
            "where H.HOTEL_ID = R.HOTEL_ID and H.ADDRESS_CITY = ?1 and " +
            "R.ROOM_ID not in " +
            "(select R.ROOM_ID from HBMS_BOOKING_DETAILS B, HBMS_ROOMS R " +
            "where B.ROOM_ID = R.ROOM_ID and (BOOKED_FROM_DATE <'?3') and (BOOKED_TO_DATE >= '?2'))")
    public List<SearchResult> findBcyCityDateRangeRoomType(String location, LocalDate fromDate, LocalDate toDate);


}
