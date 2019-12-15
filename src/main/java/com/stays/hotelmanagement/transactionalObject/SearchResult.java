package com.stays.hotelmanagement.transactionalObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {

    private int roomId;
    private String roomType;
    private Double ratePerNight;
    private String roomDescription;

    private int hotelId;
    private String hotelName;
    private String hotelDescription;
    private double hotelRating;
    private int discount;
    private String hotelOperationalStatus;
    private String addressBldgFlat;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressPincode;
    private String email;
    private String mobileNo;
    private String primaryPhone;
    private String secondaryPhone;

 /*   public SearchResult(int roomId, int hotelId, String roomType) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
    }*/

   /* public SearchResult(int roomId, int hotelId, String addressCity, String roomType) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.addressCity = addressCity;
        this.roomType = roomType;
    }*/
}
