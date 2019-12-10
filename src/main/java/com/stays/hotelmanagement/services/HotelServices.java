package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.repository.GenericRepository;
import com.stays.hotelmanagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServices {

    @Autowired
    private HotelRepository repo;

    public Iterable<Hotel> getAll(){

        return this.repo.findAll();
    }

    public Iterable<Hotel> sortBy(String propName){

        Sort sortBy = Sort.by(propName);

        return this.repo.findAll(sortBy);
    }

    public Page<Hotel> paginate(int pageNo, int size, String prop){

        Pageable pageRequest = PageRequest.of(pageNo,size,Sort.by(prop));

        Page<Hotel> page = repo.findAll(pageRequest);

        List<Hotel> hotelsList = new ArrayList<>();

        if(page.hasContent()){
            hotelsList = page.getContent();
        }

        return page;
    }

    public Hotel addHotel(Hotel hotel){
        return (Hotel) this.repo.save(hotel);
    }

    public Hotel updateHotel(Hotel hotel){
        return (Hotel) this.repo.save(hotel);
    }

    public Optional<Hotel> findById(long id){

        return this.repo.findById(id);
    }

    public Hotel deleteHotel(Hotel hotel){
        this.repo.delete(hotel);
        return hotel;
    }

    public String deleteHotelById(long id){
        String message="";
        this.repo.deleteById(id);
        boolean isDeleted = this.repo.existsById(id);
        if(isDeleted){
            message = "Hotel with ID " + id + "is not deleted";
        }
        else{
            message = "Hotel with ID " + id + "is deleted";
        }
        return message;
    }
}
