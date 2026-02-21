package com.company.dry_cleaners.infrastructure.persistence.schema.empleado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

public interface EmpleadoJpaRepository
		extends JpaRepository<EmpleadoEntity, Long>, JpaSpecificationExecutor<EmpleadoEntity> {

	Optional<EmpleadoEntity> findByCodigo(String codigo);

	boolean existsByCodigo(String codigo);

	boolean existsByEmail(String email);

	boolean existsByDocumento(String documento);
}
