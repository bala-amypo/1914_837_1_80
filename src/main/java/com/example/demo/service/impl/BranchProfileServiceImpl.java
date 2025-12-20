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
    private final BranchProfileRepository branchProfileRepository;
    public BranchProfileServiceImpl(BranchProfileRepository branchProfileRepository) {
        this.branchProfileRepository = branchProfileRepository;
    }
    @Override
    public BranchProfile createBranchProfile(BranchProfile branchProfile) {

        if (branchProfile.getBranchName() == null || branchProfile.getBranchName().isBlank()) {
            throw new ValidationException("Branch name must not be empty");
        }

        return branchProfileRepository.save(branchProfile);
    }
    @Override
    public List<BranchProfile> getAllBranchProfiles() {
        return branchProfileRepository.findAll();
    }
    @Override
    public BranchProfile getBranchProfileById(Long id) {
        return branchProfileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("BranchProfile not found with id " + id));
    }

    @Override
    public BranchProfile updateBranchProfile(Long id, BranchProfile branchProfile) {
        BranchProfile existingBranch = getBranchProfileById(id);
        if (branchProfile.getBranchName() == null || branchProfile.getBranchName().isBlank()) {
            throw new ValidationException("Branch name must not be empty");
        }
        existingBranch.setBranchName(branchProfile.getBranchName());
        existingBranch.setDepartment(branchProfile.getDepartment());
        existingBranch.setSemester(branchProfile.getSemester());

        return branchProfileRepository.save(existingBranch);
    }
    @Override
    public void deleteBranchProfile(Long id) {
        BranchProfile branchProfile = getBranchProfileById(id);
        branchProfileRepository.delete(branchProfile);
    }
}
