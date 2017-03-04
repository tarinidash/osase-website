package com.osa.se.fixture;

import com.osa.se.model.Family;

import java.sql.Timestamp;

/**
 * Created by tarinidash on 2/28/17.
 */
public class FamilyFixture {

    public static Family getFamily() {
        Family family = new Family();
        family.setUserName("userName");
        family.setPassword("password");
        family.setFamilyName("familyName");
        family.setCreated_timestamp(new Timestamp(System.currentTimeMillis() - 32178473));
        return family;
    }
}
