package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    // Define la interfaz SerieRepository que extiende de JpaRepository.
    // JpaRepository es una interfaz de Spring Data JPA que proporciona métodos CRUD.
    // Serie es la entidad que se va a gestionar y Long es el tipo de dato de la clave primaria.
    // Al extender JpaRepository, SerieRepository hereda métodos como save, findById, findAll, etc.
    // No es necesario implementar estos métodos, Spring Data JPA los proporciona automáticamente.
    // SerieRepository se utiliza para realizar operaciones de persistencia en la base de datos.
}
