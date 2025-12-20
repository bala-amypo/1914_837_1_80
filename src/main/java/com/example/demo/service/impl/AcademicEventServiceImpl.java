package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendar createCalendar(HarmonizedCalendar calendar) {
        return repository.save(calendar);
    }

    @Override
    public List<HarmonizedCalendar> getAllCalendars() {
        return repository.findAll();
    }

    @Override
    public HarmonizedCalendar getCalendarById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "HarmonizedCalendar not found with id: " + id));
    }

    @Override
    public HarmonizedCalendar updateCalendar(Long id, HarmonizedCalendar calendar) {
        HarmonizedCalendar existing = getCalendarById(id);

        existing.setAcademicYear(calendar.getAcademicYear());
        existing.setSemester(calendar.getSemester());
        existing.setBranch(calendar.getBranch());

        return repository.save(existing);
    }

    @Override
    public void deleteCalendar(Long id) {
        HarmonizedCalendar existing = getCalendarById(id);
        repository.delete(existing);
    }
}
