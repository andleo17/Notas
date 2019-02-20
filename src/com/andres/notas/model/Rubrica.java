
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.RubricaDAO;

public class Rubrica implements RubricaDAO, IAdministrable {
    
    private Matricula matricula;
    private int numeroRubrica;
    private String nombre;
    private float peso;
    private ArrayList<Nota> notas;

    private static final Rubrica objRubrica = new Rubrica();

    public static ArrayList<Rubrica> listar(Matricula matricula) {
        return objRubrica.obtenerRubricas(matricula);
    }

    @Override
    public void agregar() {
        objRubrica.agregar(this);
        notas.forEach(n -> {
            n.setRubrica(this);
            n.agregar();
        });
    }

    @Override
    public void actualizar() {
        objRubrica.actualizar(this);
    }

    @Override
    public void eliminar() {
        notas.forEach(n -> n.eliminar());
        objRubrica.eliminar(this);
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
    
}
