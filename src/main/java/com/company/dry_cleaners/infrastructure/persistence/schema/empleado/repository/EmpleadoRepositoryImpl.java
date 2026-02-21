package com.company.dry_cleaners.infrastructure.persistence.schema.empleado.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoFilterRequest;
import com.company.dry_cleaners.infrastructure.persistence.base.BaseRepositoryImpl;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.specification.EmpleadoSpecifications;

@Repository
class EmpleadoRepositoryImpl extends BaseRepositoryImpl<EmpleadoEntity, Long, EmpleadoJpaRepository>
		implements EmpleadoRepository {

	EmpleadoRepositoryImpl(EmpleadoJpaRepository jpa) {
		super(jpa);
	}

	@Override
	public Optional<EmpleadoEntity> findByCodigo(String codigo) {
		return jpa.findByCodigo(codigo);
	}

	@Override
	public boolean existsByEmail(String email) {
		return jpa.existsByEmail(email);
	}

	@Override
	public boolean existsByDocumento(String documento) {
		return jpa.existsByDocumento(documento);
	}

	@Override
	public boolean existsByCodigo(String codigo) {
		return jpa.existsByCodigo(codigo);
	}

	@Override
	public Page<EmpleadoEntity> search(EmpleadoFilterRequest filter, Pageable pageable) {
		return jpa.findAll(EmpleadoSpecifications.filter(filter), pageable);
	}
}