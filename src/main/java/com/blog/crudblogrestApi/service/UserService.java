package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.entity.User;
import com.blog.crudblogrestApi.entity.UserRol;

import java.util.List;
import java.util.Set;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    User getUserById(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
