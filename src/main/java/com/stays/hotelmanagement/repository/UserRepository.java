package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {

    Optional<Users> findByUserId(int userId);
    Optional<Users> findUsersByUserName(String userName);
    Boolean existsByUserId(int userId);
    void deleteByUserId(int userId);
    void deleteByUserName(String userName);

}