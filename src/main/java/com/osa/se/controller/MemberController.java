package com.osa.se.controller;

import com.osa.se.model.Member;
import com.osa.se.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tarinidash on 3/2/17.
 */
@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = {"/findAll", "/findAll/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Member>> findAll() {
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/findOne/{memberId}", "/findOne/{memberId}/"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Member> findOne(@PathVariable String memberId) {
        return new ResponseEntity<>(memberService.findOne(memberId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/save", "/save/"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Member> save(@RequestBody @Valid Member member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/delete/{memberId}", "/delete/{memberId}/"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<HttpStatus> delete(@PathVariable String memberId) {
        memberService.delete(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
