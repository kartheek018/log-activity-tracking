package com.LogActivity.api.infra.jpa;

import com.LogActivity.api.domain.enums.ActivityType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ActivitySpecification {

    public static Specification<ActivityEntity> filterActivities(
            Long userId,
            ActivityType activityType,
            LocalDateTime fromDate,
            LocalDateTime toDate
    ){
        return (root, query, cb) -> {
            var predicate = cb.conjunction();
            predicate = cb.and(predicate, cb.equal(root.get("userId"), userId));

            if(activityType!=null){
                predicate=cb.and(predicate, cb.equal(root.get("activityType"), activityType));
            }

            if(fromDate!=null){
                predicate = cb.and(predicate, cb.equal(root.get("fromDate"), fromDate));
            }

            if(toDate!=null){
                predicate = cb.and(predicate, cb.equal(root.get("toDate"), toDate));
            }

            return predicate;
        };
    }
}
