package com.example.jwtback.controller;

import com.example.jwtback.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping("")
    public CommonResponse admin() {
        return CommonResponse.success("Admin Success");
    }
}
