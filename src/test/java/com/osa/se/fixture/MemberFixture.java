package com.osa.se.fixture;

import com.osa.se.model.Member;

import java.sql.Timestamp;

/**
 * Created by tarinidash on 2/28/17.
 */
public class MemberFixture {

    public static Member getMember() {
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setFirstName("firstName");
        member.setMiddleName("middleName");
        member.setLastName("lastName");
        member.setGender("male");
        member.setBirth_dt(new Timestamp(234522334532L));
        member.setInterests("cricket");
        member.setPhoneHome("1232434323");
        member.setPhoneMobile("98765443221");
        member.setAddress1("451 Christian Creek Pl");
        member.setAddress2("its a place");
        member.setCity("cary");
        member.setState("NC");
        member.setZipCode(27519);
        member.setCreated_timestamp(new Timestamp(System.currentTimeMillis() - 434324134634L));
        return member;
    }

    public static Member getMember1() {
        Member member = new Member();
        member.setEmail("test2@gmail.com");
        member.setFirstName("firstName2");
        member.setMiddleName("middleName2");
        member.setLastName("lastName2");
        member.setGender("male2");
        member.setBirth_dt(new Timestamp(534233245453L));
        member.setInterests("cricket2");
        member.setPhoneHome("12324343232");
        member.setPhoneMobile("987654432212");
        member.setAddress1("451 Christian Creek Pl2");
        member.setAddress2("its a place2");
        member.setCity("cary");
        member.setState("NC");
        member.setZipCode(27519);
        member.setCreated_timestamp(new Timestamp(System.currentTimeMillis() - 233123434634L));
        return member;
    }

    public static Member getMember2() {
        Member member = new Member();
        member.setEmail("test3@gmail.com");
        member.setFirstName("firstName3");
        member.setMiddleName("middleName3");
        member.setLastName("lastName3");
        member.setGender("male3");
        member.setBirth_dt(new Timestamp(834243245345L));
        member.setInterests("cricket3");
        member.setPhoneHome("12324343233");
        member.setPhoneMobile("987654432213");
        member.setAddress1("451 Christian Creek Pl3");
        member.setAddress2("its a place3");
        member.setCity("cary");
        member.setState("NC");
        member.setZipCode(27519);
        member.setCreated_timestamp(new Timestamp(System.currentTimeMillis() - 346334456L));
        return member;
    }
}
