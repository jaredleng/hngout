
package com.jared.hngout.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Organizer extends User {
    @NotBlank(message="companyRegNumber is mandatory and should not be blank")
    private String companyRegNumber;

    public Organizer(String name, String email, String password,
                     String contactNumber, String companyRegNumber) {
        super(name, email, password, contactNumber);
        this.companyRegNumber = companyRegNumber;
    }
}