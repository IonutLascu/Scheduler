package com.trim.scheduler.domain;

import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Instant startDate;
    private Instant endDate;
    private String name;
    private String description;
    private String calendarName;
}