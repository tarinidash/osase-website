package com.osa.se.controller;

import com.osa.se.model.Notification;
import com.osa.se.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tarinidash on 3/2/17.
 */
@RestController
@RequestMapping(value = "/notification")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping(value = {"/findAll", "/findAll/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Notification>> findAll() {
        return new ResponseEntity<>(notificationService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/findOne/{notificationId}", "/findOne/{notificationId}/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Notification> findOne(@PathVariable String notificationId) {
        return new ResponseEntity<>(notificationService.findOne(notificationId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/save", "/save/"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Notification> save(@RequestBody @Valid Notification notification) {
        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/delete/{notificationId}", "/delete/{notificationId}/"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<HttpStatus> delete(@PathVariable String notificationId) {
        notificationService.delete(notificationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
