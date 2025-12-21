package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
@RestController
@RequestMapping("/api/clashes")
@CrossOrigin
public class ClashRecordController {
    @Autowired
    private ClashRecordRepository clashRepo;
    @GetMapping
    public List<ClashRecord> getAllClashes() {
        return clashRepo.findAll();
    }
    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolvedClashes() {
        return clashRepo.findByResolvedFalse();
    }
}
