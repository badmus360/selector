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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private final SectorRepository sectorRepository;

    @Override
    public ResponseEntity<UserDTO> inputData(UserRequest userRequest) {

        Set<Sector> sectors = new HashSet<>();
        userRequest.getSectionIds().forEach(id -> {
            sectorRepository.findById(id).ifPresent(sectors::add);
        });
        User user = User.builder()
                .name(userRequest.getName())
                .sectors(sectors)
                .terms(userRequest.getAgreeTerms())
                .build();

        User savedUser = userRepository.save(user);

        UserDTO savedUserDTO = mapUserToUserDTO(savedUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    @Override
    public ResponseEntity<UserDTO> getData(Long userId) {

        Optional<User> fetchedUser = userRepository.findById(userId);

        if (fetchedUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        UserDTO userDTO = mapUserToUserDTO(fetchedUser.get());

        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    private UserDTO mapUserToUserDTO(User user) {

        Set<SectorDTO> sectorDTOs = user.getSectors().stream()
                .map(this::mapSectorToSectorDTO)
                .collect(Collectors.toSet());

        return UserDTO.builder()
                .name(user.getName())
                .sectors(sectorDTOs)
                .terms(user.getTerms())
                .build();
    }

    private SectorDTO mapSectorToSectorDTO(Sector sector) {
        return SectorDTO.builder()
                .id(sector.getId())
                .name(sector.getName())
                .build();
    }

}
