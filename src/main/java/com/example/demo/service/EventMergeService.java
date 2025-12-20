package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AcademicEvent;

public interface EventMergeService {

    List<AcademicEvent> mergeEvents(List<AcademicEvent> events);
}
