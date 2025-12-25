package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> getAllUsers();

    UserAccount getUserById(Long id);

    UserAccount createUser(UserAccount user);

    void deleteUser(Long id);
}
