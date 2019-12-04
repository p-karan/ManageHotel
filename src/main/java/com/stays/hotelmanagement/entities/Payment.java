package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="HBMS_PAYMENT_DETAILS")
public class Payment {

    @Id
    @Column(unique = true, length=6)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    private String paymentId;

    @Column(nullable = false, length=40)
    private String payStatus;

    @Column(nullable = false , precision = 10, scale = 2, columnDefinition = "FLOAT DEFAULT 0.0")
    private double payAmount;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate payDate;

    @Column(nullable = false, length=20)
    @Enumerated(EnumType.STRING)
    private paymentModes payMode;

    public enum paymentModes {
        CARD, CASH
    }

}
