package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

}
