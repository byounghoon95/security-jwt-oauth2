package com.example.jwtback.controller.dto;

import com.example.jwtback.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserDTO {

    @Getter
    @AllArgsConstructor
    public static class JoinReq {
        private String username;
        private String password;
        private String name;
    }

    @Getter
    public static class JoinRes {
        private String username;
        private String name;
        private String role;

        public JoinRes(UserEntity user) {
            this.username = user.getUsername();
            this.role = user.getRole();
            this.name = user.getName();
        }

        public JoinRes(String username, String name, String role) {
            this.username = username;
            this.name = name;
            this.role = role;
        }
    }
}
