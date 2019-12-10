package com.stays.hotelmanagement.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;

    @ManyToOne
    private Hotel hotel;

    @Column(nullable = false)
    private double ratePerNight;

    @Column(nullable = false)
    private int roomNo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking booking;

}

