package com.stays.hotelmanagement.repository;

import com.stays.hotelmanagement.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

   /* public List<Payment> findAllPaymentDetailsByBookingId(String bookingId);

    public String deletePaymentDetailsByBookingId(String bookingId);*/

}
