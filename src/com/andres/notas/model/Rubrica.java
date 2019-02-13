
package com.andres.notas.model;

import java.util.ArrayList;

public class Rubrica {
    
    private int idEstudiante;
    private int idCurso;
    private int idProfesor;
    private int idCiclo;
    private int numeroRubrica;
    private float peso;
    private ArrayList<Nota> notas;

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
    
    public int getNumeroRubrica(){
        return numeroRubrica;
    }

    public void setNumeroRubrica(int numeroRubrica){
        this.numeroRubrica = numeroRubrica;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public void setPeso(float peso){
        this.peso = peso;
    }
    
    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setRubricas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
    
}
