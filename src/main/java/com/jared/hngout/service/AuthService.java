package com.jared.hngout.service;
import com.jared.hngout.dto.LoginRequest;
import com.jared.hngout.model.User;
import com.jared.hngout.repository.MemberRepository;
import com.jared.hngout.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.jared.hngout.dto.MemberDto;
import com.jared.hngout.dto.RegisterRequest;
import com.jared.hngout.model.Member;

import java.util.Optional;

@Service

public class AuthService {
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;

    public AuthService(UserRepository userRepository, MemberRepository memberRepository) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;

    }

    public MemberDto register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already registered");
        }
        Member member = new Member(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getContactNumber(),
                request.getAge(),
                request.getGender()
        );
        Member savedMember = memberRepository.save(member);
        return new MemberDto(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getEmail(),
                savedMember.getContactNumber(),
                savedMember.getAge(),
                savedMember.getGender()
        );
    }

    public MemberDto login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail()); {
            if (optionalUser.isEmpty()) {
                throw new IllegalArgumentException("Email has not been registered");
            }
            User user = optionalUser.get();
            if (!user.getPassword().equals(loginRequest.getPassword())) {
                throw new IllegalArgumentException("Passsword does not match");
            }


            Member checkMember = memberRepository.findById(user.getId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Member account not found"));

            return new MemberDto(
                    checkMember.getId(),
                    checkMember.getName(),
                    checkMember.getEmail(),
                    checkMember.getContactNumber(),
                    checkMember.getAge(),
                    checkMember.getGender()

            );
        }

    }
}
