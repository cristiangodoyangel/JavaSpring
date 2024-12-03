package com.aluracursos.screenmatch.model;
// Define el paquete al que pertenece esta clase, utilizado para organizar el código.

import java.time.LocalDate;
// Importa la clase LocalDate para manejar fechas.

import java.time.format.DateTimeParseException;
// Importa la excepción DateTimeParseException, utilizada para manejar errores de formato de fechas.

public class Episodio {
// Define una clase `Episodio` para modelar los datos de un episodio.

    private Integer temporada;
    // Almacena el número de la temporada.

    private String titulo;
    // Almacena el título del episodio.

    private Integer numeroEpisodio;
    // Almacena el número del episodio.

    private Double evaluacion;
    // Almacena la calificación del episodio.

    private LocalDate fechaDeLanzamiento;
    // Almacena la fecha de lanzamiento del episodio.

    public Episodio(Integer numero, DatosEpisodio d) {
        // Constructor que inicializa un objeto `Episodio` a partir de un número de temporada y un `DatosEpisodio`.

        this.temporada = numero;
        // Asigna el número de temporada.

        this.titulo = d.titulo();
        // Asigna el título del episodio a partir de `DatosEpisodio`.

        this.numeroEpisodio = d.numeroEpisodio();
        // Asigna el número del episodio.

        try {
            this.evaluacion = Double.valueOf(d.evaluacion());
            // Intenta convertir la calificación de tipo String a Double.
        } catch (NumberFormatException e) {
            this.evaluacion = 0.0;
            // Si ocurre un error, asigna 0.0 como calificación por defecto.
        }

        try {
            this.fechaDeLanzamiento = LocalDate.parse(d.fechaDeLanzamiento());
            // Intenta convertir la fecha de lanzamiento de tipo String a LocalDate.
        } catch (DateTimeParseException e) {
            this.fechaDeLanzamiento = null;
            // Si ocurre un error, asigna `null` como fecha por defecto.
        }
    }

    public Integer getTemporada() { return temporada; }
    // Devuelve el número de la temporada.

    public void setTemporada(Integer temporada) { this.temporada = temporada; }
    // Establece el número de la temporada.

    public String getTitulo() { return titulo; }
    // Devuelve el título del episodio.

    public void setTitulo(String titulo) { this.titulo = titulo; }
    // Establece el título del episodio.

    public Integer getNumeroEpisodio() { return numeroEpisodio; }
    // Devuelve el número del episodio.

    public void setNumeroEpisodio(Integer numeroEpisodio) { this.numeroEpisodio = numeroEpisodio; }
    // Establece el número del episodio.

    public Double getEvaluacion() { return evaluacion; }
    // Devuelve la calificación del episodio.

    public void setEvaluacion(Double evaluacion) { this.evaluacion = evaluacion; }
    // Establece la calificación del episodio.

    public LocalDate getFechaDeLanzamiento() { return fechaDeLanzamiento; }
    // Devuelve la fecha de lanzamiento del episodio.

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) { this.fechaDeLanzamiento = fechaDeLanzamiento; }
    // Establece la fecha de lanzamiento del episodio.

    @Override
    public String toString() {
        // Sobrescribe el método `toString` para devolver una representación en texto del objeto.

        return "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento;
        // Devuelve una cadena con los valores de los atributos.
    }
}
