package com.company.dry_cleaners.infrastructure.persistence.schema.empleado.specification;

import org.springframework.data.jpa.domain.Specification;

import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoFilterRequest;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;

public class EmpleadoSpecifications {
	
	public static Specification<EmpleadoEntity> fullNameLike(String value) {
        return (root, query, cb) ->
            cb.like(cb.lower(root.get("fullName")),
                "%" + value.toLowerCase() + "%");
    }

    public static Specification<EmpleadoEntity> codigo(String codigo) {
        return (root, query, cb) ->
            cb.equal(root.get("codigo"), codigo);
    }

    public static Specification<EmpleadoEntity> activo(Boolean activo) {
        return (root, query, cb) ->
            cb.equal(root.get("activo"), activo);
    }
    
    
    public static Specification<EmpleadoEntity> filter(EmpleadoFilterRequest filter) {

    	Specification<EmpleadoEntity> spec =
    	        (root, query, cb) -> cb.conjunction();

        if (filter.hasFullName()) {
            spec = spec.and(fullNameLike(filter.fullName()));
        }

        if (filter.hasCodigo()) {
            spec = spec.and(codigo(filter.codigo()));
        }

        if (filter.hasActivo()) {
            spec = spec.and(activo(filter.activo()));
        }

        return spec;
    }

}