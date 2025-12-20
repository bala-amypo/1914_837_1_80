package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HarmonizedCalender;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalenderRepository;
import com.example.demo.service.HarmonizedCalenderService;

@Service
public class HarmonizedCalenderServiceImpl implements HarmonizedCalenderService {

    private final HarmonizedCalenderRepository repository;

    public HarmonizedCalenderServiceImpl(HarmonizedCalenderRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalender createCalendar(HarmonizedCalender calendar) {
        return repository.save(calendar);
    }

    @Override
    public List<HarmonizedCalender> getAllCalendars() {
        return repository.findAll();
    }

    @Override
    public HarmonizedCalender getCalendarById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calendar not found with id " + id));
    }

    @Override
    public void deleteCalendar(Long id) {
        repository.delete(getCalendarById(id));
    }
}
