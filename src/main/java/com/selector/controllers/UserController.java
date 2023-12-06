package com.selector.controllers;

import com.selector.dto.UserDTO;
import com.selector.dto.UserResponse;
import com.selector.models.User;
import com.selector.repositories.UserRepository;
import com.selector.services.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/all")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@RequestBody UserDTO userDTO) {
        User savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok("Form submitted successfully! User ID: " + savedUser.getId());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(userId, userDTO);
        return ResponseEntity.ok("User updated successfully! User ID: " + updatedUser.getId());
    }
}
