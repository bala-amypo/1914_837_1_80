package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
@RestController
@RequestMapping("/api/calendar")
@CrossOrigin
public class HarmonizedCalendarController {
    @Autowired
    private HarmonizedCalendarRepository calendarRepo;
    @PostMapping
    public HarmonizedCalendar saveCalendar(@RequestBody HarmonizedCalendar calendar) {
        return calendarRepo.save(calendar);
    }
    @GetMapping
    public List<HarmonizedCalendar> getCalendar() {
        return calendarRepo.findAll();
    }
}
