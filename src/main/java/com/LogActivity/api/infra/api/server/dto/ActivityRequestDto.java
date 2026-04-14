package com.LogActivity.api.infra.api.server.dto;

import com.LogActivity.api.domain.enums.ActivityType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class ActivityRequestDto {

    @Schema(description = "User Id", example = "101")
    @NotNull(message = "user ID is required")
    private Long userId;

    @Schema(description = "Action Type on Post", example = "POST_CREATED")
    @NotNull(message = "Action type is required")
    private ActivityType activityType;

    @Schema(description = "Entity ID of the post", example = "555")
    private Long entityId;

    @Schema(description = "User device", example = "Laptop")
    private String device;

    @Schema(description = "Country of the user", example = "India")
    private String country;

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
}