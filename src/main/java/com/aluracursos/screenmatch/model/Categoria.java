package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime");

    private String categoriaOmdb;
    Categoria (String categoriaOmdb){
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String value) {
        String[] categorias = value.split(","); // Divide las categorías separadas por comas
        for (String categoria : categorias) {
            for (Categoria c : Categoria.values()) {
                if (c.name().equalsIgnoreCase(categoria.trim())) {
                    return c; // Retorna la primera categoría válida encontrada
                }
            }
        }
        throw new IllegalArgumentException("Ninguna categoría encontrada: " + value);
    }

}
