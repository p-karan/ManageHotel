package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Booking;
import com.stays.hotelmanagement.entities.Payment;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void testTrue() {
        Payment payTest = new Payment();

        //Check payDate !=null
        //Check payDate <= bookedToDate of Booking
        //Check payDate < bookedToDate of Booking

        //Check payMode != null
        //Check payMode is either CASH, CARD


        //Check bookedFromDate != bookedToDate
        //Check checkInDateTime < checkOutDateTime
        //Check checkInDateTime != checkOutDateTime

        //Check payAmount != null
        //Check sum of payAmount against a Booking ID <= bookingAmount

        //Check bookingId != null
    }
}
