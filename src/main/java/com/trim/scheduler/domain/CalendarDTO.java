package com.trim.scheduler.domain;

import com.trim.scheduler.model.Appointment;
import com.trim.scheduler.model.BlockedTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalendarDTO {
    private Long id;
    private Long ownerId;
    private String name;
    private List<Appointment> appointments;
    private List<BlockedTime> blockedTimes;
}
