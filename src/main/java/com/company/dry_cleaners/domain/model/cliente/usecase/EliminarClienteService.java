package com.company.dry_cleaners.domain.model.cliente.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EliminarClienteService {

    private final ClienteRepository repository;

    public void ejecutar(Long id) {

        ClienteEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        repository.delete(entity);
    }
}