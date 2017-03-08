package com.osa.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by tarinidash on 2/27/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ledger", schema = "osase")
@DynamicInsert
@DynamicUpdate
public class Ledger {

    public static final Ledger NULL_FAMILY = new Ledger();

    @Id
    @Column(name = "ledger_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ledgerId;

    @Column(name = "created_timestamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_timestamp;

    @Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
    private String description;

    @Column(name = "type", columnDefinition = "VARCHAR(255) NOT NULL")
    private String type;

    @Column(name = "credit", columnDefinition = "DECIMAL(20,2) NOT NULL DEFAULT 0.0")
    private BigDecimal credit;

    @Column(name = "debit", columnDefinition = "DECIMAL(20,2) NOT NULL DEFAULT 0.0")
    private BigDecimal debit;

    @Column(name = "balance", columnDefinition = "DECIMAL(20,2) NOT NULL")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

}
