
package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
@RestController
@RequestMapping("/api/branches")
@CrossOrigin
public class BranchProfileController {
    @Autowired
    private BranchProfileRepository branchRepo;
    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return branchRepo.save(branch);
    }

    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return branchRepo.findAll();
    }
    @GetMapping("/{id}")
    public BranchProfile getBranchById(@PathVariable Long id) {
        return branchRepo.findById(id).orElse(null);
    }
}

