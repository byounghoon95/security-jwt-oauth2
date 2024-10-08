package com.example.jwtback.repository;

import com.example.jwtback.entity.UserEntity;

public interface UserRepository {

    Boolean existsByUsername(String username);

    UserEntity save(UserEntity entity);

    UserEntity findByUsername(String username);
}
