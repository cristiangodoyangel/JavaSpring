package com.aluracursos.screenmatch.service;
// Define el paquete de la clase para organizar las clases relacionadas con servicios.

// Importa la clase DatosSerie para trabajar con datos de series.

import com.fasterxml.jackson.core.JsonProcessingException;
// Importa la excepción JsonProcessingException para manejar errores durante el procesamiento de JSON.

import com.fasterxml.jackson.databind.ObjectMapper;
// Importa la clase ObjectMapper para convertir entre JSON y objetos Java.

public class ConvierteDatos implements IConvierteDatos {
// Declara la clase ConvierteDatos que implementa la interfaz IConvierteDatos.

    private ObjectMapper objectMapper = new ObjectMapper();
// Crea una instancia de ObjectMapper para manejar conversiones de JSON.

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
// Implementa el método genérico para convertir un JSON en una instancia de la clase especificada.

        try {
            return objectMapper.readValue(json, clase);
// Intenta convertir el JSON en un objeto de la clase proporcionada.

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
// Lanza una excepción en caso de error al procesar el JSON.
        }
    }
}
