package com.ejemplo.model;

import java.util.Arrays;
import java.util.List;

public class Colecciones {
    private final List<String> generos = Arrays.asList("Femenino", "Masculino", "Otro");
    private final List<String> aficiones = Arrays.asList("Deporte", "Lectura", "Pintura", "Viajes");
    private final List<String> paises = Arrays.asList("Andorra", "España", "Francia", "Portugal");
    private final List<String> musicas = Arrays.asList("Electrónica", "Funky", "New Age", "Pop", "Rock");

    public List<String> getGeneros() {
        return generos;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public List<String> getPaises() {
        return paises;
    }

    public List<String> getMusicas() {
        return musicas;
    }
}
