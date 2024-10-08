package com.example.jwtback.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String password;
    private String role;
    private String media;

    public UserEntity(String username, String password, String name, String role, String media) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.media = media;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
