package com.osa.se.controller;

import com.osa.se.model.Payment;
import com.osa.se.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tarinidash on 3/2/17.
 */
@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = {"/findAll", "/findAll/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Payment>> findAll() {
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/findOne/{paymentId}", "/findOne/{paymentId}/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Payment> findOne(@PathVariable String paymentId) {
        return new ResponseEntity<>(paymentService.findOne(paymentId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/save", "/save/"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Payment> save(@RequestBody @Valid Payment payment) {
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/delete/{paymentId}", "/delete/{paymentId}/"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<HttpStatus> delete(@PathVariable String paymentId) {
        paymentService.delete(paymentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
