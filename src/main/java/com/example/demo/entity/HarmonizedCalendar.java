package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "harmonized_calendars")
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String generatedBy;

    @Column(nullable = false)
    private LocalDateTime generatedAt;

    @Column(nullable = false)
    private LocalDate effectiveFrom;

    @Column(nullable = false)
    private LocalDate effectiveTo;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String eventsJson;

    public HarmonizedCalendar() {
    }

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }

    public LocalDate getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }

    public String getEventsJson() { return eventsJson; }
    public void setEventsJson(String eventsJson) { this.eventsJson = eventsJson; }
}
