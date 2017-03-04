package com.osa.se.controller;

import com.osa.se.model.Ledger;
import com.osa.se.service.LedgerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tarinidash on 3/2/17.
 */
@RestController
@RequestMapping(value = "/ledger")
public class LedgerController {

    private LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @RequestMapping(value = {"/findAll", "/findAll/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Ledger>> findAll() {
        return new ResponseEntity<>(ledgerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/findOne/{ledgerId}", "/findOne/{ledgerId}/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Ledger> findOne(@PathVariable String ledgerId) {
        return new ResponseEntity<>(ledgerService.findOne(ledgerId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/save", "/save/"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Ledger> save(@RequestBody @Valid Ledger ledger) {
        return new ResponseEntity<>(ledgerService.save(ledger), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/delete/{ledgerId}", "/delete/{ledgerId}/"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<HttpStatus> delete(@PathVariable String ledgerId) {
        ledgerService.delete(ledgerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
