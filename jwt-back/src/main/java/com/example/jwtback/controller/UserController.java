package com.example.jwtback.controller;

import com.example.jwtback.controller.dto.UserDTO;
import com.example.jwtback.response.CommonResponse;
import com.example.jwtback.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final JoinService joinService;

    @PostMapping("/join")
    public CommonResponse joinProcess(@RequestBody UserDTO.JoinReq request) {
        return CommonResponse.success(new UserDTO.JoinRes(joinService.join(request)));
    }
}
