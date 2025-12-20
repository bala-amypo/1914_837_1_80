package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.HarmonizedCalender;

public interface HarmonizedCalenderService {

    HarmonizedCalender createCalendar(HarmonizedCalender calendar);

    List<HarmonizedCalender> getAllCalendars();

    HarmonizedCalender getCalendarById(Long id);

    void deleteCalendar(Long id);
}
