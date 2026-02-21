package com.company.dry_cleaners.web.mapper.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.company.dry_cleaners.config.mapper.GlobalMapperConfig;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoCreateRequest;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoResponse;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoUpdateRequest;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

@Mapper(config = GlobalMapperConfig.class)
public interface EmpleadoApiMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "codigo", ignore = true)
	@Mapping(target = "activo", ignore = true)
	EmpleadoEntity toEntity(EmpleadoCreateRequest request);
	
	EmpleadoResponse toResponse(EmpleadoEntity entity);

	void updateEmpleadoFromRequest(EmpleadoUpdateRequest request, @MappingTarget EmpleadoEntity empleado);
}