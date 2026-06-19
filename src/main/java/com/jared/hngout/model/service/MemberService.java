package com.jared.hngout.service;

import com.jared.hngout.model.Event;
import com.jared.hngout.model.Member;
import com.jared.hngout.repository.EventRepository;
import com.jared.hngout.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;

    public MemberService(MemberRepository memberRepository,EventRepository eventRepository){
        this.memberRepository = memberRepository;
        this.eventRepository=eventRepository;
    }

    public Member createMember(Member m){
        return memberRepository.save(m);
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member updateMember(Long id, Member newData){
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null){
            return null;
        }
        member.setName(newData.getName());
        member.setEmail(newData.getEmail());
        member.setPassword(newData.getPassword());
        member.setContactNumber(newData.getContactNumber());
        member.setAge(newData.getAge());
        member.setGender(newData.getGender());
        return memberRepository.save(member);
    }

    public boolean deleteMember(Long id){
        boolean exists = memberRepository.existsById(id);
        if (!exists){
            return false;
        }
        memberRepository.deleteById(id);
        return true;
    }
    public Member joinEvent(Long memberId, Long eventId) {
        Member member= memberRepository.findById(memberId).orElse(null);
        Event event=eventRepository.findById(eventId).orElse(null);// 1. find the member
        // 2. find the event
        if(event==null ||member==null){
            return null;
        }

        // 3. add event to member's events list
        member.getEvents().add(event);
        // 4. save member -> JPA writes the join-table row automatically
       return memberRepository.save(member);

    }
}