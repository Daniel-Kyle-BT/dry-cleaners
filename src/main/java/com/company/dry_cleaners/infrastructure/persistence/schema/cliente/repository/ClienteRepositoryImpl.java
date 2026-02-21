package com.company.dry_cleaners.infrastructure.persistence.schema.cliente.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteFilterRequest;
import com.company.dry_cleaners.infrastructure.persistence.base.BaseRepositoryImpl;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.specification.ClienteSpecifications;

@Repository
class ClienteRepositoryImpl extends BaseRepositoryImpl<ClienteEntity, Long, ClienteJpaRepository>
		implements ClienteRepository {

	ClienteRepositoryImpl(ClienteJpaRepository jpa) {
		super(jpa);
	}

	@Override
	public Optional<ClienteEntity> findByDocumento(String documento) {
		return jpa.findByDocumento(documento);
	}

	@Override
	public Optional<ClienteEntity> findByCodigo(String codigo) {
		return jpa.findByCodigo(codigo);
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
	public Page<ClienteEntity> search(ClienteFilterRequest filter, Pageable pageable) {
		return jpa.findAll(ClienteSpecifications.filter(filter), pageable);
	}

}
