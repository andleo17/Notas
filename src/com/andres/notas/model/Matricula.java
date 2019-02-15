
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.MatriculaDAO;

public class Matricula implements MatriculaDAO {
    
    private int idEstudiante;
    private int idCurso;
    private int idProfesor;
    private int idCiclo;
    private ArrayList<Rubrica> rubricas;
    private float promedioFinal;

    private static Matricula objMatricula = new Matricula();

    public static ArrayList<Matricula> listar() {
        return objMatricula.consultarLista();
    }

    public void agregar() {
        objMatricula.agregar(this);
    }

    public void actualizar() {
        objMatricula.actualizar(this);
    }

    public void eliminar() {
        objMatricula.eliminar(this);
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
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
