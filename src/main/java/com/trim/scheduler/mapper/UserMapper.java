package com.trim.scheduler.mapper;


import com.trim.scheduler.config.MapperConfiguration;
import com.trim.scheduler.domain.UserDTO;
import com.trim.scheduler.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper extends BaseMapper<UserDTO, User>{
}