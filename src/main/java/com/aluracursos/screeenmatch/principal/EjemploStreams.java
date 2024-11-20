package com.aluracursos.screeenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("brenda1", "brenda12", "brenda13", "brenda15");
        nombres.stream()
        .sorted()
                .limit(4)
                .filter(n-> n.startsWith("B"))
                .forEach(System.out::println);
    }
}
