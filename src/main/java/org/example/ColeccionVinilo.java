package org.example;

import java.util.ArrayList;
import java.util.List;

// Clase que gestiona la colección de vinilos
public class ColeccionVinilo {
    private List<Vinilo> coleccion;
    private static final int MAX_VINILOS = 100;

    public ColeccionVinilo() {
        this.coleccion = new ArrayList<>();
    }

    // Agrega un vinilo si hay espacio disponible
    public boolean agregarVinilo(Vinilo vinilo) {
        if (coleccion.size() < MAX_VINILOS) {
            coleccion.add(vinilo);
            return true;
        }
        return false;
    }

    // Busca un vinilo en la colección
    public boolean buscarVinilo(String nombreDisco) {
        return coleccion.stream().anyMatch(v -> v.getName().equalsIgnoreCase(nombreDisco));
    }

    // Obtiene la cantidad de vinilos en la colección
    public int cantidadVinilos() {
        return coleccion.size();
    }

    // Obtiene los espacios disponibles en la colección
    public int espaciosDisponibles() {
        return MAX_VINILOS - coleccion.size();
    }
}
