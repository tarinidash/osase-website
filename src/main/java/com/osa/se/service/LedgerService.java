package com.osa.se.service;

import com.osa.se.dao.LedgerRepository;
import com.osa.se.model.Ledger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * Created by tarinidash on 2/28/17.
 */
@Service
@Slf4j
public class LedgerService {

    private LedgerRepository ledgerRepository;

    public LedgerService(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public Ledger save(Ledger ledger) {
//        find lastest balance and calculate the new balance
        BigDecimal oldBalance = new BigDecimal(0.00);
        Ledger ledger1 = ledgerRepository.findFirstByOrderByLedgerIdDesc();
        if (ledger1 != null) {
            oldBalance = ledger1.getBalance();
        }

        if (ledger.getCredit() != null && !ledger.getCredit().equals(0.00)) {
            oldBalance = oldBalance.add(ledger.getCredit());
        }

        if (ledger.getDebit() != null && !ledger.getDebit().equals(0.00)) {
            oldBalance = oldBalance.subtract(ledger.getDebit());
        }

        ledger.setBalance(oldBalance);
        return ledgerRepository.save(ledger);
    }

    public Ledger findOne(String ledgerId) {
        return ledgerRepository.findOne(ledgerId);
    }

    public Ledger findLast() {
        return ledgerRepository.findFirstByOrderByLedgerIdDesc();
    }

    public Ledger findFirst() {
        return ledgerRepository.findFirstByOrderByLedgerIdAsc();
    }

    public Iterable<Ledger> findAll() {
        return ledgerRepository.findAll();
    }

    public boolean exists(String ledgerId) {
        return ledgerRepository.exists(ledgerId);
    }

    public long count() {
        return ledgerRepository.count();
    }

    public void delete(String ledgerId) {
        ledgerRepository.delete(ledgerId);
    }

    public void delete(Ledger ledger) {
        ledgerRepository.delete(ledger);
    }

    public void deleteAll() {
        ledgerRepository.deleteAll();
    }


}
