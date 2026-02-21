package com.company.dry_cleaners.web.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoCreateRequest;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoResponse;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoUpdateRequest;
import com.company.dry_cleaners.domain.model.empleado.usecase.ActualizarEmpleadoService;
import com.company.dry_cleaners.domain.model.empleado.usecase.CrearEmpleadoService;
import com.company.dry_cleaners.domain.model.empleado.usecase.EliminarEmpleadoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

	private final CrearEmpleadoService serviceCreate;
	private final ActualizarEmpleadoService serviceUpdate;
    private final EliminarEmpleadoService serviceDelete;

	@PostMapping
	public ResponseEntity<EmpleadoResponse> crear(@Valid @RequestBody EmpleadoCreateRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceCreate.ejecutar(request));
	}

	@PatchMapping("/{id}")
	public EmpleadoResponse actualizar(@PathVariable Long id, @RequestBody @Valid EmpleadoUpdateRequest request) {
		return serviceUpdate.ejecutar(id, request);
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        serviceDelete.ejecutar(id);
        return ResponseEntity.noContent().build();
    }
}
