package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BranchProfile;

public interface BranchProfileService {

    BranchProfile createBranchProfile(BranchProfile branchProfile);
    List<BranchProfile> getAllBranchProfiles();
    BranchProfile getBranchProfileById(Long id);
    BranchProfile updateBranchProfile(Long id, BranchProfile branchProfile);
    void deleteBranchProfile(Long id);
}
