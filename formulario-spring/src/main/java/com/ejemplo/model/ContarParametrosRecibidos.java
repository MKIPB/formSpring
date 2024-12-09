package com.ejemplo.model;

import java.util.List;

public class ContarParametrosRecibidos {

    public int calcularParametros(Object... parametros) {
        int count = 0;
        for (Object parametro : parametros) {
            if (parametro != null) {
                if (parametro instanceof String && !((String) parametro).isEmpty()) {
                    count++;
                } else if (parametro instanceof List && !((List<?>) parametro).isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }
}
