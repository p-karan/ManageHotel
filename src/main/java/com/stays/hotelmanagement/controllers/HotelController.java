package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Hotel;
import com.stays.hotelmanagement.services.HotelServices;
import com.stays.hotelmanagement.services.MailUtilityService;
import com.stays.hotelmanagement.transactionalObject.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(value="*")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    @Autowired
    private Hotel hotel;

    @Autowired
    private MailUtilityService mailUtilityService;

    @GetMapping(value = "/hotel")
    public List<Hotel> getHotel(){

        return this.hotelServices.getAll();
    }

    //Add Hotel
    @PostMapping(value = "/hotel", produces = "application/json", consumes = "application/json")
    public Hotel add(@RequestBody Hotel hotel){
        String message = "Hotel Added successfully";
        hotel= this.hotelServices.addHotel(hotel);
        if (hotel != null)
        {
              mailUtilityService.sendMail(message);
        }
        return hotel;
    }

    @PutMapping(value = "/hotel", produces = "application/json", consumes = "application/json")
    public Hotel update(@RequestBody Hotel hotel){
        String message = "Hotel Updated successfully";
        hotel = this.hotelServices.updateHotel(hotel);
        if (hotel != null)
        {
            mailUtilityService.sendMail(message);
        }
        return hotel;
    }

    @GetMapping(value = "/hotel/hotelId/{id}")
    public Hotel findHotelById(@PathVariable("id") int id){

        return this.hotelServices.findById(id);
    }

    @GetMapping(value="/hotel/city/Name/{city}/{hotelName}")
    public Hotel findByCityAndName(@PathVariable("city") String city, @PathVariable("hotelName") String hotelName){
        return this.hotelServices.findAllHotelByNameanCity(city, hotelName);
    }

    @DeleteMapping(value = "/hotel/{id}", produces = "application/json")
    public Hotel deleteHotelById(@PathVariable("id") int id){
        return this.hotelServices.deleteHotelById(id);
    }

    @DeleteMapping(value = "/hotel", produces = "application/json", consumes = "application/json")
    public Hotel deleteHotel(@RequestBody Hotel hotel){

        return this.hotelServices.deleteHotel(hotel);
    }

    @GetMapping("/hotel/sort/{propName}")
    public Iterable<Hotel> showSortBy(@PathVariable("propName") String propName){

        return this.hotelServices.sortBy(propName);
    }
    @GetMapping(value = "/hotel/{city}/{fromDate}/{toDate}")
    public List<SearchResult> getHotelSearchList(@PathVariable("city") String city,
                                                 @PathVariable("fromDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                                                 @PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate){

        return this.hotelServices.findHotelByCityDateAndRoomType(city, fromDate, toDate);
    }

    @GetMapping(value="/hotel/{city}")
    public List<Hotel> findAllByAddresses_AddressCity(@PathVariable("city") String city){
        return this.hotelServices.findAllByAddresses_AddressCity(city);
    }
}
