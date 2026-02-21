package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EliminarEmpleadoService {

    private final EmpleadoRepository repository;

    public void ejecutar(Long id) {

        EmpleadoEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        repository.delete(entity);
    }
}
