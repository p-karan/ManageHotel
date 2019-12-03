package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> 60d504f1c1451239fa8449484a0e53fb70eab867

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

<<<<<<< HEAD
    /*@Column(nullable = false)
    private String bookingId;*/

    private String payStatus;

    @Column(nullable = false)
    private double payAmount;

    @Column(nullable = false)
    private LocalDate payDate;

    @Column(nullable = false)
    private String payMode;
=======
    @Column(nullable = false)
    private String payStatus;

    @Column(nullable = false , precision = 10, scale = 2, columnDefinition = "FLOAT DEFAULT 0.0")
    private double payAmount;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate payDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private paymentModes payMode;

    public enum paymentModes {
        CARD, CASH
    }

>>>>>>> 60d504f1c1451239fa8449484a0e53fb70eab867
}
