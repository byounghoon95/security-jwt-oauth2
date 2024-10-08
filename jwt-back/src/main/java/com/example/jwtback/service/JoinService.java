package com.example.jwtback.service;

import com.example.jwtback.controller.dto.UserDTO;
import com.example.jwtback.entity.UserEntity;
import com.example.jwtback.exception.CustomException;
import com.example.jwtback.exception.ErrorEnum;
import com.example.jwtback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserEntity join(UserDTO.JoinReq request) {
        String username = request.getUsername();
        String password = request.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            throw new CustomException(ErrorEnum.EXIST_USER);
        }

        UserEntity data = new UserEntity(username,bCryptPasswordEncoder.encode(password), request.getName(), "ROLE_USER");

        return userRepository.save(data);
    }
}
