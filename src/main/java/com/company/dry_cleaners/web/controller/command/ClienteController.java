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

import com.company.dry_cleaners.domain.model.cliente.dto.ClienteCreateRequest;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteResponse;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteUpdateRequest;
import com.company.dry_cleaners.domain.model.cliente.usecase.ActualizarClienteService;
import com.company.dry_cleaners.domain.model.cliente.usecase.CrearClienteService;
import com.company.dry_cleaners.domain.model.cliente.usecase.EliminarClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CrearClienteService serviceCreate;
    private final ActualizarClienteService serviceUpdate;
    private final EliminarClienteService serviceDelete;

    @PostMapping
    public ResponseEntity<ClienteResponse> crear(
            @Valid @RequestBody ClienteCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(serviceCreate.ejecutar(request));
    }

    @PatchMapping("/{id}")
    public ClienteResponse actualizar(
            @PathVariable Long id,
            @RequestBody @Valid ClienteUpdateRequest request
    ) {
        return serviceUpdate.ejecutar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        serviceDelete.ejecutar(id);
        return ResponseEntity.noContent().build();
    }
}