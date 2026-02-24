package com.company.dry_cleaners.web.controller.query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoFilterRequest;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoResponse;
import com.company.dry_cleaners.domain.model.empleado.usecase.ListarEmpleadoQueryService;
import com.company.dry_cleaners.domain.model.empleado.usecase.ObtenerEmpleadoPorCodigoQueryService;
import com.company.dry_cleaners.domain.model.empleado.usecase.ObtenerEmpleadoQueryService;
import com.company.dry_cleaners.shared.pagination.PageQuery;
import com.company.dry_cleaners.shared.pagination.PageResponse;
import com.company.dry_cleaners.web.mapper.model.EmpleadoApiMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoReporteController {

	private final ObtenerEmpleadoQueryService obtener;
	private final ObtenerEmpleadoPorCodigoQueryService obtenerPorCod;
	private final ListarEmpleadoQueryService listar;
	private final EmpleadoApiMapper mapper;

	@GetMapping("/{id}")
	public EmpleadoResponse obtener(@PathVariable Long id) {
		
		return mapper.toResponse(obtener.ejecutar(id));
	}
	
	@GetMapping("/codigo/{codigo}")
	public EmpleadoResponse obtenerPorCodigo(@PathVariable String codigo) {
		return mapper.toResponse(obtenerPorCod.ejecutar(codigo));
	}
	

	@GetMapping
	public PageResponse<EmpleadoResponse> listar(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String fullName,
			@RequestParam(required = false) String codigo, @RequestParam(required = false) Boolean activo) {

		EmpleadoFilterRequest filter = new EmpleadoFilterRequest(fullName, codigo, activo);

		return listar.ejecutar(filter, new PageQuery(page, size));	
	}
}