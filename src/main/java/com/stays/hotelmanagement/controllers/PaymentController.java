package com.stays.hotelmanagement.controllers;

import com.stays.hotelmanagement.entities.Payment;
import com.stays.hotelmanagement.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //Add a payment
    @PostMapping(value = "/payment", produces = "application/json", consumes = "application/json")
    public Payment addPayment(@RequestBody Payment newPayment) {
        return this.paymentService.addPayment(newPayment);
    }

    //Find all Payments
    @GetMapping(value = "/payment")
    public List<Payment> getAllPayments() {
        return this.paymentService.getAllPayments();
    }

    //Find Payment details by BookingId
    /*@GetMapping(value = "payment/{bookingId}")
    public List<Payment> findPaymentById(@PathVariable("bookingId") String bookingId) {
        return this.paymentService.findPaymentById(bookingId);
    }*/

    //Find Payment details by Payment Mode
/*    @GetMapping(value = "payment/paymentMode/{mode}")
    public List<Payment> findPaymentByPaymentMode(@PathVariable("mode") String paymentMode) {
        return this.paymentService.findPaymentByMode(paymentMode);
    }*/

    //Update a payment
    @PutMapping(value = "/payment", produces = "application/json", consumes = "application/json")
    public Payment updatePayment(Payment existingPayment) {
            return this.paymentService.updatePayment(existingPayment);
    }

    //Delete a payment
    @DeleteMapping(value = "/payment/{paymentId}")
    public boolean deletePayment(@PathVariable("paymentId") Integer paymentId){
        return this.paymentService.deletePayment(paymentId);
    }
}
