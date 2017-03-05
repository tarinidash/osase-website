package com.osa.se.fixture;

import com.osa.se.model.Event;

/**
 * Created by tarinidash on 2/28/17.
 */
public class EventFixture {

    public static Event getEvent() {
        Event event = new Event();
        event.setDescription("description");
        event.setEvent_name("eventName");
        event.setNotified_to("osasemember@gmail.com");
        return event;
    }

    public static Event getEvent1() {
        Event event = new Event();
        event.setDescription("description1");
        event.setEvent_name("eventName1");
        event.setNotified_to("osasemember1@gmail.com");
        return event;
    }
}
