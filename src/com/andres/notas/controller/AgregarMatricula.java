
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Curso;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Profesor;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AgregarMatricula implements IMapeable{
    
    private FrmAgregarMatricula frmAgregarMatricula;
    private Estudiante estudiante;
    private Ciclo ciclo;
    private ArrayList<Rubrica> rubricas = new ArrayList<>();
    
    public AgregarMatricula(Estudiante estudiante, Ciclo ciclo) {
        this.estudiante = estudiante;
        this.ciclo = ciclo;
    }
    
    public void iniciar() {
        frmAgregarMatricula = new FrmAgregarMatricula();
        frmAgregarMatricula.setVisible(true);
        frmAgregarMatricula.setTitle("Agregar Matrícula");
        frmAgregarMatricula.setLocationRelativeTo(null);
        listarCursos();
        listarProfesores();
        
        JButton btnAgregarCurso = (JButton) getComponentByName("btnAgregarCurso", frmAgregarMatricula);
        btnAgregarCurso.addActionListener(evt -> agregarCurso());
        
        JButton btnModificarCurso = (JButton) getComponentByName("btnModificarCurso", frmAgregarMatricula);
        btnModificarCurso.addActionListener(evt -> modificarCurso());
        
        JButton btnQuitarCurso = (JButton) getComponentByName("btnQuitarCurso", frmAgregarMatricula);
        btnQuitarCurso.addActionListener(evt -> quitarCurso());
        
        
        JButton btnAgregarProfesor = (JButton) getComponentByName("btnAgregarProfesor", frmAgregarMatricula);
        btnAgregarProfesor.addActionListener(evt -> agregarProfesor());
        
        JButton btnModificarProfesor = (JButton) getComponentByName("btnModificarProfesor", frmAgregarMatricula);
        btnModificarProfesor.addActionListener(evt -> modificarProfesor());
        
        JButton btnQuitarProfesor = (JButton) getComponentByName("btnQuitarProfesor", frmAgregarMatricula);
        btnQuitarProfesor.addActionListener(evt -> quitarProfesor());
        
        
        JButton btnAgregarRubrica = (JButton) getComponentByName("btnAgregarRubrica", frmAgregarMatricula);
        btnAgregarRubrica.addActionListener(evt -> agregarRubrica());
        
        JButton btnAgregarMatricula = (JButton) getComponentByName("btnAgregarMatricula", frmAgregarMatricula);
        btnAgregarMatricula.addActionListener(evt -> agregarMatricula());
    }
    
    private void listarCursos() {
        ArrayList<Curso> cursos = Curso.listar();
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        cboCursos.removeAllItems();
        cursos.forEach(c -> cboCursos.addItem(c.getNombre()));
    }
    
    private void listarProfesores() {
        ArrayList<Profesor> profesores = Profesor.listar();
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        cboProfesores.removeAllItems();
        profesores.forEach(p -> cboProfesores.addItem(p.getApellidos() + ", " + p.getNombre()));
    }
    
    private void agregarCurso() {
        new AgregarCurso().iniciar(frmAgregarMatricula);
        listarCursos();
    }
    
    private void modificarCurso() {
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        new AgregarCurso().iniciar(frmAgregarMatricula, Curso.buscar(cboCursos.getSelectedIndex() + 1));
        listarCursos();
    }
    
    private void quitarCurso() {
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        Curso curso = Curso.buscar(cboCursos.getSelectedIndex() + 1);
        curso.eliminar();
        listarCursos();
    }
    
    private void agregarProfesor() {
        new AgregarProfesor().iniciar(frmAgregarMatricula);
        listarProfesores();
    }
    
    private void modificarProfesor() {
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        new AgregarProfesor().iniciar(frmAgregarMatricula, Profesor.buscar(cboProfesores.getSelectedIndex() + 1));
        listarProfesores();
    }
    
    private void quitarProfesor() {
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        Profesor profesor = Profesor.buscar(cboProfesores.getSelectedIndex() + 1);
        profesor.eliminar();
        listarProfesores();
    }
    
    private void agregarRubrica() {
        
    }
    
    private void agregarMatricula() {
        
    }
    
}
