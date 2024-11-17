package com.aluracursos.screeenmatch;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.aluracursos.screeenmatch.Service.ConsumoAPI;
import com.aluracursos.screeenmatch.Service.ConvierteDatos;
import com.aluracursos.screeenmatch.model.DatosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreeenmatchApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(ScreeenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=the+big+bang+theory&apikey=1a68466f");
		System.out.println(json);
		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);

	}
}
