
package com.andres.notas.model;

public class Nota {
    
    private int idEstudiante;
    private int idCurso;
    private int idCiclo;
    private int numeroRubrica;
    private int numeroNota;
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
