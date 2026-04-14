package com.LogActivity.api.domain;

import com.LogActivity.api.domain.enums.ActivityType;

import java.time.LocalDateTime;

public class Activity {

    private Long id;
    private Long userId;
    private ActivityType activityType;
    private Long entityId;
    private LocalDateTime timestamp;
    private String device;
    private String country;

    public Activity(Long id, Long userId, ActivityType activityType, Long entityId, LocalDateTime timestamp, String device, String country) {
        this.id = id;
        this.userId = userId;
        this.activityType = activityType;
        this.entityId = entityId;
        this.timestamp = timestamp;
        this.device = device;
        this.country = country;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}