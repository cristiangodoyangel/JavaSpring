package com.aluracursos.screeenmatch;

import com.aluracursos.screeenmatch.Service.ConsumoAPI;
import com.aluracursos.screeenmatch.Service.ConvierteDatos;
import com.aluracursos.screeenmatch.model.DatosEpisodio;
import com.aluracursos.screeenmatch.model.DatosSerie;
import com.aluracursos.screeenmatch.model.DatosTemporadas;
import com.aluracursos.screeenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreeenmatchApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(ScreeenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();



	}
}
