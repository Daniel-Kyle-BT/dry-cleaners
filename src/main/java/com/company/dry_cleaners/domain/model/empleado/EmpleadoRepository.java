package com.company.dry_cleaners.domain.model.empleado;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoFilterRequest;
import com.company.dry_cleaners.domain.repository.BaseRepository;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;


public interface EmpleadoRepository extends BaseRepository<EmpleadoEntity, Long>{
	
	Optional<EmpleadoEntity> findByCodigo(String codigo);
	 
    boolean existsByEmail(String email);

    boolean existsByDocumento(String documento);

    boolean existsByCodigo(String codigo);

    Page<EmpleadoEntity> search(EmpleadoFilterRequest filter, Pageable pageable);
}