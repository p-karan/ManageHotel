package com.stays.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HBMS_USERS")
public class Users {

    @Id
    /*@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")*/
    /*@GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ID_GENERATOR")
    @SequenceGenerator(name="USER_ID_GENERATOR", sequenceName = "HBMS_USER_ID_SEQ")*/
    @Column(nullable = false, length = 6)
    private String userId;

    @Column(nullable = false, unique = true, length=40)
    private String userName;

    @Column(nullable = false , length=15)
    private String password;

    @Column(nullable = false, length=80)
    private String fullName;

    @Column(nullable = false, length=20)
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column(length=40)
    private String workLocation;

    @Embedded
    private Address addresses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userId", nullable = false, insertable = false, updatable = false)
    private Set<Booking> bookings;

    public enum Roles {
        ADMIN, EMPLOYEE, USER
    }

}
