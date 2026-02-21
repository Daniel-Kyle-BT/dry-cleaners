package com.company.dry_cleaners.web.mapper.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.company.dry_cleaners.config.mapper.GlobalMapperConfig;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteCreateRequest;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteResponse;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteUpdateRequest;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;

@Mapper(config = GlobalMapperConfig.class)
public interface ClienteApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "activo", ignore = true)
    ClienteEntity toEntity(ClienteCreateRequest request);

    ClienteResponse toResponse(ClienteEntity entity);

    void updateClienteFromRequest(
        ClienteUpdateRequest request,
        @MappingTarget ClienteEntity cliente
    );
}