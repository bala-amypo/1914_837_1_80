package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;

    private String mergedTitle;

    private LocalDate mergedStartDate;

    private LocalDate mergedEndDate;

    private String mergeReason;

    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getSourceEventIds() { return sourceEventIds; }
    public void setSourceEventIds(String sourceEventIds) { this.sourceEventIds = sourceEventIds; }
}
