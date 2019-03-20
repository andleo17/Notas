
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.ProfesorDAO;
import java.sql.SQLException;

public class Profesor implements ProfesorDAO, IAdministrable {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String email;

    private static final Profesor objProfesor = new Profesor();

    public static Profesor buscar(int id) {
        ArrayList<Profesor> profesor = listar();
        for (Profesor p : profesor) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public static ArrayList<Profesor> listar() {
        return objProfesor.consultarLista();
    }

    @Override
    public void agregar() throws SQLException {
        objProfesor.agregar(this);
    }
    
    @Override
    public void actualizar() throws SQLException {
        objProfesor.actualizar(this);
    }

    @Override
    public void eliminar() throws SQLException {
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
