package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class AcademicEventController {
    @Autowired
    private AcademicEventRepository eventRepo;
    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return eventRepo.save(event);
    }
    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return eventRepo.findAll();
    }
    @GetMapping("/{id}")
    public AcademicEvent getEventById(@PathVariable Long id) {
        return eventRepo.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepo.deleteById(id);
    }
}
