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

    JsonEscapeUtil;
}
