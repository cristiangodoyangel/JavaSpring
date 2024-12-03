package com.aluracursos.screenmatch.model;
// Define el paquete al que pertenece esta clase, utilizado para organizar el código.

import com.fasterxml.jackson.annotation.JsonAlias;
// Importa la anotación JsonAlias, que permite asociar un alias a una propiedad JSON.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Importa la anotación JsonIgnoreProperties para ignorar propiedades desconocidas durante el deserializado.

@JsonIgnoreProperties(ignoreUnknown = true)
// Indica que las propiedades desconocidas en el JSON no causarán errores durante la deserialización.

public record DatosEpisodio(
// Declara un record, una clase especial en Java que simplifica la creación de objetos inmutables.

        @JsonAlias("Title") String titulo,
// Asocia la propiedad JSON "Title" con el campo `titulo`.

        @JsonAlias("Episode") Integer numeroEpisodio,
// Asocia la propiedad JSON "Episode" con el campo `numeroEpisodio`.

        @JsonAlias("imdbRating") String evaluacion,
// Asocia la propiedad JSON "imdbRating" con el campo `evaluacion`.

        @JsonAlias("Released") String fechaDeLanzamiento
// Asocia la propiedad JSON "Released" con el campo `fechaDeLanzamiento`.

) {
    // Define el cuerpo del record. En este caso, vacío, ya que solo almacena los datos.
}
