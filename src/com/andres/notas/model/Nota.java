
package com.andres.notas.model;

public class Nota {
    
    private int idEstudiante;
    private int idCurso;
    private int idProfesor;
    private int idCiclo;
    private int numeroRubrica;
    private float nota;

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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
