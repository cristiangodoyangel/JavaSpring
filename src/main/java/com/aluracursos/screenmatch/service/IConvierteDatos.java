package com.aluracursos.screenmatch.service;
// Define el paquete al que pertenece esta interfaz, utilizado para organizar el código.

public interface IConvierteDatos {
// Declara una interfaz para convertir datos JSON a objetos.

    <T> T obtenerDatos(String json, Class<T> clase);
    // Define un método genérico para obtener datos de un JSON y convertirlos a una clase específica.
}
