package com.osa.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by tarinidash on 2/27/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment", schema = "osase")
@DynamicInsert
@DynamicUpdate
public class Payment implements Serializable {

    public static final Payment NULL_EVENT = new Payment();

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paymentId;

    @Column(name = "payment_amount", columnDefinition = "DECIMAL(10,2) NOT NULL")
    private BigDecimal paymentAmount;

    @Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
    private String description;

    @Column(name = "donation_amount", columnDefinition = "DECIMAL(10,2) NOT NULL DEFAULT 0.0")
    private BigDecimal donationAmount;

    @Column(name = "payment_timestamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp payment_timestamp;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
