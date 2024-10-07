package com.example.jwtback.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ErrorEnum {

    SUCCESS("0000","SUCCESS"),
    UNKNOWN_ERROR("9999","UNKNOWN_ERROR"),
    ;
    private final String code;
    private final String message;
}
