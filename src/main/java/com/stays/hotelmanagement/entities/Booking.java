package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="HBMS_BOOKING_DETAILS")
public class Booking {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String bookingId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String hotelId;

    @Column(nullable = false)
    private String roomId;

    private int daysBooked;

    @Column(nullable = false)
    private LocalDate bookedFromDate;

    @Column(nullable = false)
    private LocalDate bookedToDate;

    private LocalDateTime checkInDateTime;

    private LocalDateTime checkOutDateTime;

    @Column(nullable = false)
    private int bookingAmount;

    @Column(nullable = false)
    private int noOfAdults;

    private int noOfChildrens;

    private String bookedBy;

    private String blocked;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOKING_ID", nullable = false)
    private Set<Payment> paymentList;


}
