package com.company.dry_cleaners.infrastructure.persistence.schema.recibo.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.company.dry_cleaners.audit.AuditableEntity;
import com.company.dry_cleaners.infrastructure.persistence.schema.producto.entity.ProductoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "recibo_detalles",
    indexes = {
        @Index(name = "idx_detalle_recibo", columnList = "recibo_id"),
        @Index(name = "idx_detalle_producto", columnList = "producto_id")
    }
)
@SQLDelete(sql = "UPDATE recibo_detalles SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class ReciboDetalleEntity extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recibo_id",
        foreignKey = @ForeignKey(name = "fk_detalle_recibo"))
    private ReciboEntity recibo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id",
        foreignKey = @ForeignKey(name = "fk_detalle_producto"))
    private ProductoEntity producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @PrePersist
    private void initPrecio() {
        if (this.precioUnitario == null) {
            this.precioUnitario = producto.getPrecio();
        }
        this.subtotal = precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }
}