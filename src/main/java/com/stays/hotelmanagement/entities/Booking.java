package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
<<<<<<< HEAD
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


=======
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HBMS_BOOKING_DETAILS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="bookingId", nullable = false)
    private Set<Payment> paymentSet;
>>>>>>> 60d504f1c1451239fa8449484a0e53fb70eab867
}
