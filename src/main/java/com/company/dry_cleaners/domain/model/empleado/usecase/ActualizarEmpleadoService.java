package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoResponse;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoUpdateRequest;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;
import com.company.dry_cleaners.web.mapper.model.EmpleadoApiMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ActualizarEmpleadoService {

	private final EmpleadoRepository repository;
	private final EmpleadoApiMapper apiMapper;

	public EmpleadoResponse ejecutar(Long id, EmpleadoUpdateRequest request) {

		EmpleadoEntity entity = repository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Empleado no encontrado"));
		
		apiMapper.updateEmpleadoFromRequest(request, entity);
		
		return apiMapper.toResponse(entity);
	}

}
