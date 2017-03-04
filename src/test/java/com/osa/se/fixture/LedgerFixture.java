package com.osa.se.fixture;

import com.osa.se.model.Ledger;

import java.math.BigDecimal;

/**
 * Created by tarinidash on 2/28/17.
 */
public class LedgerFixture {

    public static Ledger getLedger() {
        Ledger ledger = new Ledger();
        ledger.setDescription("puja");
        ledger.setType("deposit");
        ledger.setCredit(new BigDecimal(20.54));
        return ledger;
    }

    public static Ledger getLedger1() {
        Ledger ledger = new Ledger();
        ledger.setDescription("puja");
        ledger.setType("withdrawal");
        ledger.setDebit(new BigDecimal(50.32));
        return ledger;
    }

    public static Ledger getLedger2() {
        Ledger ledger = new Ledger();
        ledger.setDescription("puja");
        ledger.setType("deposit");
        ledger.setCredit(new BigDecimal(30.56));
        return ledger;
    }

    public static Ledger getLedger3() {
        Ledger ledger = new Ledger();
        ledger.setDescription("party");
        ledger.setType("deposit");
        ledger.setCredit(new BigDecimal(100.67));
        return ledger;
    }

    public static Ledger getLedger4() {
        Ledger ledger = new Ledger();
        ledger.setDescription("party");
        ledger.setType("withdrawal");
        ledger.setDebit(new BigDecimal(85.23));
        return ledger;
    }

    public static Ledger getLedger5() {
        Ledger ledger = new Ledger();
        ledger.setDescription("party");
        ledger.setType("withdrawal");
        ledger.setDebit(new BigDecimal(31.45));
        return ledger;
    }

    public static Ledger getLedger6() {
        Ledger ledger = new Ledger();
        ledger.setDescription("kumarPurnami");
        ledger.setType("deposit");
        ledger.setCredit(new BigDecimal(25.76));
        return ledger;
    }

    public static Ledger getLedger7() {
        Ledger ledger = new Ledger();
        ledger.setDescription("kumarPurnami");
        ledger.setType("withdrawal");
        ledger.setDebit(new BigDecimal(48.06));
        return ledger;
    }

    public static Ledger getLedger8() {
        Ledger ledger = new Ledger();
        ledger.setDescription("kumarPurnami");
        ledger.setType("withdrawal");
        ledger.setDebit(new BigDecimal(72.90));
        return ledger;
    }
}
