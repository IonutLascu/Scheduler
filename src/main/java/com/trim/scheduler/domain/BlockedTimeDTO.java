package com.trim.scheduler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlockedTimeDTO {
    private Instant startDate;
    private Instant endDate;
    private String description;
    private String calendarName;
}
