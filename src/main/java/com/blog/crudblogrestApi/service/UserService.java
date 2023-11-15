package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    User getUserById(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
