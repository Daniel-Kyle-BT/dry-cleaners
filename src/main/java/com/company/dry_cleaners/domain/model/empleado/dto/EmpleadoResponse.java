package com.company.dry_cleaners.domain.model.empleado.dto;

public record EmpleadoResponse(
    Long id,
    String nombre,
    String apellido,
    String email,
    String documento,
    String telefono,
    String codigo,
    boolean activo
) {}
