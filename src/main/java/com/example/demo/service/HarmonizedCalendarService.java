package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.HarmonizedCalender;

public interface HarmonizedCalendarService {

    HarmonizedCalender createCalendar(HarmonizedCalender calender);
    List<HarmonizedCalender> getAllCalendars();
    HarmonizedCalender getCalendarById(Long id);
    HarmonizedCalender updateCalendar(Long id, HarmonizedCalender calender);
    void deleteCalendar(Long id);
}
