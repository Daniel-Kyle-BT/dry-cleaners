package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoFilterRequest;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoResponse;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;
import com.company.dry_cleaners.shared.pagination.PageQuery;
import com.company.dry_cleaners.shared.pagination.PageResponse;
import com.company.dry_cleaners.web.mapper.model.EmpleadoApiMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ListarEmpleadoQueryService {

	private final EmpleadoRepository repository;
	private final EmpleadoApiMapper mapper;

	public PageResponse<EmpleadoResponse> ejecutar(EmpleadoFilterRequest filter, PageQuery pageQuery) {

		Page<EmpleadoEntity> page = repository.search(filter, pageQuery.toPageable());

		return PageResponse.from(page, mapper::toResponse);
	}
}