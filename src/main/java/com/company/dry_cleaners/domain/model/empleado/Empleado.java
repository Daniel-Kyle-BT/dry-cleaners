package com.company.dry_cleaners.domain.model.empleado;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String documento;
	private String telefono;
	private String codigo;
	private boolean activo;
	
	public void suspender() {
		this.activo = false;
	}

	public void reactivar() {
		this.activo = true;
	}
}