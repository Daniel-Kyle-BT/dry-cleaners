package com.company.dry_cleaners.infrastructure.persistence.schema.recibo;

public enum EstadoRecibo {
    BORRADOR,   // creado pero no emitido
    EMITIDO,    // válido fiscalmente
    ENVIADO,    // enviado a SUNAT
    ANULADO     // anulado según reglas SUNAT
}