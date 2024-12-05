package com.aluracursos.screenmatch.service;
// Define el paquete de la clase para organizar las clases relacionadas con servicios.

import java.io.IOException;
// Importa la excepción IOException para manejar errores de entrada/salida.

import java.net.URI;
// Importa la clase URI para manejar URLs.

import java.net.http.HttpClient;
// Importa la clase HttpClient para realizar solicitudes HTTP.

import java.net.http.HttpRequest;
// Importa la clase HttpRequest para construir solicitudes HTTP.

import java.net.http.HttpResponse;
// Importa la clase HttpResponse para manejar las respuestas HTTP.

public class ConsumoAPI {
// Declara la clase ConsumoAPI para manejar solicitudes a una API externa.

    public String obtenerDatos(String url) {
// Método público que recibe una URL y retorna la respuesta en formato JSON.

        HttpClient client = HttpClient.newHttpClient();
// Crea un cliente HTTP para realizar solicitudes.

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
// Construye una solicitud HTTP con la URL proporcionada.

                .build();
// Finaliza la construcción de la solicitud.

        HttpResponse<String> response = null;
// Declara una variable para almacenar la respuesta HTTP.

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
// Envía la solicitud y captura la respuesta como un String.
        } catch (IOException e) {
            throw new RuntimeException(e);
// Lanza una excepción en caso de error de entrada/salida.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
// Lanza una excepción en caso de interrupción durante la solicitud.
        }

        String json = response.body();
// Obtiene el cuerpo de la respuesta como un String JSON.

        return json;
// Retorna el JSON obtenido.
    }
}
