package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.dto.AuthResponseDto;
import com.blog.crudblogrestApi.dto.LoginRequestDto;
import com.blog.crudblogrestApi.dto.RegisterRequestDto;

public interface AuthService {
    AuthResponseDto login(LoginRequestDto loginRequestDto);

    AuthResponseDto register(RegisterRequestDto registerRequestDto);
}
