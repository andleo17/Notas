
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Curso;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.model.Profesor;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AgregarMatricula implements IMapeable{
    
    private FrmAgregarMatricula frmAgregarMatricula;
    private final Estudiante estudiante;
    private final Ciclo ciclo;
    private final ArrayList<Rubrica> rubricas;
    
    public AgregarMatricula(Estudiante estudiante, Ciclo ciclo) {
        this.rubricas = new ArrayList<>();
        this.estudiante = estudiante;
        this.ciclo = ciclo;
    }
    
    public void iniciar(java.awt.Frame frame) {
        frmAgregarMatricula = new FrmAgregarMatricula(frame, false);
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
        
        frmAgregarMatricula.setModal(true);
        frmAgregarMatricula.setVisible(false);
        frmAgregarMatricula.setVisible(true);
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
        AgregarRubrica agregarRubrica = new AgregarRubrica();
        agregarRubrica.iniciar(frmAgregarMatricula);
        rubricas.add(agregarRubrica.getRubrica());
        listarRubricas();
    }
    
    private void listarRubricas() {
        JTable tblRubricas = (JTable) getComponentByName("tblRubricas", frmAgregarMatricula);
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N° Rúbrica");
        modelo.addColumn("Nombre");
        modelo.addColumn("Peso");
        modelo.addColumn("N° Notas");
        Object datos[] = new Object[4];
        
        rubricas.forEach(r -> {
            datos[0] = rubricas.indexOf(r) + 1;
            datos[1] = r.getNombre();
            datos[2] = r.getPeso();
            datos[3] = r.getNotas().size();
            
            modelo.addRow(datos);
        });
        
        tblRubricas.setModel(modelo);
    }
    
    private void agregarMatricula() {
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        
        Curso curso = Curso.buscar(cboCursos.getSelectedIndex() + 1);
        Profesor profesor = Profesor.buscar(cboProfesores.getSelectedIndex() + 1);
        
        Matricula matricula = new Matricula();
        matricula.setCiclo(ciclo);
        matricula.setCurso(curso);
        matricula.setEstudiante(estudiante);
        matricula.setProfesor(profesor);
        matricula.agregar();
        
        AtomicInteger i = new AtomicInteger(1);
        
        rubricas.forEach(r -> {
            r.setMatricula(matricula);
            r.setNumeroRubrica(i.getAndIncrement());
            r.agregar();
            r.getNotas().forEach(n -> {
                n.setRubrica(r);
                n.agregar();
            });
        });
        
        frmAgregarMatricula.dispose();
    }
    
}
