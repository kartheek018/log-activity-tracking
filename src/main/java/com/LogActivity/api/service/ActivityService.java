package com.LogActivity.api.service;

import com.LogActivity.api.domain.Activity;
import com.LogActivity.api.domain.enums.ActivityType;
import com.LogActivity.api.domain.exception.CreatePostActivityException;
import com.LogActivity.api.domain.exception.UserNotFoundException;
import com.LogActivity.api.infra.api.dao.ActivityRepository;
import com.LogActivity.api.infra.api.dao.UserRepository;
import com.LogActivity.api.infra.api.server.dto.ActivityRequestDto;
import com.LogActivity.api.infra.api.server.dto.ActivityResponseDto;
import com.LogActivity.api.infra.jpa.ActivityEntity;
import com.LogActivity.api.infra.jpa.ActivityMapper;
import com.LogActivity.api.infra.jpa.ActivitySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final UserRepository userRepository;

    public ActivityService(ActivityRepository activityRepository, ActivityMapper activityMapper, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
        this.userRepository = userRepository;
    }

    public ActivityResponseDto saveUserActivity(ActivityRequestDto activityRequestDto){
        if(!userRepository.existsById(activityRequestDto.getUserId())){
            throw new CreatePostActivityException("UserId not found, give correct one", "USER_ID_NOT_FOUND");
        }

        Activity activity=activityMapper.toDomain(activityRequestDto);

        activity= new Activity(
                null,
                activity.getUserId(),
                activity.getActivityType(),
                activity.getEntityId(),
                LocalDateTime.now(),
                activity.getDevice(),
                activity.getCountry()
        );

        ActivityEntity activityEntity=activityMapper.toEntity(activity);

        ActivityEntity activityResponse = activityRepository.save(activityEntity);

        return activityMapper.toResponse(activityResponse);
    }

    public Page<ActivityResponseDto> getActivities(
            Long userId,
            int page,
            int size,
            ActivityType activityType,
            LocalDate fromDate,
            LocalDate toDate
    ){
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundException("User ID Not Found, unable to fetch user activity");
        }

        LocalDateTime fromDateTime = null;
        LocalDateTime toDateTime = null;

        if (fromDate != null) {
            fromDateTime = fromDate.atStartOfDay();
        }

        if (toDate != null) {
            toDateTime = toDate.atTime(23, 59, 59);
        }

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "timestamp")
        );

        Specification<ActivityEntity> spec = ActivitySpecification.filterActivities(
                userId,
                activityType,
                fromDateTime,
                toDateTime
        );

        Page<ActivityEntity> userActivities=activityRepository.findAll(spec,pageable);

        return userActivities.map(activityMapper::toResponse);
    }
}