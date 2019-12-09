package com.stays.hotelmanagement.services;

import com.stays.hotelmanagement.entities.Payment;
import com.stays.hotelmanagement.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    //Add a payment
    public Payment addPayment(Payment newPayment) {
        return this.paymentRepository.save(newPayment);
    }

    //Check if a particular paymentId exists.
    public boolean checkPaymentExist(String paymentId) {
        boolean isPaymentIdPresent = false;
        Optional<Payment> paymentFound = this.paymentRepository.findById(paymentId);
        if (paymentFound.isPresent()) {
            isPaymentIdPresent = true;
        }
        return isPaymentIdPresent;
    }

    //Find all Payments
    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll();
    }

    //Find Payment details by BookingId
   /* public List<Payment> findPaymentById(String bookingId) {
        return this.paymentRepository.findAllById(bookingId);
    }*/

    //Find Payment details by Payment Mode
/*    public List<Payment> findPaymentByMode(String paymentMode) {
        return this.paymentRepository.findAllByPaymentMode(paymentMode);
    }*/

    //Update a payment
    public Payment updatePayment(Payment existingPayment) {
        boolean isPaymentIdPresent = this.checkPaymentExist(existingPayment.getPaymentId());
        if (isPaymentIdPresent) {
            this.paymentRepository.save(existingPayment);
        }
        return existingPayment;
    }

    //Delete a payment
    public boolean deletePayment(String paymentId) {
        boolean isDeleteSuccessful = false;
        boolean isPaymentIdPresent = this.checkPaymentExist(paymentId);
        if (isPaymentIdPresent) {
            this.paymentRepository.deleteById(paymentId);
            boolean isPaymentAvailable = this.paymentRepository.existsById(paymentId);
            if (!isPaymentAvailable) {
                isDeleteSuccessful = true;
            }
        }
        return isDeleteSuccessful;
    }
}
