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
    private Long calendarId;
    private Instant from;
    private Instant to;
    private String description;
}
