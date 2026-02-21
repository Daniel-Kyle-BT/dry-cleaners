package com.company.dry_cleaners.infrastructure.persistence.schema.cliente.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.company.dry_cleaners.audit.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(
    name = "clientes",
    indexes = {
        @Index(name = "idx_clientes_documento", columnList = "documento")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_clientes_documento", columnNames = "documento")
    }
)
@SQLDelete(sql = "UPDATE clientes SET deleted_at = NOW() WHERE id = ? AND version = ?")
@SQLRestriction("deleted_at IS NULL")
public class ClienteEntity extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    
    @Column(name = "full_name", nullable = false, length = 200)
    private String fullName;

    @Column(name = "documento", nullable = false, length = 20)
    private String documento;

    @Column(name = "telefono", length = 20)
    private String telefono;
    
    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;

	@Column(name = "activo", nullable = false)
	private Boolean activo = true;
	
	@Version
    @Column(name = "version", nullable = false)
    private Long version;
	
	@PrePersist
	@PreUpdate
	private void buildFullName() {
		nombre = nombre.trim();
    	apellido = apellido.trim();
    	documento = documento.trim();
        codigo = codigo.trim();
	    this.fullName = (nombre + " " + apellido).trim();
	}

}