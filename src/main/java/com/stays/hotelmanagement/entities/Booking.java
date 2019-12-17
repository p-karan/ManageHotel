package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HBMS_BOOKING_DETAILS")
/*@IdClass(BookingIdentity.class)*/
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 6)
    private int bookingId;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate bookedFromDate;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE+1")
    private LocalDate bookedToDate;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1",length = 3)
    private int daysBooked;

    private LocalDateTime checkInDateTime;

    private LocalDateTime checkOutDateTime;

    @Column(nullable = false, precision = 10, scale = 2, columnDefinition = "FLOAT DEFAULT 0.0")
    private double bookingAmount;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1",length = 2)
    private int noOfAdults;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0",length = 2)
    private int noOfChildren;

    @Column(nullable = false, length = 40)
    private String bookedBy;

    @Column(nullable = false, length = 40)
    private String bookingStatus;

    @Column(nullable = false, length = 6)
    private int hotelId;

    @Column(nullable = false, length = 6)
    private int roomId;

    @Column(nullable = false, length = 6)
    private int userId;

    @Column(nullable = false, length=40)
    private String userName;

/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="bookingId", nullable = false)
    @JoinColumn(name="roomId", nullable = false)
    private Set<Payment> paymentSet;*/
    @Column(nullable = false, length=10)
    private String payMode;
}
