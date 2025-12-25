package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    // GET ALL USERS
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userAccountService.getUser(id);
    }

    // CREATE USER (POST)
    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userAccountService.register(user);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "User deleted with id: " + id;
    }
}
