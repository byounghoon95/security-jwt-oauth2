package com.example.jwtback.controller.dto;

import com.example.jwtback.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDTO {

    @Getter
    @AllArgsConstructor
    public static class JoinReq {
        private String username;
        private String password;
    }

    @Getter
    public static class JoinRes {
        private String username;
        private String role;

        public JoinRes(UserEntity user) {
            this.username = user.getUsername();
            this.role = user.getRole();
        }
    }
}
