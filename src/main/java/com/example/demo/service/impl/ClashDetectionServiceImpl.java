package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.ClashDetectionService;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    @Override
    public boolean hasClash(List<AcademicEvent> events) {
        return false; // placeholder clash logic
    }
}
