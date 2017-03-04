package com.osa.se.controller;

import com.osa.se.model.Event;
import com.osa.se.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tarinidash on 3/2/17.
 */
@RestController
@RequestMapping(value = "/event")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = {"/findAll", "/findAll/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Event>> findAll() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/findOne/{eventId}", "/findOne/{eventId}/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Event> findOne(@PathVariable String eventId) {
        return new ResponseEntity<>(eventService.findOne(eventId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/save", "/save/"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Event> save(@RequestBody @Valid Event event) {
        return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/delete/{eventId}", "/delete/{eventId}/"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<HttpStatus> delete(@PathVariable String eventId) {
        eventService.delete(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
