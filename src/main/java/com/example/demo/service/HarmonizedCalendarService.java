package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarService {

    HarmonizedCalender createCalendar(HarmonizedCalender calendar);

    List<HarmonizedCalender> getAllCalendars();

    HarmonizedCalender getCalendarById(Long id);

    void deleteCalendar(Long id);
}
