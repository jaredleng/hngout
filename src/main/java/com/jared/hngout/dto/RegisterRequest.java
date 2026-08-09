package com.jared.hngout.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message="Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message="Password is required")
    @Size(min=6,message="Password must be at least 6 characters")
    private String password;
    @NotBlank(message="Contact number is required")
    private String contactNumber;
    @Min(value = 1, message = "Age must be at least 1")
    private int age;
    @NotBlank(message = "Gender is required")
    private String gender;

}
