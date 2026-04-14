package com.LogActivity.api.infra.jpa;

import com.LogActivity.api.domain.Activity;
import com.LogActivity.api.infra.api.server.dto.ActivityRequestDto;
import com.LogActivity.api.infra.api.server.dto.ActivityResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    public Activity toDomain(ActivityRequestDto dto){
        return new Activity(
                null,
                dto.getUserId(),
                dto.getActivityType(),
                dto.getEntityId(),
                null,
                dto.getDevice(),
                dto.getCountry()
        );
    }

    public ActivityEntity toEntity(Activity activity){
        ActivityEntity activityEntity=new ActivityEntity();
        activityEntity.setActivityType(activity.getActivityType());
        activityEntity.setEntityId(activity.getEntityId());
        activityEntity.setTimestamp(activity.getTimestamp());
        activityEntity.setCountry(activity.getCountry());
        activityEntity.setDevice(activity.getDevice());
        activityEntity.setUserId(activity.getUserId());

        return activityEntity;
    }

    public ActivityResponseDto toResponse(ActivityEntity activityEntity){
        return new ActivityResponseDto(
                activityEntity.getId(),
                activityEntity.getActivityType(),
                activityEntity.getEntityId(),
                activityEntity.getTimestamp(),
                activityEntity.getDevice(),
                activityEntity.getCountry()
        );
    }

}
