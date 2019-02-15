
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.EstudianteDAO;

public class Estudiante implements EstudianteDAO {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    private static Estudiante objEstudiante = new Estudiante();

    public Estudiante iniciarSesion(String email, String password) {
        ArrayList<Estudiante> estudiantes = objEstudiante.consultarLista();
        estudiantes.stream().filter(e -> e.getEmail().equals(email) && e.getPassword().equals(password));
        return estudiantes.get(0);
    }

    public void agregar() {
        objEstudiante.agregar(this);
    }

    public void actualizar() {
        objEstudiante.actualizar(this);
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
