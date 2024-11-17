package com.aluracursos.screeenmatch.principal;

import com.aluracursos.screeenmatch.Service.ConsumoAPI;
import com.aluracursos.screeenmatch.Service.ConvierteDatos;
import com.aluracursos.screeenmatch.model.DatosEpisodio;
import com.aluracursos.screeenmatch.model.DatosSerie;
import com.aluracursos.screeenmatch.model.DatosTemporadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        temporadas.forEach(System.out::println);

        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();

            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());

            }
        }
    }
}
