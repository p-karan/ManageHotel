package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HotelController {

    @Autowired
    private HotelServices service;

    @GetMapping(value = "/hotel")
    public Iterable<Hotel> getHotel(){

        return this.service.getAll();
    }

    @PostMapping(value = "/hotel", produces = "application/json", consumes = "application/json")
    public Hotel add(@RequestBody Hotel hotel){

        return this.service.addHotel(hotel);
    }

    @PutMapping(value = "/hotel", produces = "application/json", consumes = "application/json")
    public Hotel update(@RequestBody Hotel hotel){

        return this.service.updateHotel(hotel);
    }

    @GetMapping(value = "/hotel/id/{id}")
    public Optional<Hotel> findHotelById(@PathVariable("id") long id){

        return this.service.findById(id);
    }

    @DeleteMapping(value = "/hotel/{id}")
    public void deleteHotelById(@PathVariable("id") long id){

        this.service.deleteHotelById(id);
    }

    @DeleteMapping(value = "/hotel", produces = "application/json", consumes = "application/json")
    public void deleteHotel(@RequestBody Hotel hotel){

        this.service.deleteHotel(hotel);
    }

    @GetMapping("/hotel/sort/{propName}")
    public Iterable<Hotel> showSortBy(@PathVariable("propName") String propName){

        return this.service.sortBy(propName);
    }

    @GetMapping("/hotel/paginate/{pageNo}/{size}/{propName}")
    public Page<Hotel> paginate(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size, @PathVariable("propName") String propName){
        return this.service.paginate(pageNo,size,propName);
    }

}
