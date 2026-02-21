package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.stereotype.Service;

import com.company.dry_cleaners.domain.exception.forbidden_exception.ForbiddenEmpleadoAccessException;
import com.company.dry_cleaners.domain.exception.not_found_exception.EmpleadoNotFoundException;
import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObtenerEmpleadoPorUsuarioQueryService {

	private final EmpleadoRepository repository;

	public EmpleadoEntity execute(Long id, Long authenticatedEmpleadoId) {

		if (!id.equals(authenticatedEmpleadoId)) {
			throw new ForbiddenEmpleadoAccessException();
		}

		return repository.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
	}
}