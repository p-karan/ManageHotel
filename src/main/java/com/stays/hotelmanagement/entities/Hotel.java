package com.stays.hotelmanagement.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Hotels")
public class Hotel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hotelId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private String hotelEmail;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @Column(nullable = false)
    private int rating;
}
