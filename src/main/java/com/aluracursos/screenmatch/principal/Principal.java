package com.aluracursos.screenmatch.principal;
// Define el paquete al que pertenece esta clase, utilizado para organizar el código.

import com.aluracursos.screenmatch.model.DatosSerie;
// Importa la clase DatosSerie para manejar datos relacionados con series.

import com.aluracursos.screenmatch.model.DatosTemporadas;
// Importa la clase DatosTemporadas para manejar datos relacionados con temporadas.

import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
// Importa la clase ConsumoAPI, utilizada para consumir datos de una API.

import com.aluracursos.screenmatch.service.ConvierteDatos;
import com.aluracursos.screenmatch.model.Serie;
// Importa la clase ConvierteDatos para transformar datos JSON a objetos.

import java.util.ArrayList;
// Importa la clase ArrayList, utilizada para manejar listas dinámicas.

import java.util.Comparator;
import java.util.List;
// Importa la clase List, una interfaz para listas de objetos....

import java.util.Scanner;
import java.util.stream.Collectors;


// Importa la clase Scanner, utilizada para recibir entrada del usuario.

public class Principal {
// Define la clase principal que contiene la lógica de interacción del programa.

    private Scanner teclado = new Scanner(System.in);
    // Crea un objeto Scanner para recibir entrada desde la consola.

    private ConsumoAPI consumoApi = new ConsumoAPI();
    // Crea un objeto ConsumoAPI para realizar solicitudes a una API.

    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    // Define la URL base de la API.

    private final String API_KEY = "&apikey=1a68466f";
    // Define la clave de API necesaria para realizar solicitudes.

    private ConvierteDatos conversor = new ConvierteDatos();
    // Crea un objeto ConvierteDatos para transformar datos JSON a objetos Java.

    private List<DatosSerie> datosSeries = new ArrayList<>();

    private SerieRepository repositorio;

    public Principal(SerieRepository repository) {
        this.repositorio = repository;

    }
    // Define lista datosSerie para busqueda.

    public void muestraElMenu() {
        // Método que muestra el menú principal y gestiona la navegación del usuario.

        var opcion = -1;
        // Inicializa la opción seleccionada por el usuario.

        while (opcion != 0) {
            // Bucle que continúa mostrando el menú hasta que la opción sea 0 (salir).

            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                                  
                    0 - Salir
                    """;
            // Define el menú de opciones.

            System.out.println(menu);
            // Muestra el menú en la consola.

            opcion = teclado.nextInt();
            // Lee la opción seleccionada por el usuario.

            teclado.nextLine();
            // Limpia el buffer del Scanner.

            switch (opcion) {
                // Gestiona la opción seleccionada.

                case 1:
                    buscarSerieWeb();
                    // Llama al método para buscar una serie en la web.
                    break;

                case 2:
                    buscarEpisodioPorSerie();
                    // Llama al método para buscar episodios de una serie.
                    break;

                case 3:
                    mostrarSeriesBuscadas();

                    // Imprime en la consola los datos de las series buscadas.
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    // Mensaje que indica el cierre de la aplicación.
                    break;

                default:
                    System.out.println("Opción inválida");
                    // Mensaje de error si la opción no es válida.
            }
        }
    }

    private DatosSerie getDatosSerie() {
        // Método para obtener los datos de una serie desde la API.

        System.out.println("Escribe el nombre de la serie que deseas buscar");
        // Solicita al usuario el nombre de la serie.

        var nombreSerie = teclado.nextLine();
        // Lee el nombre de la serie ingresado por el usuario.

        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        // Realiza una solicitud a la API reemplazando los espacios en blanco por "+".

        System.out.println(json);
        // Muestra la respuesta JSON de la API.

        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        // Convierte el JSON a un objeto de tipo DatosSerie.

        return datos;
        // Devuelve el objeto DatosSerie.
    }

    private void buscarEpisodioPorSerie() {
        // Método para buscar los episodios de una serie específica.

        DatosSerie datosSerie = getDatosSerie();
        // Obtiene los datos de la serie.

        List<DatosTemporadas> temporadas = new ArrayList<>();
        // Crea una lista para almacenar las temporadas.

        for (int i = 1; i <= datosSerie.totalTemporadas(); i++) {
            // Itera sobre cada temporada de la serie.

            var json = consumoApi.obtenerDatos(URL_BASE + datosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            // Realiza una solicitud a la API para obtener datos de una temporada específica.

            DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            // Convierte el JSON de la temporada a un objeto DatosTemporadas.

            temporadas.add(datosTemporada);
            // Agrega la temporada a la lista.
        }

        temporadas.forEach(System.out::println);
        // Imprime en la consola los datos de cada temporada.
    }

    private void buscarSerieWeb() {
        // Método para buscar una serie y mostrar sus datos.

        DatosSerie datos = getDatosSerie();
        // Obtiene los datos de la serie.
        Serie serie = new Serie(datos);
        repositorio.save(serie);
//        datosSeries.add(datos);
        // Agrega los datos de la serie a la lista.

        System.out.println(datos);
        // Imprime en la consola los datos de la serie.
    }

    private void mostrarSeriesBuscadas() {
        // Método para mostrar los datos de las series buscadas.
            List<Serie> series = repositorio.findAll();

            series.stream()
                    .sorted(Comparator.comparing(Serie::getGenero))
                    .forEach(System.out::println);

        }


    }
