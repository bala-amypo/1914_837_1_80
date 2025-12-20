package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarService {

    HarmonizedCalendar createCalendar(HarmonizedCalendar calendar);

    List<HarmonizedCalendar> getAllCalendars();

    HarmonizedCalendar getCalendarById(Long id);

    HarmonizedCalendar updateCalendar(Long id, HarmonizedCalendar calendar);

    void deleteCalendar(Long id);
}
