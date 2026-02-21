package com.company.dry_cleaners.domain.model.cliente.usecase;

import org.springframework.stereotype.Service;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObtenerClienteQueryService {

	private final ClienteRepository repository;

	public ClienteEntity ejecutar(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
	}
}
