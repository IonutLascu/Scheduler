package com.trim.scheduler.mapper;


import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.AppointmentDTO;
import com.trim.scheduler.model.Appointment;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface AppointmentMapper extends BaseMapper<AppointmentDTO, Appointment>{
}