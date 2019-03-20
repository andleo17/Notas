
package com.andres.notas.model;

import java.util.ArrayList;

import com.andres.notas.dao.RubricaDAO;
import java.sql.SQLException;

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
    public void agregar() throws SQLException {
        objRubrica.agregar(this);
    }

    @Override
    public void actualizar() throws SQLException {
        objRubrica.actualizar(this);
    }

    @Override
    public void eliminar() throws SQLException {
        objRubrica.eliminar(this);
    }
    
    public float getPromedio() {
        float suma = 0;
        for (Nota n : notas) if (n.getNota() != -1) suma += n.getNota();
        return suma / notas.size();
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
