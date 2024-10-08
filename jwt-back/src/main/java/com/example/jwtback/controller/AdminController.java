package com.example.jwtback.controller;

import com.example.jwtback.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    @GetMapping("/admin")
    public CommonResponse admin() {
        return CommonResponse.success("Success");
    }
}
