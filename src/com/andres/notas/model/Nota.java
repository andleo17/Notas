
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.NotaDAO;

public class Nota implements NotaDAO, IAdministrable {
    
    private Rubrica rubrica;
    private int numeroNota;
    private float nota;

    private static Nota objNota = new Nota();

    public static ArrayList<Nota> listar(Rubrica rubrica) {
        return objNota.obtenerNotas(rubrica);
    }

    public void agregar() {
        objNota.agregar(this);
    }

    public void actualizar() {
        objNota.actualizar(this);
    }

    public void eliminar() {
        objNota.eliminar(this);
    }

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    public int getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
