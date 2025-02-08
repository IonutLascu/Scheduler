package com.trim.scheduler.service;

import com.trim.scheduler.domain.BlockedTimeDTO;
import com.trim.scheduler.mapper.BlockedTimeMapper;
import com.trim.scheduler.model.BlockedTime;
import com.trim.scheduler.mapper.CalendarMapper;
import com.trim.scheduler.repository.BlockedTimeRepository;
import com.trim.scheduler.utils.ApiException;
import com.trim.scheduler.utils.ErrorConstants;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlockedTimeService {

    private final BlockedTimeRepository blockedTimeRepository;
    private final BlockedTimeMapper blockedTimeMapper;
    private final CalendarService calendarService;
    private final CalendarMapper calendarMapper;

    public BlockedTimeDTO createBlockedTime(BlockedTimeDTO blockedTimeDTO) {
        var blockedTime = blockedTimeMapper.toEntity(blockedTimeDTO);
        var calendarOpt = calendarService.findByName(blockedTimeDTO.getCalendarName());

        if (calendarOpt.isEmpty()) {
            throw new ApiException("Invalid calendar name", ErrorConstants.NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
        blockedTime.setCalendar(calendarMapper.toEntity(calendarOpt.get()));
        var savedBlockedTime = blockedTimeRepository.save(blockedTime);
        return blockedTimeMapper.toDto(savedBlockedTime);
    }

    public List<BlockedTimeDTO> getAllBlockedTimes() {
        List<BlockedTime> blockedTimes = blockedTimeRepository.findAll();
        return blockedTimes.stream()
                           .map(blockedTimeMapper::toDto)
                           .collect(Collectors.toList());
    }
}
