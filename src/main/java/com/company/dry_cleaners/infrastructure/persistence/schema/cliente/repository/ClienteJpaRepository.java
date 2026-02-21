package com.company.dry_cleaners.infrastructure.persistence.schema.cliente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;

public interface ClienteJpaRepository
		extends JpaRepository<ClienteEntity, Long>, JpaSpecificationExecutor<ClienteEntity> {

	Optional<ClienteEntity> findByCodigo(String codigo);

	Optional<ClienteEntity> findByDocumento(String documento);

	boolean existsByCodigo(String codigo);

	boolean existsByDocumento(String documento);

	long countByActivoTrue();

	long countByActivoFalse();
}
