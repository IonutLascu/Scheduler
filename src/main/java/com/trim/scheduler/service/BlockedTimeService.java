package com.trim.scheduler.service;

import com.trim.scheduler.domain.BlockedTimeDTO;
import com.trim.scheduler.mapper.BlockedTimeMapper;
import com.trim.scheduler.model.BlockedTime;
import com.trim.scheduler.repository.BlockedTimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlockedTimeService {

    private final BlockedTimeRepository blockedTimeRepository;
    private final BlockedTimeMapper blockedTimeMapper;

    public BlockedTimeDTO createBlockedTime(BlockedTimeDTO blockedTimeDTO) {
        var blockedTime = blockedTimeMapper.toEntity(blockedTimeDTO);
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
