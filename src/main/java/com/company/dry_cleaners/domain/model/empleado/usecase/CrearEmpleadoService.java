package com.company.dry_cleaners.domain.model.empleado.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoCreateRequest;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoResponse;
import com.company.dry_cleaners.domain.repository.adapter.CodigoGenerator;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;
import com.company.dry_cleaners.web.mapper.model.EmpleadoApiMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CrearEmpleadoService {

    private final EmpleadoRepository repository;
    private final CodigoGenerator codigoGenerator;
    private final EmpleadoApiMapper apiMapper;

    @Transactional
    public EmpleadoResponse ejecutar(EmpleadoCreateRequest request) {
    	
    	 EmpleadoEntity entity = apiMapper.toEntity(request);
    	
    	 entity.setCodigo(codigoGenerator.generar("EMP"));
    	 entity.setActivo(true);
    	 
    	 repository.save(entity);

        return apiMapper.toResponse(entity);
    }
}