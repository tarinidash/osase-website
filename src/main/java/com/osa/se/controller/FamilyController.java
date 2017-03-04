package com.osa.se.controller;

import com.osa.se.model.Family;
import com.osa.se.service.FamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tarinidash on 3/2/17.
 */
@RestController
@RequestMapping(value = "/family")
public class FamilyController {

    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @RequestMapping(value = {"/findAll", "/findAll/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Family>> findAll() {
        return new ResponseEntity<>(familyService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/findOne/{familyId}", "/findOne/{familyId}/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Family> findOne(@PathVariable String eventId) {
        return new ResponseEntity<>(familyService.findOne(eventId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/save", "/save/"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Family> save(@RequestBody @Valid Family family) {
        return new ResponseEntity<>(familyService.save(family), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/delete/{familyId}", "/delete/{eventId}/"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<HttpStatus> delete(@PathVariable String eventId) {
        familyService.delete(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
