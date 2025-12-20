package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public BranchProfile createBranchProfile(BranchProfile branchProfile) {
        return repository.save(branchProfile);
    }

    @Override
    public List<BranchProfile> getAllBranchProfiles() {
        return repository.findAll();
    }

    @Override
    public BranchProfile getBranchProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("BranchProfile not found"));
    }

    @Override
    public BranchProfile updateBranchProfile(Long id, BranchProfile branchProfile) {
        return repository.save(branchProfile);
    }

    @Override
    public void deleteBranchProfile(Long id) {
        repository.deleteById(id);
    }
}
