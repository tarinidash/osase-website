package com.osa.se.fixture;

import com.osa.se.model.Payment;

import java.math.BigDecimal;

/**
 * Created by tarinidash on 2/28/17.
 */
public class PaymentFixture {

    public static Payment getPayment() {
        Payment payment = new Payment();
        payment.setPaymentAmount(new BigDecimal(123124.12));
        payment.setDescription("puja1");
        return payment;
    }

    public static Payment getPayment1() {
        Payment payment = new Payment();
        payment.setPaymentAmount(new BigDecimal(224.12));
        payment.setDescription("puja2");
        return payment;
    }

    public static Payment getPayment2() {
        Payment payment = new Payment();
        payment.setPaymentAmount(new BigDecimal(3124.12));
        payment.setDescription("puja3");
        return payment;
    }
}
