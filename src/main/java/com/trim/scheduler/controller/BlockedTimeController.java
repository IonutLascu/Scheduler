package com.trim.scheduler.controller;

import com.trim.scheduler.domain.BlockedTimeDTO;
import com.trim.scheduler.service.BlockedTimeService;
import com.trim.scheduler.utils.Authorities;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blocked-times")
public class BlockedTimeController {

    private final BlockedTimeService blockedTimeService;

    @PostMapping
    @PreAuthorize("hasRole(\"" + Authorities.USER + "\")")
    public ResponseEntity<BlockedTimeDTO> createBlockedTime(@RequestBody BlockedTimeDTO blockedTimeDTO) {
        BlockedTimeDTO savedBlockedTimeDTO = blockedTimeService.createBlockedTime(blockedTimeDTO);
        return ResponseEntity.ok(savedBlockedTimeDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole(\"" + Authorities.USER + "\")")
    public List<BlockedTimeDTO> getAllBlockedTimes() {
        return blockedTimeService.getAllBlockedTimes();
    }
}