
package com.andres.notas.model;

import com.andres.notas.dao.CicloDAO;

public class Ciclo implements CicloDAO{
    
    private int id;
    private String nombre;

    private static Ciclo objCiclo = new Ciclo();

    public static Ciclo obtenerCiclo() {
        return objCiclo.obtenerCicloActual();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
