package com.selector.services;

import com.selector.dto.SectorDTO;
import com.selector.dto.UserDTO;
import com.selector.dto.UserRequest;
import com.selector.models.Sector;
import com.selector.models.User;
import com.selector.repositories.SectorRepository;
import com.selector.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSector(userDTO.getSector());
        user.setCategory(userDTO.getCategory());
        user.setProduct(userDTO.getProduct());
        user.setSkill(userDTO.getSkill());
        user.setTerms(userDTO.isTerms());

        return userRepository.save(user);
    }

    public User updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ExpressionException("User not found with id: " + userId));

        // Update user fields based on userDTO
        existingUser.setName(userDTO.getName());
        existingUser.setSector(userDTO.getSector());
        existingUser.setCategory(userDTO.getCategory());
        existingUser.setProduct(userDTO.getProduct());
        existingUser.setSkill(userDTO.getSkill());
        existingUser.setTerms(userDTO.isTerms());

        return userRepository.save(existingUser);
    }
}
