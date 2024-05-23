package com.trim.scheduler.service;


import com.trim.scheduler.domain.CalendarDTO;
import com.trim.scheduler.mapper.CalendarMapper;
import com.trim.scheduler.repository.CalendarRepository;
import com.trim.scheduler.utils.CodeGeneratorUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalendarService {
    private final CalendarRepository calendarRepository;
    private final CalendarMapper calendarMapper;

    @Transactional
    public CalendarDTO save(CalendarDTO calendarDTO) {
        return calendarMapper.toDto(calendarRepository.save(calendarMapper.toEntity(calendarDTO)));
    }

    @Transactional
    public CalendarDTO findByOwnerId(Long ownerId) {
        var calendarOpt = calendarRepository.findByOwnerId(ownerId);

        var calendarDTO = CalendarDTO.builder().build();
        if (calendarOpt.isEmpty()) {
            calendarDTO = save(CalendarDTO.builder()
                .ownerId(ownerId)
                .name(CodeGeneratorUtils.generateBase64EncodedCode())
                .build());
        } else {
            calendarDTO = calendarMapper.toDto(calendarOpt.get());
        }
        return calendarDTO;
    }

    @Transactional(readOnly = true)
    public Optional<CalendarDTO> findByName(String name) {
        var calendarOpt = calendarRepository.findByName(name);
        return calendarOpt.map(calendarMapper::toDto);
    }
}
