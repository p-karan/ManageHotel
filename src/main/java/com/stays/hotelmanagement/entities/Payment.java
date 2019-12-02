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
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String paymentId;

    /*@Column(nullable = false)
    private String bookingId;*/

    private String payStatus;

    @Column(nullable = false)
    private double payAmount;

    @Column(nullable = false)
    private LocalDate payDate;

    @Column(nullable = false)
    private String payMode;
}
