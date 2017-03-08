package com.osa.se.service;

import com.osa.se.dao.EventRepository;
import com.osa.se.model.Event;
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
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event event) {
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

}
