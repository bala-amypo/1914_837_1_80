package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        if (event.getEventName() == null || event.getEventName().isBlank()) {
            throw new ValidationException("Event name must not be empty");
        }
        return repository.save(event);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AcademicEvent not found with id " + id));
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existing = getEventById(id);
        existing.setEventName(event.getEventName());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        return repository.save(existing);
    }

    @Override
    public void deleteEvent(Long id) {
        repository.delete(getEventById(id));
    }
}
