package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.exception.not_found_exception.EmpleadoNotFoundException;
import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SuspendEmpleadoUseCase {

	private final EmpleadoRepository repository;

	public void execute(Long id, boolean suspender) {
		
		EmpleadoEntity entity = repository.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));

		entity.setActivo(!suspender); 
	}
}
