package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    public Users findUsersByUserName(String userName);
    Optional<Users> findByUserId(int userId);

}
