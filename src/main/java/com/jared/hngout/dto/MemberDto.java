package com.jared.hngout.dto;

import com.jared.hngout.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private int age;
    private String gender;
    public MemberDto(Long id, String name, String email,
                     String contactNumber, int age, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.age = age;
        this.gender = gender;
    }





}
