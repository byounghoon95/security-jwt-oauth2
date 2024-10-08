package com.example.jwtback.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MediaType {
    OWN("OWN"), NAVER("NAVER"), GOOGLE("GOOGLE")
    ;

    private final String media;
}
