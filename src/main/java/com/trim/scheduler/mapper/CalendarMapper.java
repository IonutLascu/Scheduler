package com.trim.scheduler.mapper;

import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.CalendarDTO;
import com.trim.scheduler.model.Calendar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class, uses = {AppointmentMapper.class, BlockedTimeMapper.class})
public interface CalendarMapper extends BaseMapper<CalendarDTO, Calendar> {

    @Override
    @Mapping(target = "appointments", source = "appointments")
    @Mapping(target = "blockedTimes", source = "blockedTimes")
    CalendarDTO toDto(Calendar calendar);

    @Override
    List<CalendarDTO> toDtoList(List<Calendar> calendars);
}