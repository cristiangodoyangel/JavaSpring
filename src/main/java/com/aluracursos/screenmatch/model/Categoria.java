package com.aluracursos.screenmatch.model;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

public enum Categoria {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }
//este es un mensaje de testing
public static Categoria fromString(String text) {
    for (Categoria categoria : Categoria.values()) {
        if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
            return categoria;
        }
    }
    throw new IllegalArgumentException("Ninguna categoría encontrada: " + text);
}

}
