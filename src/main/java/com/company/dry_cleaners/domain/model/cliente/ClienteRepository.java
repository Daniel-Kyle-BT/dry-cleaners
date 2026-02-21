package com.company.dry_cleaners.domain.model.cliente;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.company.dry_cleaners.domain.model.cliente.dto.ClienteFilterRequest;
import com.company.dry_cleaners.domain.repository.BaseRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;

public interface ClienteRepository extends BaseRepository<ClienteEntity, Long> {
	Optional<ClienteEntity> findByDocumento(String documento);

	Optional<ClienteEntity> findByCodigo(String codigo);

	boolean existsByDocumento(String documento);

	boolean existsByCodigo(String codigo);

	Page<ClienteEntity> search(ClienteFilterRequest filter, Pageable pageable);
}
