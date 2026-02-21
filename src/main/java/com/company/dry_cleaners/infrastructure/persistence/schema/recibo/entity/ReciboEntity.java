package com.company.dry_cleaners.infrastructure.persistence.schema.recibo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.company.dry_cleaners.audit.AuditableEntity;
import com.company.dry_cleaners.infrastructure.persistence.schema.empleado.entity.EmpleadoEntity;
import com.company.dry_cleaners.infrastructure.persistence.schema.recibo.EstadoRecibo;
import com.company.dry_cleaners.infrastructure.persistence.schema.recibo.TipoRecibo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recibos", 
	indexes = { 
		@Index(name = "idx_recibos_tipo", columnList = "tipo"),
		@Index(name = "idx_recibos_empleado", columnList = "empleado_id"),
		@Index(name = "idx_recibos_fecha", columnList = "fecha_emision") 
	},
	uniqueConstraints = {
		@UniqueConstraint(name = "uk_recibo_sunat", columnNames = { "tipo", "serie", "numero" })
	}
)
@SQLDelete(sql = "UPDATE recibos SET deleted_at = ? WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class ReciboEntity extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "recibo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReciboDetalleEntity> detalles = new ArrayList<>();
	
	@Column(name = "sunat_ticket", length = 50)
	private String sunatTicket;

	@Column(name = "sunat_codigo", length = 10)
	private String sunatCodigo;

	@Column(name = "sunat_mensaje", length = 500)
	private String sunatMensaje;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 20)
	private TipoRecibo tipo;

	@Column(name = "serie", nullable = false, length = 10)
	private String serie;

	@Column(name = "numero", nullable = false)
	private Long numero;

	@Column(name = "fecha_emision", nullable = false)
	private LocalDateTime fechaEmision;

	@Column(name = "total", nullable = false, precision = 12, scale = 2)
	private BigDecimal total = BigDecimal.ZERO;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empleado_id", nullable = false, foreignKey = @ForeignKey(name = "fk_recibo_empleado"))
	private EmpleadoEntity empleado;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", nullable = false, length = 20)
	private EstadoRecibo estado = EstadoRecibo.BORRADOR;

	public void recalcularTotal() {
		this.total = detalles.stream().map(ReciboDetalleEntity::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@PrePersist
	@PreUpdate
	private void onSave() {
		recalcularTotal();
	}
}