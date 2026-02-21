package com.company.dry_cleaners.web.controller.query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.dry_cleaners.domain.model.cliente.dto.ClienteFilterRequest;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteResponse;
import com.company.dry_cleaners.domain.model.cliente.usecase.ListarClienteQueryService;
import com.company.dry_cleaners.domain.model.cliente.usecase.ObtenerClienteQueryService;
import com.company.dry_cleaners.shared.pagination.PageQuery;
import com.company.dry_cleaners.shared.pagination.PageResponse;
import com.company.dry_cleaners.web.mapper.model.ClienteApiMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteReporteController {

	private final ObtenerClienteQueryService obtener;
	private final ListarClienteQueryService listar;
	private final ClienteApiMapper mapper;

	@GetMapping("/{id}")
	public ClienteResponse obtener(@PathVariable Long id) {

		return mapper.toResponse(obtener.ejecutar(id));
	}

	@GetMapping
	public PageResponse<ClienteResponse> listar(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String fullName,
			@RequestParam(required = false) Boolean activo) {

		ClienteFilterRequest filter = new ClienteFilterRequest(fullName, activo);

		return listar.ejecutar(filter, new PageQuery(page, size));
	}
}
