
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.RubricaDAO;

public class Rubrica implements RubricaDAO{
    
    private int idEstudiante;
    private int idCurso;
    private int idCiclo;
    private int numeroRubrica;
    private float peso;
    private ArrayList<Nota> notas;

    private static Rubrica objRubrica = new Rubrica();

    public static ArrayList<Rubrica> listar() {
        return objRubrica.consultarLista();
    }

    public void agregar() {
        objRubrica.agregar(this);
    }

    public void actualizar() {
        objRubrica.actualizar(this);
    }

    public void eliminar() {
        objRubrica.eliminar(this);
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

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
    
}
