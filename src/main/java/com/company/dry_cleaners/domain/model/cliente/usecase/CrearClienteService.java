package com.company.dry_cleaners.domain.model.cliente.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteCreateRequest;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteResponse;
import com.company.dry_cleaners.domain.repository.adapter.CodigoGenerator;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;
import com.company.dry_cleaners.web.mapper.model.ClienteApiMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CrearClienteService {

	private final ClienteRepository repository;
	private final CodigoGenerator codigoGenerator;
	private final ClienteApiMapper apiMapper;

	@Transactional
	public ClienteResponse ejecutar(ClienteCreateRequest request) {

		ClienteEntity entity = apiMapper.toEntity(request);

		entity.setCodigo(codigoGenerator.generar("CLI"));
		entity.setActivo(true);

		repository.save(entity);

		return apiMapper.toResponse(entity);
	}
}