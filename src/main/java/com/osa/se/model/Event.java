package com.osa.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by tarinidash on 2/27/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event", schema = "osase")
@DynamicInsert
@DynamicUpdate
public class Event {

    public static final Event NULL_EVENT = new Event();

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String eventId;

    @Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
    private String description;

    @Column(name = "created_timestamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_timestamp;

    @Column(name = "event_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String event_name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
    private Set<Notification> notifications;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
    private Set<Payment> payments;
}
