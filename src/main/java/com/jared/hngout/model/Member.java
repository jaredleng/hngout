package com.jared.hngout.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends User {

    private int age;
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "member_events",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events = new ArrayList<>();

    public Member(String name, String email, String password,
                  String contactNumber, int age, String gender) {
        super(name, email, password, contactNumber);
        this.age = age;
        this.gender = gender;
    }
}