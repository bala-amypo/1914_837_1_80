package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AcademicEvent;

public interface AcademicEventService {
    AcademicEvent createEvent(AcademicEvent event);
    List<AcademicEvent> getAllEvents();
    AcademicEvent getEventById(Long id);
    AcademicEvent updateEvent(Long id, AcademicEvent event);
    void deleteEvent(Long id);
}
