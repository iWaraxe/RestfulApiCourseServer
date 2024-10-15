// File: UserController.java
package com.coherentsolutions.restful.controller;


import com.coherentsolutions.restful.model.User;
import com.coherentsolutions.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) Integer olderThan,
            @RequestParam(required = false) Integer youngerThan,
            @RequestParam(required = false) String sex) {

        List<User> users = userService.getUsers(olderThan, youngerThan, sex);
        return ResponseEntity.ok(users);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
