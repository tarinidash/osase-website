package com.osa.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by tarinidash on 2/27/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "family", schema = "osase", uniqueConstraints = {
        @UniqueConstraint(columnNames = "family_name"),
        @UniqueConstraint(columnNames = "user_name"),
        @UniqueConstraint(columnNames = "password"),})
@DynamicUpdate
@DynamicInsert
public class Family implements Serializable {

    public static final Family NULL_FAMILY = new Family();

    @Id
    @Column(name = "family_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String familyId;

    @Column(name = "family_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String familyName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "family")
    private Set<Member> members;

    @Column(name = "user_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String userName;

    @Column(name = "password", columnDefinition = "VARCHAR(255) NOT NULL")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "family")
    private Set<Payment> payments;

    @Column(name = "created_timestamp", columnDefinition = "TIMESTAMP NOT NULL")
    private Timestamp created_timestamp;
}
