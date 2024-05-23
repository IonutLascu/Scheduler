package com.trim.scheduler.mapper;

import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.AppointmentDTO;
import com.trim.scheduler.domain.BlockedTimeDTO;
import com.trim.scheduler.model.Appointment;
import com.trim.scheduler.model.BlockedTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface BlockedTimeMapper extends BaseMapper<BlockedTimeDTO, BlockedTime>{

    @Mapping(source = "calendar.name", target = "calendarName")
    BlockedTimeDTO toDto(BlockedTime appointment);

    @Override
    List<BlockedTimeDTO> toDtoList(List<BlockedTime> appointments);
}
