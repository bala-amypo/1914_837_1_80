package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.EventMergeService;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Override
    public List<AcademicEvent> mergeEvents(List<AcademicEvent> events) {
        return events; // placeholder merge logic
    }
}
