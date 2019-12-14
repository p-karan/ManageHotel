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
    private int hotelId;
    private String addressCity;
    private String roomType;
   /* private LocalDate fromDate;
    private LocalDate toDate;*/

    public SearchResult(int roomId, int hotelId, String roomType) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
    }

   /* public SearchResult(int roomId, int hotelId, String addressCity, String roomType) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.addressCity = addressCity;
        this.roomType = roomType;
    }*/
}
