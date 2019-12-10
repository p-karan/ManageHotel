package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    Optional<Payment> findByPaymentId(Integer paymentId);
    void deleteByPaymentId(Integer paymentId);
    boolean existsByPaymentId(Integer paymentId);
}