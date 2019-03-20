
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.MatriculaDAO;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class Matricula implements MatriculaDAO, IAdministrable {
    
    private Estudiante estudiante;
    private Curso curso;
    private Ciclo ciclo;
    private Profesor profesor;
    private ArrayList<Rubrica> rubricas;
    private float promedioFinal;

    private static final Matricula objMatricula = new Matricula();

    public static ArrayList<Matricula> listarMatriculas(Ciclo ciclo, Estudiante estudiante) {
        return objMatricula.consultarLista(estudiante, ciclo);
    }

    @Override
    public void agregar() throws SQLException{
        objMatricula.agregar(this);
        for (Rubrica r : rubricas) {
            r.setMatricula(this);
            r.agregar();
            for (Nota n : r.getNotas()) n.agregar();
        }
    }

    @Override
    public void actualizar() throws SQLException {
        objMatricula.actualizar(this);
    }

    @Override
    public void eliminar() throws SQLException {
        objMatricula.eliminar(this);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public ArrayList<Rubrica> getRubricas() {
        return rubricas;
    }

    public void setRubricas(ArrayList<Rubrica> rubricas) {
        this.rubricas = rubricas;
    }
    
    public float getPromedioFinal() {
        return promedioFinal;
    }

    public void setPromedioFinal(float promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

}
