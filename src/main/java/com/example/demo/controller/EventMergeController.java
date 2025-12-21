package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;

@RestController
@RequestMapping("/api/merges")
@CrossOrigin
public class EventMergeController {

    @Autowired
    private EventMergeRecordRepository mergeRepo;

    @PostMapping
    public EventMergeRecord saveMerge(@RequestBody EventMergeRecord record) {
        return mergeRepo.save(record);
    }

    @GetMapping
    public List<EventMergeRecord> getAllMerges() {
        return mergeRepo.findAll();
    }
}
