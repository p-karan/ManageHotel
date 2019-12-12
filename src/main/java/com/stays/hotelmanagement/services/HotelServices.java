package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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

    /*public boolean checkHotelExist(int id) {
        boolean isHotelPresent = false;
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        if (hotel.isPresent()) {
            isHotelPresent = true;
        }
        return isHotelPresent;
    }*/
}
