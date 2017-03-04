package com.osa.se.dao;

import com.osa.se.model.Ledger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tarinidash on 2/28/17.
 */
@Repository
@Transactional
public interface LedgerRepository extends CrudRepository<Ledger, String> {

    public Ledger findFirstByOrderByLedgerIdDesc();

    public Ledger findTopByOrderByLedgerIdDesc();

    public Ledger findFirstByOrderByLedgerIdAsc();

}
