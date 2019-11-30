package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="HBMS_PAYMENT_DETAILS")

public class Payment {

    @Id
    @Column(name = "PAYMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String paymentId;

    @Column(name = "BOOKING_ID", nullable = false)
    private String bookingId;

    @Column(name = "PAY_STATUS")
    private String payStatus;

    @Column(name = "PAY_AMOUNT")
    private double payAmount;

    @Column(name = "PAY_DATE")
    private LocalDate payDate;

    @Column(name = "PAY_MODE")
    private String payMode;

}
