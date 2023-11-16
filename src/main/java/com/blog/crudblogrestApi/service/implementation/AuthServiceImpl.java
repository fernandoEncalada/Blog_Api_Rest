package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.dto.AuthResponseDto;
import com.blog.crudblogrestApi.dto.LoginRequestDto;
import com.blog.crudblogrestApi.dto.RegisterRequestDto;
import com.blog.crudblogrestApi.entity.Role;
import com.blog.crudblogrestApi.entity.User;
import com.blog.crudblogrestApi.repository.UserRepository;
import com.blog.crudblogrestApi.service.AuthService;
import com.blog.crudblogrestApi.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.getToken(user);
        return AuthResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .username(registerRequestDto.getUsername())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .name(registerRequestDto.getName())
                .email(registerRequestDto.getEmail())
                .lastName(registerRequestDto.getLastName())
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);

        return AuthResponseDto.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
