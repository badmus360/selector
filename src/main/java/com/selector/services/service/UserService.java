package com.selector.services.service;

import com.selector.dto.UserDTO;
import com.selector.dto.UserRequest;
import com.selector.dto.UserResponse;
import com.selector.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();
    User saveUser(UserDTO userDTO);
    User updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
}
