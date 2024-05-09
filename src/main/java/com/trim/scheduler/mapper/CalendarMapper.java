package com.trim.scheduler.mapper;

import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.CalendarDTO;
import com.trim.scheduler.model.Calendar;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface CalendarMapper extends BaseMapper<CalendarDTO, Calendar>{
}