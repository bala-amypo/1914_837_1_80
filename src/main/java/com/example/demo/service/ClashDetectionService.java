package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AcademicEvent;

public interface ClashDetectionService {

    boolean hasClash(List<AcademicEvent> events);
}
