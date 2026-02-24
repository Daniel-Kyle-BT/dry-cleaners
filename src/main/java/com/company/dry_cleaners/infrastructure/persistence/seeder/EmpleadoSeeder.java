package com.company.dry_cleaners.infrastructure.persistence.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.dry_cleaners.domain.model.empleado.EmpleadoRepository;
import com.company.dry_cleaners.domain.model.empleado.dto.EmpleadoCreateRequest;
import com.company.dry_cleaners.domain.model.empleado.usecase.CrearEmpleadoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpleadoSeeder implements CommandLineRunner {

	private final CrearEmpleadoService crear;
	private final EmpleadoRepository repository;

	@Override
	public void run(String... args) {

		if (repository.count() > 0) {
			return;
		}

		crear("Daniel", "Bolaños", "daniel@test.com", "10000001", "999111111");
		crear("Fernanda", "Oviedo", "fernanada@test.com", "10000002", "999222222");
		crear("Diego", "Mendoza", "diego@test.com", "10000003", "999333333");
		crear("Ana", "Torres", "ana@test.com", "10000004", "999444444");
		crear("Luis", "Vega", "luis@test.com", "10000005", "999555555");
		crear("Sofia", "Rojas", "sofia@test.com", "10000006", "999666666");
		crear("Diego", "Castro", "diego@test.com", "10000007", "999777777");
		crear("Elena", "Mendoza", "elena@test.com", "10000008", "999888888");
		crear("Pedro", "Salas", "pedro@test.com", "10000009", "999999999");
		crear("Lucia", "Campos", "lucia@test.com", "10000010", "988111111");
	}

	private void crear(String nombre, String apellido, String email, String documento, String telefono) {
		
		crear.ejecutar(new EmpleadoCreateRequest(nombre, apellido, email, documento, telefono));
	}
}
