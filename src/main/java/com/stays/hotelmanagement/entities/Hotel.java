//package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HBMS_HOTELS")
public class Hotel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 6)
    private String hotelId;

    @Column(nullable = false, length = 40)
    private String hotelName;


}
*/
