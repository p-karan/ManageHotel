package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Room;
import com.stays.hotelmanagement.repository.RoomRepository;
import com.stays.hotelmanagement.transactionalObject.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServices {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll(){

        return this.roomRepository.findAll();
    }

    public Iterable<Room> sortBy(String propName){

        Sort sortBy = Sort.by(propName);

        return this.roomRepository.findAll(sortBy);
    }

    public Room addRoom(Room room){
        return this.roomRepository.save(room);
    }

    public Room updateRoom(Room room){
        return this.roomRepository.save(room);
    }

    public Room findById(int id){
        Room roomFoundById = new Room();
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isPresent()) {
            roomFoundById = room.get();
        }
        return roomFoundById;
    }

    public Room deleteRoom(Room room){
        this.roomRepository.delete(room);
        return room;
    }

    public Room deleteRoomById(int id){
        Room roomDeletedById = new Room();
        Optional<Room> room = this.roomRepository.findById(id);
        if(room.isPresent()){
            this.roomRepository.deleteById(id);
            roomDeletedById = room.get();
        }
        return roomDeletedById;
    }

    // Find all Room by City and Room Type
    public List<SearchResult> findAllRoomsByCityRoomType(){
        return this.roomRepository.findAllByCityRoomType();
    }
}

