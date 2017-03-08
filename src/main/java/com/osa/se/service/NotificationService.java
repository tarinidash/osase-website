package com.osa.se.service;

import com.osa.se.dao.NotificationRepository;
import com.osa.se.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 * Created by tarinidash on 2/28/17.
 */
@Service
@Slf4j
public class NotificationService {

    private NotificationRepository NotificationRepository;
    private JavaMailSender javaMailSender;
    private String notifiedBy;

    public NotificationService(NotificationRepository NotificationRepository, JavaMailSender javaMailSender, @Value("${spring.mail.username}") final String notifiedBy) {
        this.NotificationRepository = NotificationRepository;
        this.javaMailSender = javaMailSender;
        this.notifiedBy = notifiedBy;
    }

    public Notification save(Notification notification) {
        sendMail(notification);
        notification.setNotified_by(notifiedBy);
        return NotificationRepository.save(notification);
    }

    public Notification findOne(String NotificationId) {
        return NotificationRepository.findOne(NotificationId);
    }

    public Iterable<Notification> findAll() {
        return NotificationRepository.findAll();
    }

    public boolean exists(String NotificationId) {
        return NotificationRepository.exists(NotificationId);
    }

    public long count() {
        return NotificationRepository.count();
    }

    public void delete(String NotificationId) {
        NotificationRepository.delete(NotificationId);
    }

    public void delete(Notification Notification) {
        NotificationRepository.delete(Notification);
    }

    public void deleteAll() {
        NotificationRepository.deleteAll();
    }

    private void sendMail(Notification Notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(Notification.getDescription());
        message.setSubject(Notification.getNotification_name());
        message.setTo(Notification.getNotified_to());
        javaMailSender.send(message);
    }
}
