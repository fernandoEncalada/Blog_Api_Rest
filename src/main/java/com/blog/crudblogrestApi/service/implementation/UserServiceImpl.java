package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.entity.User;
import com.blog.crudblogrestApi.exceptions.ResourceNotFoundException;
import com.blog.crudblogrestApi.repository.UserRepository;
import com.blog.crudblogrestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(User user){

        return userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user, Long id) {
        User createdUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        createdUser.setName(user.getName());
        createdUser.setLastName(user.getLastName());
        createdUser.setEmail(user.getEmail());
        createdUser.setPassword(user.getPassword());
        return userRepository.save(createdUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }
}
