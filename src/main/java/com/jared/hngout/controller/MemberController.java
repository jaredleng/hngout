package com.jared.hngout.controller;

import com.jared.hngout.dto.MemberDto;
import com.jared.hngout.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jared.hngout.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member created = memberService.createMember(member);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAll() {
        List<MemberDto> member = memberService.getAllMembers();
        return ResponseEntity.ok(member);

    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto> getId(@PathVariable Long memberId) {
        MemberDto member = memberService.getMemberById(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);

    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody Member data) {
        Member member = memberService.updateMember(memberId, data);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);

    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long Id) {

        boolean deleted = memberService.deleteMember(Id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{memberId}/join/{eventId}")
    public ResponseEntity<Member> joinEvent(@PathVariable Long memberId,@PathVariable Long eventId){
        Member member=memberService.joinEvent(memberId,eventId);
        if(member==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }


}
