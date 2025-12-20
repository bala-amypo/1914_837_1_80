package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserAccountController {

    @Autowired
    private UserAccountRepository userRepo;
    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userRepo.save(user);
    }
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
