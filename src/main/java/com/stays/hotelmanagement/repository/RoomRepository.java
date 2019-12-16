package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Room;
import com.stays.hotelmanagement.transactionalObject.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    // Find all Room by City and Room Type
    @Query(value = "select new com.stays.hotelmanagement.transactionalObject.SearchResult(" +
            "r.roomType , r.ratePerNight, r.roomDescription, h.addresses.addressCity) from Room as r join Hotel as h " +
            "on h.hotelId = r.hotelId group by r.roomType , r.ratePerNight, r.roomDescription, h.addresses.addressCity order by h.addresses.addressCity, r.ratePerNight")
    public List<SearchResult> findAllByCityRoomType();
}
