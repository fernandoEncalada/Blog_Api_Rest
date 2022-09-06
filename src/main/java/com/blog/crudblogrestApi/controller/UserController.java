package com.blog.crudblogrestApi.controller;

import com.blog.crudblogrestApi.dto.PublicationDTO;
import com.blog.crudblogrestApi.entity.User;
import com.blog.crudblogrestApi.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<PublicationDTO> getPublicationById(@PathVariable(name = "id") long id){
//        return ResponseEntity.ok(publicationService.getPublicationById(id));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
