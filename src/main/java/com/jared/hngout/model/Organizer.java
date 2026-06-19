
package com.jared.hngout.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Organizer extends User {

    private String companyRegNumber;

    public Organizer(String name, String email, String password,
                     String contactNumber, String companyRegNumber) {
        super(name, email, password, contactNumber);
        this.companyRegNumber = companyRegNumber;
    }
}