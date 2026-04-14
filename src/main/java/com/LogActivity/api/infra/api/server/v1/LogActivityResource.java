package com.LogActivity.api.infra.api.server.v1;

import com.LogActivity.api.domain.enums.ActivityType;
import com.LogActivity.api.infra.api.server.dto.ActivityRequestDto;
import com.LogActivity.api.infra.api.server.dto.ActivityResponseDto;
import com.LogActivity.api.infra.api.server.dto.CreateUserRequestDto;
import com.LogActivity.api.infra.api.server.dto.UserResponseDto;
import com.LogActivity.api.service.ActivityService;
import com.LogActivity.api.service.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class LogActivityResource {
    private final CreateUserService createUserService;
    private final ActivityService activityService;

    public LogActivityResource(CreateUserService createUserService, ActivityService activityService) {
        this.createUserService = createUserService;
        this.activityService = activityService;
    }

    @PostMapping("/user")
    public UserResponseDto createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto){
        return createUserService.createUser(createUserRequestDto);
    }

    @PostMapping("/activity")
    public ActivityResponseDto createPostActivity(@Valid @RequestBody ActivityRequestDto activityRequestDto){
        return activityService.saveUserActivity(activityRequestDto);
    }

    @GetMapping("/activity")
    public Page<ActivityResponseDto> getActivities(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) ActivityType activityType,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate
    ) {
        return activityService.getActivities(userId, page, size, activityType, fromDate, toDate);
    }
}
