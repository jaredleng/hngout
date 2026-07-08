package com.jared.hngout.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends User {
    @Min(value = 1, message = "Age must be at least 1")
    private int age;
    @NotBlank(message="Gender is required")
    private String gender;

    @JsonIgnore
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