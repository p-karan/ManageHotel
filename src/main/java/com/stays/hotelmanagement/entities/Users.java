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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "hbms_user_id_seq", allocationSize = 1)*/
    @Column(nullable = false, updatable = false)
    private String userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    /*@Column(nullable = false)*/
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
