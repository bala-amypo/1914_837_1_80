package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new ValidationException("Username must not be empty");
        }
        return repository.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }
    @Override
    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount existing = getUserById(id);
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        return repository.save(existing);
    }
    @Override
    public void deleteUser(Long id) {
        repository.delete(getUserById(id));
    }
}
