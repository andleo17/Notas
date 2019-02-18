
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.CursoDAO;

public class Curso implements CursoDAO, IAdministrable {
    
    private int id;
    private String nombre;
    private int creditos;

    private static Curso objCurso = new Curso();

    public static Curso buscar(int id) {
        ArrayList<Curso> curso = listar();
        for (Curso c : curso) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public static ArrayList<Curso> listar() {
        return objCurso.consultarLista();
    }

    public void agregar() {
        objCurso.agregar(this);
    }

    public void actualizar() {
        objCurso.actualizar(this);
    }

    public void eliminar() {
        objCurso.eliminar(this);
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
    
    public int getCreditos(){
        return creditos;
    }
    
    public void setCreditos(int creditos){
        this.creditos = creditos;
    }
    
}
