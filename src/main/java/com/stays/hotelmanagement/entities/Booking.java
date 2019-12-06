package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HBMS_BOOKING_DETAILS")
public class Booking {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String bookingId;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate bookedFromDate;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE+1")
    private LocalDate bookedToDate;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private int daysBooked;

    //    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime checkInDateTime;

    //    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime checkOutDateTime;

    @Column(nullable = false, precision = 10, scale = 2, columnDefinition = "FLOAT DEFAULT 0.0")
    private double bookingAmount;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private int noOfAdults;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int noOfChildrens;

    @Column(nullable = false)
    private String bookedBy;

    @Column(nullable = false)
    private String bookingStatus;

    @Column(nullable = false)
    private String hotelId;

    @Column(nullable = false)
    private String roomId;

    private String userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="bookingId", nullable = false)
    private Set<Payment> paymentSet;
}