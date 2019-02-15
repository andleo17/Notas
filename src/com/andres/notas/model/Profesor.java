
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.ProfesorDAO;

public class Profesor implements ProfesorDAO {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String email;

    private static Profesor objProfesor = new Profesor();

    public static ArrayList<Profesor> listar() {
        return objProfesor.consultarLista();
    }

    public void agregar() {
        objProfesor.agregar(this);
    }
    
    public void actualizar() {
        objProfesor.actualizar(this);
    }

    public void eliminar() {
        objProfesor.eliminar(this);
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
