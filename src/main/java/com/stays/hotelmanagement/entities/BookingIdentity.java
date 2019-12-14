package com.stays.hotelmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingIdentity implements Serializable {

    private int bookingId;

    private int roomId;
}
