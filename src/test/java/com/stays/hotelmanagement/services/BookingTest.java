package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Booking;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BookingTest {

    @Test
    public void testTrue(){
        Booking bookTest = new Booking();
        //Check bookedFromDate < bookedToDate
        //Check bookedFromDate != bookedToDate
        //Check checkInDateTime < checkOutDateTime
        //Check checkInDateTime != checkOutDateTime

        //Check bookedFromDate < checkInDateTime
        //Check checkInDateTime < bookedToDate
        //Check checkOutDateTime < bookedToDate

        //daysBooked = (bookedToDate - bookedFromDate)
        //daysBooked !=0

        //bookedBy = userName (If user booked the room)
        //bookedBy != userName (If Emp booked the room)

        //bookingAmount != null
        //bookingAmount > 0

        //hotelId !=null
        //roomId !=null
        //userId !=null
        //userId should derived from userName
    }
}
