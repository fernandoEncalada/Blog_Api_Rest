package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.dto.AuthResponseDto;
import com.blog.crudblogrestApi.dto.LoginRequestDto;
import com.blog.crudblogrestApi.dto.RegisterRequestDto;
import com.blog.crudblogrestApi.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequestDto) {
        return null;
    }
}
