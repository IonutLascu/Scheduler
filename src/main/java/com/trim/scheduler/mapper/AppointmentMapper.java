package com.trim.scheduler.mapper;


import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.AppointmentDTO;
import com.trim.scheduler.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface AppointmentMapper extends BaseMapper<AppointmentDTO, Appointment> {

    @Override
    @Mapping(source = "calendar.name", target = "calendarName")
    AppointmentDTO toDto(Appointment appointment);

    @Override
    List<AppointmentDTO> toDtoList(List<Appointment> appointments);
}