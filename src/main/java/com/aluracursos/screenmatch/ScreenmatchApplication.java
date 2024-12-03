package com.aluracursos.screenmatch;
// Define el paquete de la clase principal de la aplicación.

import com.aluracursos.screenmatch.principal.Principal;
// Importa la clase Principal que contiene la lógica de interacción del usuario.

import org.springframework.boot.CommandLineRunner;
// Importa la interfaz CommandLineRunner para ejecutar código al inicio de la aplicación.

import org.springframework.boot.SpringApplication;
// Importa la clase SpringApplication para iniciar la aplicación Spring Boot.

import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa la anotación SpringBootApplication que configura y marca esta clase como la principal.

@SpringBootApplication
// Marca esta clase como la aplicación principal de Spring Boot.

public class ScreenmatchApplication implements CommandLineRunner {
// Declara la clase principal que implementa CommandLineRunner para ejecutar tareas iniciales.

	public static void main(String[] args) {
// Método principal que inicia la ejecución de la aplicación.

		SpringApplication.run(ScreenmatchApplication.class, args);
// Llama al método `run` para iniciar la aplicación Spring Boot.
	}

	@Override
	public void run(String... args) throws Exception {
// Método que se ejecuta automáticamente al iniciar la aplicación.

		Principal principal = new Principal();
// Crea una instancia de la clase Principal.

		principal.muestraElMenu();
// Llama al método que muestra el menú principal de la aplicación.
	}
}
