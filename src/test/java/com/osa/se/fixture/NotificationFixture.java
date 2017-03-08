package com.osa.se.fixture;

import com.osa.se.model.Notification;

/**
 * Created by tarinidash on 2/28/17.
 */
public class NotificationFixture {

    public static Notification getNotification() {
        Notification notification = new Notification();
        notification.setDescription("description");
        notification.setNotification_name("notificationName");
        notification.setNotified_to("osasemember@gmail.com");
        return notification;
    }

    public static Notification getNotification1() {
        Notification notification = new Notification();
        notification.setDescription("description1");
        notification.setNotification_name("notificationName1");
        notification.setNotified_to("osasemember1@gmail.com");
        return notification;
    }
}
