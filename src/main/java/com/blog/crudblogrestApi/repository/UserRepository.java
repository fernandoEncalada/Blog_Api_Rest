package com.blog.crudblogrestApi.repository;

import com.blog.crudblogrestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
