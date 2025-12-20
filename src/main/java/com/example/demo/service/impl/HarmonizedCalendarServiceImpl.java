package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendar createCalendar(HarmonizedCalendar calender) {
        return repository.save(calender);
    }

    @Override
    public List<HarmonizedCalendar> getAllCalendars() {
        return repository.findAll();
    }

    @Override
    public HarmonizedCalendar getCalendarById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar not found"));
    }

    @Override
    public HarmonizedCalendar updateCalendar(Long id, HarmonizedCalendar calender) {
        return repository.save(calender);
    }

    @Override
    public void deleteCalendar(Long id) {
        repository.deleteById(id);
    }
}
