package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.entities.Room;
import com.stays.hotelmanagement.services.HotelServices;
import com.stays.hotelmanagement.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(value="*")
public class RoomController {

    @Autowired
    private RoomServices roomServices;

    @GetMapping(value = "/rooms")
    public List<Room> getRooms(){

        return this.roomServices.getAll();
    }

    @PostMapping(value = "/rooms", produces = "application/json", consumes = "application/json")
    public Room add(@RequestBody Room room){

        return this.roomServices.addRoom(room);
    }

    @PutMapping(value = "/rooms", produces = "application/json", consumes = "application/json")
    public Room update(@RequestBody Room room){

        return this.roomServices.updateRoom(room);
    }

    @GetMapping(value = "/rooms/roomId/{id}")
    public Room findRoomById(@PathVariable("id") int id){

        return this.roomServices.findById(id);
    }

    @DeleteMapping(value = "/rooms/roomId/{id}", produces = "application/json")
    public Room deleteRoomById(@PathVariable("id") int id){
        return this.roomServices.deleteRoomById(id);
    }

    @DeleteMapping(value = "/rooms", produces = "application/json", consumes = "application/json")
    public Room deleteRoom(@RequestBody Room room){

        return this.roomServices.deleteRoom(room);
    }

    @GetMapping("/rooms/sort/{propName}")
    public Iterable<Room> showSortBy(@PathVariable("propName") String propName){

        return this.roomServices.sortBy(propName);
    }
}

