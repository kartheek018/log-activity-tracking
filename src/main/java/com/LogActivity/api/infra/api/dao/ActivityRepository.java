package com.LogActivity.api.infra.api.dao;

import com.LogActivity.api.domain.enums.ActivityType;
import com.LogActivity.api.infra.jpa.ActivityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long>, JpaSpecificationExecutor<ActivityEntity> {

    @Query(
            """
            SELECT a FROM ActivityEntity a
            WHERE a.userId = :userId
            AND (:activityType IS NULL OR a.activityType = :activityType)
            AND (:fromDate IS NULL OR a.timestamp >= :fromDate)
            AND (:toDate IS NULL OR a.timestamp <= :toDate)
            """
    )
    Page<ActivityEntity> findActivities(
            @Param("userId") Long userId,
            @Param("activityType")ActivityType activityType,
            @Param("fromDate")LocalDateTime fromDate,
            @Param("toDate")LocalDateTime toDate,
            Pageable pageable
    );
}
