package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
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
        if (branchProfile.getBranchName() == null || branchProfile.getBranchName().isBlank()) {
            throw new ValidationException("Branch name must not be empty");
        }
        return repository.save(branchProfile);
    }

    @Override
    public List<BranchProfile> getAllBranchProfiles() {
        return repository.findAll();
    }

    @Override
    public BranchProfile getBranchProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BranchProfile not found with id " + id));
    }

    @Override
    public BranchProfile updateBranchProfile(Long id, BranchProfile branchProfile) {
        BranchProfile existing = getBranchProfileById(id);
        existing.setBranchName(branchProfile.getBranchName());
        existing.setDepartment(branchProfile.getDepartment());
        existing.setSemester(branchProfile.getSemester());
        return repository.save(existing);
    }

    @Override
    public void deleteBranchProfile(Long id) {
        repository.delete(getBranchProfileById(id));
    }
}
