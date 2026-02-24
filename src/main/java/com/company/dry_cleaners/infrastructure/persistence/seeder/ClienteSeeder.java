package com.company.dry_cleaners.infrastructure.persistence.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.dry_cleaners.domain.model.cliente.ClienteRepository;
import com.company.dry_cleaners.domain.model.cliente.dto.ClienteCreateRequest;
import com.company.dry_cleaners.domain.model.cliente.usecase.CrearClienteService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteSeeder implements CommandLineRunner {

	private final CrearClienteService crearClienteService;
	private final ClienteRepository repository;

	@Override
	public void run(String... args) {

		if (repository.count() > 0) {
			return;
		}

		crear("Juan", "Perez", "70000001", "999111111");
		crear("Maria", "Lopez", "70000002", "999222222");
		crear("Carlos", "Ramirez", "70000003", "999333333");
		crear("Ana", "Torres", "70000004", "999444444");
		crear("Luis", "Vega", "70000005", "999555555");
		crear("Sofia", "Rojas", "70000006", "999666666");
		crear("Diego", "Castro", "70000007", "999777777");
		crear("Elena", "Mendoza", "70000008", "999888888");
		crear("Pedro", "Salas", "70000009", "999999999");
		crear("Lucia", "Campos", "70000010", "988111111");
	}

	private void crear(String nombre, String apellido, String documento, String telefono) {

		crearClienteService.ejecutar(new ClienteCreateRequest(nombre, apellido, documento, telefono));
	}
}