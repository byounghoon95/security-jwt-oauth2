package com.example.jwtback.infrastructure;

import com.example.jwtback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {
    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}
