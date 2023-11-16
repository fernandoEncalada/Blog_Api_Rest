package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String getToken(UserDetails user);

    boolean isTokenValid(String token, UserDetails userDetails);

    String getUsernameFromToken(String token);
}
