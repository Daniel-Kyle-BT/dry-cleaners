package com.company.dry_cleaners.domain.model.cliente.usecase;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteFilterRequest;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteResponse;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;
import com.company.dry_cleaners.shared.pagination.PageQuery;
import com.company.dry_cleaners.shared.pagination.PageResponse;
import com.company.dry_cleaners.web.mapper.model.ClienteApiMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ListarClienteQueryService {

	private final ClienteRepository repository;
	private final ClienteApiMapper mapper;

	public PageResponse<ClienteResponse> ejecutar(ClienteFilterRequest filter, PageQuery pageQuery) {

		Page<ClienteEntity> page = repository.search(filter, pageQuery.toPageable());

		return PageResponse.from(page, mapper::toResponse);
	}
}
