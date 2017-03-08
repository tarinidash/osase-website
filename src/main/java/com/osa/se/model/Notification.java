package com.osa.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tarinidash on 2/27/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification", schema = "osase")
@DynamicInsert
@DynamicUpdate
public class Notification {

    public static final Notification NULL_notification = new Notification();

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String notificationId;

    @Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
    private String description;

    @Column(name = "created_timestamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_timestamp;

    @Column(name = "notification_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String notification_name;

    @Column(name = "notified_to", columnDefinition = "VARCHAR(255) NOT NULL DEFAULT 'osase@googlegroups.com'")
    private String notified_to;

    @Column(name = "notified_by", columnDefinition = "VARCHAR(255) NOT NULL DEFAULT 'osase_office+noreply@googlegroups.com'")
    private String notified_by;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
