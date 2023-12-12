package com.selector.services.serviceImpl;

import com.selector.dto.UserDTO;
import com.selector.dto.UserResponse;
import com.selector.models.*;
import com.selector.repositories.*;
import com.selector.services.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            System.out.println(user.getCategory());

            BeanUtils.copyProperties(user, userResponse);

            return userResponse;
        }).collect(Collectors.toList());
    }

    @Override
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

    @Override
    public User updateUser(Long userId, UserDTO userDTO) {

        System.out.println("initiates...." + userDTO);
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ExpressionException("User not found with id: " + userId));

        if(userDTO.getName() != null && !userDTO.getName().isEmpty())
            existingUser.setName(userDTO.getName());

        if(userDTO.getSector() != null && !userDTO.getSector().isEmpty())
            existingUser.setSector(userDTO.getSector());

        if(userDTO.getCategory() != null && !userDTO.getCategory().isEmpty())
            existingUser.setCategory(userDTO.getCategory());

        if(userDTO.getProduct() != null && !userDTO.getProduct().isEmpty())
            existingUser.setProduct(userDTO.getProduct());

        if(userDTO.getSkill() != null && !userDTO.getSkill().isEmpty())
            existingUser.setSkill(userDTO.getSkill());

        existingUser.setTerms(userDTO.isTerms());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
