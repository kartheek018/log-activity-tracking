package com.LogActivity.api.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ActivityType {
    USER_REGISTERED,
    USER_LOGGED_IN,
    USER_LOGGED_OUT,
    POST_CREATED,
    POST_VIEWED,
    POST_LIKED,
    POST_COMMENTED,
    PROFILE_UPDATED;

    @JsonCreator
    public static ActivityType fromValue(String value) {
        return ActivityType.valueOf(value.toUpperCase());
    }
}