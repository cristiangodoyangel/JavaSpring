package com.aluracursos.screenmatch.model;
// Define el paquete al que pertenece esta clase, utilizado para organizar el código.

import com.fasterxml.jackson.annotation.JsonAlias;
// Importa la anotación JsonAlias, que permite asociar un alias a una propiedad JSON.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Importa la anotación JsonIgnoreProperties para ignorar propiedades desconocidas durante el deserializado.

import java.util.List;
// Importa la clase List para manejar listas de objetos.

@JsonIgnoreProperties(ignoreUnknown = true)
// Indica que las propiedades desconocidas en el JSON no causarán errores durante la deserialización.

public record DatosTemporadas(
// Declara un record para manejar datos inmutables relacionados con temporadas.

        @JsonAlias("Season") Integer numero,
// Asocia la propiedad JSON "Season" con el campo `numero`.

        @JsonAlias("Episodes") List<DatosEpisodio> episodios
// Asocia la propiedad JSON "Episodes" con el campo `episodios`, que es una lista de objetos `DatosEpisodio`.

) {
    // Define el cuerpo del record, que está vacío ya que solo almacena datos.
}
