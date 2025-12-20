package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent createAcademicEvent(AcademicEvent event) {
        return repository.save(event);
    }

    @Override
    public List<AcademicEvent> getAllAcademicEvents() {
        return repository.findAll();
    }

    @Override
    public AcademicEvent getAcademicEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("AcademicEvent not found"));
    }

    @Override
    public AcademicEvent updateAcademicEvent(Long id, AcademicEvent event) {
        return repository.save(event);
    }

    @Override
    public void deleteAcademicEvent(Long id) {
        repository.deleteById(id);
    }
}
