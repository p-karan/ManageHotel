package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

/*    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;*/

    @Column(nullable = false, length=60)
    private String addressBldgFlat;

    @Column(nullable = false, length=80)
    private String addressStreet;

    @Column(nullable = false, length=40)
    private String addressCity;

    @Column(nullable = false, length=40)
    private String addressState;

    @Column(nullable = false, length=8)
    private String addressPincode;

    @Column(nullable = false, length=40)
    private String email;

    @Column(nullable = false, length=15)
    private String mobileNo;

    @Column(length=15)
    private String primaryPhone;

    @Column(length=15)
    private String secondaryPhone;
}
