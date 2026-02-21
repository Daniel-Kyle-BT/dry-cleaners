package com.company.dry_cleaners.infrastructure.persistence.schema.cliente.specification;

import org.springframework.data.jpa.domain.Specification;

import com.company.dry_cleaners.domain.model.cliente.dto.ClienteFilterRequest;
import com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity.ClienteEntity;

public class ClienteSpecifications {

	public static Specification<ClienteEntity> fullNameLike(String value) {
		return (root, query, cb) -> cb.like(cb.lower(root.get("fullName")), "%" + value.toLowerCase().trim() + "%");
	}

	public static Specification<ClienteEntity> codigo(String codigo) {
		return (root, query, cb) -> cb.equal(root.get("codigo"), codigo.trim());
	}

	public static Specification<ClienteEntity> documento(String documento) {
		return (root, query, cb) -> cb.equal(root.get("documento"), documento.trim());
	}

	public static Specification<ClienteEntity> activo(Boolean activo) {
		return (root, query, cb) -> cb.equal(root.get("activo"), activo);
	}

	public static Specification<ClienteEntity> filter(ClienteFilterRequest filter) {

		Specification<ClienteEntity> spec = (root, query, cb) -> cb.conjunction();

		if (filter.hasFullName()) {
			spec = spec.and(fullNameLike(filter.fullName()));
		}

		if (filter.hasActivo()) {
			spec = spec.and(activo(filter.activo()));
		}

		return spec;
	}
}