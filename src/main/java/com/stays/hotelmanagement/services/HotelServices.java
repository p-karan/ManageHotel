package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.repository.HotelRepository;
import com.stays.hotelmanagement.transactionalObject.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServices {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAll(){

        return this.hotelRepository.findAll();
    }

    public Iterable<Hotel> sortBy(String propName){

        Sort sortBy = Sort.by(propName);

        return this.hotelRepository.findAll(sortBy);
    }


    public Hotel addHotel(Hotel hotel){
        return this.hotelRepository.save(hotel);
    }


    public Hotel updateHotel(Hotel hotel){
        return (Hotel) this.hotelRepository.save(hotel);
    }

    public Hotel findById(int id){
        Hotel hotelFoundById = new Hotel();
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        if (hotel.isPresent()) {
            hotelFoundById = hotel.get();
        } else {
            // Add logic to check for null user.
        }
        return hotelFoundById;
    }

    public Hotel deleteHotel(Hotel hotel){
        this.hotelRepository.delete(hotel);
        return hotel;
    }

    public Hotel deleteHotelById(int id){
        Hotel hotelDeletedById = new Hotel();
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        if(hotel.isPresent()){
            this.hotelRepository.deleteById(id);
            hotelDeletedById = hotel.get();
        }
        return hotelDeletedById;
    }

    public List<SearchResult> findHotelByCityDateAndRoomType(String location, LocalDate fromDate, LocalDate toDate){
        return this.hotelRepository.findByCityDateRangeRoomType(location, fromDate, toDate);
    }

}
