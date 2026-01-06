package com.example.taskmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/*
 * Validations ensure only correct data
 * enters the backend system.
 */
/*
 * UserRequestDto
 * ----------------
 * This DTO represents the data that the CLIENT sends to the server
 * while creating a user.
 *
 * IMPORTANT:
 * - No id here (client should not send id)
 * - Only fields that client is allowed to provide
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
