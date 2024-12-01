package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.Service.ConsumoAPI;
import com.aluracursos.screenmatch.Service.ConvierteDatos;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=1a68466f";
    private ConvierteDatos conversor = new ConvierteDatos();



    public void muestraElMenu(){
        System.out.println("Por favor escriba el nombre de la serie: ");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+i+API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);

        }
//        temporadas.forEach(System.out::println);

        /*for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();

            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());

            }
        }*/
        temporadas.forEach(t -> t.episodios().forEach(e-> System.out.println(e.titulo())));

      List<DatosEpisodio> datosEpisodios = temporadas.stream()
              .flatMap(t -> t.episodios().stream())
              .toList();

      //     Top 5 mejores episodios

        datosEpisodios.stream()
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .limit(5)
                .forEach(System.out::println);

//        convirtiendo los datos a una lista Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());
//        episodios.forEach(System.out::println);

//        busqueda de episodios a partir de X año
        System.out.println("Busca por Fecha");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


//        episodios.stream()
//                .filter(e -> e.getFechaDeLanzamiento()!= null && e.getFechaDeLanzamiento()  .isAfter(fechaBusqueda))
//                .forEach(e -> System.out.println(
//                        "Temporada " + e.getTemporada() +
//                                "Episodio " + e.getNumeroEpisodio() +
//                                "Fecha de Lanzamiento: " + e.getFechaDeLanzamiento().format(dtf)
//                ));
//

        // Muestra evaluaciones de todas las temporadas
        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        //Calcular estadísticas de las evaluaciones de los episodios
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media " + est.getAverage());
        System.out.println("Mejor episódio: " + est.getMax());
        System.out.println("Peor episódio: " + est.getMin());
        System.out.println("Cantidad " + est.getCount());

    }
}
