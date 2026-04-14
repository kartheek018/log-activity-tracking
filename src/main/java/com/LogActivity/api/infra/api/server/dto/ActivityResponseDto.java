package com.LogActivity.api.infra.api.server.dto;

import com.LogActivity.api.domain.enums.ActivityType;
import java.time.LocalDateTime;

public class ActivityResponseDto {
    private Long activityId;
    private ActivityType activityType;
    private Long entityId;
    private LocalDateTime timestamp;
    private String device;
    private String country;

    public ActivityResponseDto(Long activityId, ActivityType activityType, Long entityId, LocalDateTime timestamp, String device, String country) {
        this.activityId = activityId;
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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