package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public List<User> getUsers();

    public User getUserById(Long id);

    public User updateUser(User user, Long id);

    public void deleteUser(Long id);
}
