package com.trim.scheduler.mapper;

import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.BlockedTimeDTO;
import com.trim.scheduler.model.BlockedTime;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface BlockedTimeMapper extends BaseMapper<BlockedTimeDTO, BlockedTime>{
}
