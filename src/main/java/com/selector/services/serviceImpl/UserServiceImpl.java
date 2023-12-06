package com.selector.services.serviceImpl;

import com.selector.dto.UserDTO;
import com.selector.dto.UserResponse;
import com.selector.models.*;
import com.selector.repositories.*;
import com.selector.services.service.UserService;
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
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SkillRepository skillRepository;

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            System.out.println(user.getCategory());
            Category category = categoryRepository.findById(Long.parseLong(user.getCategory())).orElse(null);
            Product product = productRepository.findById(Long.parseLong(user.getProduct())).orElse(null);
            Skill skill = skillRepository.findById(Long.parseLong(user.getSkill())).orElse(null);
            BeanUtils.copyProperties(user, userResponse);

            assert category != null;
            userResponse.setCategory(category.getName());

            assert product != null;
            userResponse.setProduct(product.getName());

            assert skill != null;
            userResponse.setSkill(skill.getName());

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
