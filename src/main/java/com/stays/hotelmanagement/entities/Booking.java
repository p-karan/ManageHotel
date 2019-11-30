package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="HBMS_BOOKING_DETAILS")
public class Booking {

    @Id
    @Column(name = "BOOKING_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String bookingId;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "HOTEL_ID", nullable = false)
    private String hotelId;

    @Column(name = "ROOM_ID", nullable = false)
    private String roomId;

    @Column(name = "DAYS_BOOKED")
    private int daysBooked;

    @Column(name = "BOOKED_FROM_DATE")
    private LocalDate bookedFromDate;

    @Column(name = "BOOKED_TO_DATE")
    private LocalDate bookedToDate;

    @Column(name = "CHECK_IN_DATE_TIME")
    private LocalDateTime checkInDateTime;

    @Column(name = "CHECK_OUT_DATE_TIME")
    private LocalDateTime checkOutDateTime;

    @Column(name = "BOOKING_AMOUNT")
    private int bookingAmount;

    @Column(name = "NO_OF_ADULTS")
    private int noOfAdults;

    @Column(name = "NO_OF_CHILDREN")
    private int noOfChildrens;

    @Column(name = "BOOKED_BY")
    private String bookedBy;

    @Column(name = "BLOCKED")
    private String blocked;
}
