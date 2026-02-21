package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.stereotype.Service;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObtenerEmpleadoQueryService {

	private final EmpleadoRepository repository;

	public EmpleadoEntity ejecutar(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
	}
}