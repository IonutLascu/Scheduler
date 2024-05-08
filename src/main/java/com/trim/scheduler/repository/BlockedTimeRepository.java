package com.trim.scheduler.repository;

import com.trim.scheduler.model.BlockedTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedTimeRepository extends JpaRepository<BlockedTime, Long> {
}