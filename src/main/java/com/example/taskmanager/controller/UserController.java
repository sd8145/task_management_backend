package com.example.taskmanager.controller;

import com.example.taskmanager.dto.UserRequestDto;
import com.example.taskmanager.dto.UserResponseDto;
import com.example.taskmanager.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * UserController
 * ----------------
 * Handles HTTP requests and responses.
 * Does NOT contain business logic.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     * POST /users
     * - Accepts UserRequestDto
     * - Returns UserResponseDto
     * - Status: 201 CREATED
     */
    /*To make your code look professional and help you remember this "invisible" magic later, here are the comments you should add to your UserController.

I’ve broken it down into The Logic and The Why.

📍 UserController.java (With Added Comments)
Java

    /*
     * POST /users
     * ----------------
     * 1. @RequestBody: Jackson Library automatically maps incoming JSON 
     * keys (e.g., "name") to DTO fields (setName()).
     * 2. The Service handles the conversion from DTO to Database Entity.
     * 3. Returns 201 CREATED + ResponseDto (The "Public Face").
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @RequestBody UserRequestDto dto) {

        UserResponseDto response = userService.createUser(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*
     * GET /users/{id}
     * - Returns user if exists
     * - Else 404 handled globally
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
