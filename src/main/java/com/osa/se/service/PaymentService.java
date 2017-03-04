package com.osa.se.service;

import com.osa.se.dao.PaymentRepository;
import com.osa.se.model.Payment;
import org.springframework.stereotype.Service;


/**
 * Created by tarinidash on 2/28/17.
 */
@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment findOne(String paymentId) {
        return paymentRepository.findOne(paymentId);
    }

    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public boolean exists(String paymentId) {
        return paymentRepository.exists(paymentId);
    }

    public long count() {
        return paymentRepository.count();
    }

    public void delete(String paymentId) {
        paymentRepository.delete(paymentId);
    }

    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    public void deleteAll() {
        paymentRepository.deleteAll();
    }

}
