package com.company.dry_cleaners.infrastructure.persistence.schema.producto.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.company.dry_cleaners.audit.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "productos",
    indexes = {
        @Index(name = "idx_productos_categoria", columnList = "categoria_id"),
        @Index(name = "idx_productos_marca", columnList = "marca_id")
    }
)
@SQLDelete(sql = "UPDATE productos SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class ProductoEntity extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marca_id",
        foreignKey = @ForeignKey(name = "fk_producto_marca"))
    private MarcaEntity marca;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id",
        foreignKey = @ForeignKey(name = "fk_producto_categoria"))
    private CategoriaEntity categoria;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;
}