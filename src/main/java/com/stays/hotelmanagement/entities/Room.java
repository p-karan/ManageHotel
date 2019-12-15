package com.stays.hotelmanagement.entities;

import lombok.*;
import javax.persistence.*;
import java.sql.Blob;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="HBMS_ROOMS")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 6)
    private int roomId;

    @Column(nullable = false, length = 6)
    private int hotelId;

    @Column(nullable = false, precision = 10, scale = 2, columnDefinition = "FLOAT DEFAULT 0.0")
    private double ratePerNight;

    @Column(nullable = false, length = 4)
    private int roomNo;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false, length = 400)
    private String roomDescription;

}

