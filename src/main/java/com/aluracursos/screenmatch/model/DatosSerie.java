package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons")  Integer  totalDeTemporadas,
        @JsonAlias("imdbRating")        String evaluacion)
        {


    public DatosSerie {
                // Asignar valores predeterminados si son null
                if (totalDeTemporadas == null) {
                    totalDeTemporadas = 0;
                }
                if (evaluacion == null) {
                    evaluacion = "0.0";
                }
            }
            }
    

