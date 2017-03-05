package com.osa.se.service;

import com.osa.se.dao.EventRepository;
import com.osa.se.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * Created by tarinidash on 2/28/17.
 */
@Service
@Slf4j
public class EventService {

    private EventRepository eventRepository;
    private JavaMailSender javaMailSender;
    private String notifiedBy;

    public EventService(EventRepository eventRepository, JavaMailSender javaMailSender, @Value("${spring.mail.username}") final String notifiedBy) {
        this.eventRepository = eventRepository;
        this.javaMailSender = javaMailSender;
        this.notifiedBy = notifiedBy;
    }

    public Event save(Event event) {
        sendMail(event);
        event.setNotified_by(notifiedBy);
        return eventRepository.save(event);
    }

    public Event findOne(String eventId) {
        return eventRepository.findOne(eventId);
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    public boolean exists(String eventId) {
        return eventRepository.exists(eventId);
    }

    public long count() {
        return eventRepository.count();
    }

    public void delete(String eventId) {
        eventRepository.delete(eventId);
    }

    public void delete(Event event) {
        eventRepository.delete(event);
    }

    public void deleteAll() {
        eventRepository.deleteAll();
    }

    private void sendMail(Event event){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(event.getDescription());
        message.setSubject(event.getEvent_name());
        message.setTo(event.getNotified_to());
        javaMailSender.send(message);
    }
}
