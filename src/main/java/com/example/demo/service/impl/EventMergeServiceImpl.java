package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository eventMergeRecordRepository;
    private final AcademicEventRepository academicEventRepository;

    public EventMergeServiceImpl(EventMergeRecordRepository eventMergeRecordRepository,
                                 AcademicEventRepository academicEventRepository) {
        this.eventMergeRecordRepository = eventMergeRecordRepository;
        this.academicEventRepository = academicEventRepository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        List<AcademicEvent> events = academicEventRepository.findAllById(eventIds);

        if (events.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }

        LocalDate start = events.stream()
                .map(AcademicEvent::getStartDate).min(LocalDate::compareTo).get();
        LocalDate end = events.stream()
                .map(AcademicEvent::getEndDate).max(LocalDate::compareTo).get();

        EventMergeRecord mr = new EventMergeRecord();
        mr.setSourceEventIds(
                events.stream()
                        .map(e -> String.valueOf(e.getId()))
                        .collect(Collectors.joining(","))
        );
        mr.setMergedTitle("Merged Events");
        mr.setMergedStartDate(start);
        mr.setMergedEndDate(end);
        mr.setMergeReason(reason);

        return eventMergeRecordRepository.save(mr);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeRecordRepository.findAll();
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return eventMergeRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
    }
}
