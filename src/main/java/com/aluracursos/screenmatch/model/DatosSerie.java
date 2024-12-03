package com.aluracursos.screenmatch.model;
// Define el paquete al que pertenece esta clase, utilizado para organizar el código.

import com.fasterxml.jackson.annotation.JsonAlias;
// Importa la anotación JsonAlias, que permite asociar un alias a una propiedad JSON.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Importa la anotación JsonIgnoreProperties para ignorar propiedades desconocidas durante el deserializado.

@JsonIgnoreProperties(ignoreUnknown = true)
// Indica que las propiedades desconocidas en el JSON no causarán errores durante la deserialización.

public record DatosSerie(
// Declara un record, que es una clase especial en Java para manejar datos inmutables.

        @JsonAlias("Title") String titulo,
// Asocia la propiedad JSON "Title" con el campo `titulo`.

        @JsonAlias("totalSeasons") Integer totalTemporadas,
// Asocia la propiedad JSON "totalSeasons" con el campo `totalTemporadas`.

        @JsonAlias("imdbRating") String evaluacion,
// Asocia la propiedad JSON "imdbRating" con el campo `evaluacion`.

        @JsonAlias("Poster") String poster,
// Asocia la propiedad JSON "Poster" con el campo `poster`.

        @JsonAlias("Genre") String genero,
// Asocia la propiedad JSON "Genre" con el campo `genero`.

        @JsonAlias("Actors") String actores,
// Asocia la propiedad JSON "Actors" con el campo `actores`.

        @JsonAlias("Plot") String sinopsis
// Asocia la propiedad JSON "Plot" con el campo `sinopsis`.

) {
    // Define el cuerpo del record, que está vacío ya que solo almacena datos.
}
