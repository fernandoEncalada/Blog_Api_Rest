package com.blog.crudblogrestApi.repository;

import com.blog.crudblogrestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);

    Optional<User> findByUsername(String username);
}
