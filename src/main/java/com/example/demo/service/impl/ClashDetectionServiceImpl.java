package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.ClashDetectionService;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    @Override
    public boolean hasClash() {
        return false;
    }
}
