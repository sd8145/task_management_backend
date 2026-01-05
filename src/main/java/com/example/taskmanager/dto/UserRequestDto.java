package com.example.taskmanager.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/*
 * Validations ensure only correct data
 * enters the backend system.
 */

public class UserRequestDto {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
