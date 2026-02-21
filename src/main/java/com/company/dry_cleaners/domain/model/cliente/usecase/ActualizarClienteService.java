package com.company.dry_cleaners.domain.model.cliente.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteResponse;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteUpdateRequest;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;
import com.company.dry_cleaners.web.mapper.model.ClienteApiMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ActualizarClienteService {

	private final ClienteRepository repository;
	private final ClienteApiMapper apiMapper;

	public ClienteResponse ejecutar(Long id, ClienteUpdateRequest request) {

		ClienteEntity entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

		apiMapper.updateClienteFromRequest(request, entity);

		return apiMapper.toResponse(entity);
	}
}
