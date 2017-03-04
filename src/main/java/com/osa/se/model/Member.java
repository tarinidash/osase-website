package com.osa.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by tarinidash on 2/27/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member", schema = "osase")
@DynamicUpdate
@DynamicInsert
public class Member implements Serializable {

    public static final Member NULL_MEMBER = new Member();

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String member_id;

    @Column(name = "email", columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

    @Column(name = "first_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String lastName;

    @Column(name = "role", columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'member'")
    private String role;

    @Column(name = "gender", columnDefinition = "VARCHAR(255) NOT NULL")
    private String gender;

    @Column(name = "birth_date")
    private Timestamp birth_dt;

    @Column(name = "interests")
    private String interests;

    @Column(name = "phone_home")
    private String phoneHome;

    @Column(name = "phone_mobile", columnDefinition = "VARCHAR(255) NOT NULL")
    private String phoneMobile;

    @Column(name = "address1", columnDefinition = "VARCHAR(255) NOT NULL")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city", columnDefinition = "VARCHAR(255) NOT NULL")
    private String city;

    @Column(name = "state", columnDefinition = "VARCHAR(255) NOT NULL")
    private String state;

    @Column(name = "zipcode", columnDefinition = "VARCHAR(255) NOT NULL")
    private Integer zipCode;

    @Column(name = "created_timestamp", columnDefinition = "TIMESTAMP NOT NULL")
    private Timestamp created_timestamp;

    @Column(name = "last_modified_timestamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp last_modified_timestamp;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

}
