package com.trim.scheduler.controller;

import com.trim.scheduler.domain.CalendarDTO;
import com.trim.scheduler.service.CalendarService;
import com.trim.scheduler.utils.Authorities;
import com.trim.scheduler.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;
    private final JwtUtils jwtUtils;

    @GetMapping
    @PreAuthorize("hasRole(\"" + Authorities.USER + "\")")
    public CalendarDTO getCalendar() {
        var userId = jwtUtils.getLoggedInUserId();
        return calendarService.findByOwnerId(userId);
    }
}
