package com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity;

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
    name = "empleados",
    indexes = {
        @Index(name = "idx_empleados_email", columnList = "email"),
        @Index(name = "idx_empleados_documento", columnList = "documento"),
        @Index(name = "idx_empleados_codigo", columnList = "codigo"),
        @Index(name = "idx_empleados_full_name", columnList = "full_name")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_empleados_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_empleados_documento", columnNames = "documento"),
        @UniqueConstraint(name = "uk_empleados_codigo", columnNames = "codigo")
    }
)
@SQLDelete(sql = "UPDATE empleados SET deleted_at = ? WHERE id = ? AND version = ?")
@SQLRestriction("deleted_at IS NULL")
public class EmpleadoEntity extends AuditableEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "full_name", nullable = false, length = 200)
    private String fullName;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "documento", nullable = false, length = 20)
    private String documento;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;
    
    @PrePersist
    @PreUpdate
    private void buildFullName() {
    	nombre = nombre.trim();
    	apellido = apellido.trim();
    	email = email.toLowerCase().trim();
        documento = documento.trim();
        codigo = codigo.trim();
        this.fullName = (nombre + " " + apellido).trim();
    }
}