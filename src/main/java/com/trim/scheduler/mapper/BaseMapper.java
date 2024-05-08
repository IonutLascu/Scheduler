package com.trim.scheduler.mapper;

import java.util.List;

public interface BaseMapper<DTO, ENTITY> {
    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);

    List<DTO> toDtoList(List<ENTITY> entities);

    List<ENTITY> toEntitiesList(List<DTO> dtos);
}
