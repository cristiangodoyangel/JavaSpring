package com.aluracursos.screeenmatch;

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
		System.out.println("Hola Mundo desde Spring");
	}
}
