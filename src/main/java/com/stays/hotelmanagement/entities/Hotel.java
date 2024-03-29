package com.stays.hotelmanagement.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;


@Entity
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="HBMS_HOTELS")
public class Hotel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 6)
    private int hotelId;

    @Column(nullable = false, length = 100)
    private String hotelName;

    @Embedded
    @Column(nullable = false)
    private Address addresses;


/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="hotelId", nullable = false)
    private Set<Room> rooms;*/

    @Column(nullable = false , precision = 2, scale = 1, columnDefinition = "FLOAT DEFAULT 0.0")
    private double rating;

    @Column(nullable = false, length = 400)
    private String hotelDescription;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0",length = 2)
    private int discount;

    @Column(nullable = false, length = 5)
    private String hotelOperationalStatus;


}
