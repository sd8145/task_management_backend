package com.example.taskmanager.service;

import com.example.taskmanager.dto.UserRequestDto;
import com.example.taskmanager.dto.UserResponseDto;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.repository.UserRepository;

import org.springframework.stereotype.Service;

/*
 * UserService
 * ------------
 * Contains BUSINESS LOGIC.
 * Responsible for:
 * - Mapping DTO ↔ Entity
 * - Applying rules
 * - Talking to repository
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * CREATE USER
     * - Takes UserRequestDto from controller
     * - Converts DTO → Entity
     * - Saves Entity
     * - Converts Entity → Response DTO
     */
    public UserResponseDto createUser(UserRequestDto dto) {

        // Convert DTO to Entity
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Save entity in DB
        User savedUser = userRepository.save(user);

        // Convert Entity to Response DTO
        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    /*
     * GET USER BY ID
     * - Fetch user
     * - If not found → throw exception
     * - Convert Entity → Response DTO
     */
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id)
                );

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
