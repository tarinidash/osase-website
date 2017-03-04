package com.osa.se.service;

import com.osa.se.dao.MemberRepository;
import com.osa.se.model.Member;
import org.springframework.stereotype.Service;


/**
 * Created by tarinidash on 2/28/17.
 */
@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public Member findOne(String memberId) {
        return memberRepository.findOne(memberId);
    }

    public Iterable<Member> findAll() {
        return memberRepository.findAll();
    }

    public boolean exists(String memberId) {
        return memberRepository.exists(memberId);
    }

    public long count() {
        return memberRepository.count();
    }

    public void delete(String memberId) {
        memberRepository.delete(memberId);
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

    public void deleteAll() {
        memberRepository.deleteAll();
    }

}
