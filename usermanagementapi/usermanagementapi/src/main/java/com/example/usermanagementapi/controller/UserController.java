package com.example.usermanagementapi.controller;

import com.example.usermanagementapi.model.User;
import com.example.usermanagementapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userRepository.findByEmail(user.getEmail())
                .map(existing -> ResponseEntity.status(HttpStatus.CONFLICT).<User>build()) // if found
                .orElseGet(() -> {
                    User savedUser = userRepository.save(user);
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser); // if not found
                });
    }

    //  READ all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    //  READ User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)          // 200 OK if found
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }

    // UPDATE User by ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setEmail(updatedUser.getEmail());
                    User savedUser = userRepository.save(existingUser);
                    return ResponseEntity.ok(savedUser); // return 200 OK
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }

    //  DELETE User by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build(); // 204
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }
}
