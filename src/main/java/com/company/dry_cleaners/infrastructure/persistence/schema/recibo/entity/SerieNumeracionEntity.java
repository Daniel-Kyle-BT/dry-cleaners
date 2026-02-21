package com.company.dry_cleaners.infrastructure.persistence.schema.recibo.entity;

import com.company.dry_cleaners.infrastructure.persistence.schema.recibo.TipoRecibo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;

@Entity
@Table(
    name = "serie_numeracion",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_serie_tipo",
            columnNames = {"tipo", "serie"}
        )
    }
)
public class SerieNumeracionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRecibo tipo;

    @Column(nullable = false, length = 10)
    private String serie;

    @Column(name = "ultimo_numero", nullable = false)
    private Long ultimoNumero;

    @Version
    @Column(name = "version", nullable = false)
    private Long version; 
}
