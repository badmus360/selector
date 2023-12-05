package com.selector.controllers;

import com.selector.dto.UserDTO;
import com.selector.dto.UserRequest;
import com.selector.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/input")
    public ResponseEntity<UserDTO> inputData(@RequestBody UserRequest userRequest) {
        return userService.inputData(userRequest);
    }

    @GetMapping("/data/{userId}")
    public ResponseEntity<UserDTO> getData(@PathVariable Long userId) {
        return userService.getData(userId);
    }
}
