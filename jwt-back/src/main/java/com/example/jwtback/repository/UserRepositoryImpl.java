package com.example.jwtback.repository;

import com.example.jwtback.entity.UserEntity;
import com.example.jwtback.infrastructure.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;


    @Override
    public Boolean existsByUsername(String username) {
        return userJpaRepository.existsByUsername(username);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userJpaRepository.save(entity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }
}
