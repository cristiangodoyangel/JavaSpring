package com.aluracursos.screenmatch.model;


import com.aluracursos.screenmatch.service.ConsultaChatGPT;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")

public class Serie {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

     @Column(unique = true)
    private String titulo;
// Asocia la propiedad JSON "Title" con el campo `titulo`.

    private Integer totalTemporadas;
// Asocia la propiedad JSON "totalSeasons" con el campo `totalTemporadas`.

    private String evaluacion;
// Asocia la propiedad JSON "imdbRating" con el campo `evaluacion`.

    private String poster;
// Asocia la propiedad JSON "Poster" con el campo `poster`.

    @Enumerated(EnumType.STRING)
    private Categoria genero;
// Asocia la propiedad JSON "Genre" con el campo `genero`.

    private String actores;
// Asocia la propiedad JSON "Actors" con el campo `actores`.

    private String sinopsis;
// Asocia la propiedad JSON "Plot" con el campo `sinopsis`.
    @Transient
    private List<Episodio> episodios;

    ////    se crea el constructor
public Serie(DatosSerie datosSerie) {
    this.titulo = datosSerie.titulo();
    this.totalTemporadas = datosSerie.totalTemporadas();
    this.evaluacion = String.valueOf(OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0));
    this.poster = datosSerie.poster();
    this.genero = Categoria.fromString(datosSerie.genero().split(":")[0].trim());
    this.actores = datosSerie.actores();
    this.sinopsis = datosSerie.sinopsis();
                                    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", evaluacion='" + evaluacion + '\'' +
                ", poster='" + poster + '\'' +

                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}



