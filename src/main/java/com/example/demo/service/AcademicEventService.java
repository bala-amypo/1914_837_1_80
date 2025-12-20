package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AcademicEvent;

public interface AcademicEventService {

    AcademicEvent createAcademicEvent(AcademicEvent event);
    List<AcademicEvent> getAllAcademicEvents();
    AcademicEvent getAcademicEventById(Long id);
    AcademicEvent updateAcademicEvent(Long id, AcademicEvent event);
    void deleteAcademicEvent(Long id);
}
