
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmMatriculas;
import com.andres.notas.view.FrmPrincipal;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Matriculas implements IMapeable{
    
    private final FrmPrincipal frm;
    
    private FrmMatriculas frmMatriculas;
    private Ciclo ciclo;
    private final Estudiante estudiante;
    private ArrayList<Matricula> matriculas;
    
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTable tblCursos;
    
    public Matriculas(FrmPrincipal frm, Estudiante estudiante, Ciclo ciclo) {
        this.frm = frm;
        this.estudiante = estudiante;
        this.ciclo = ciclo;
    }
    
    public JPanel iniciar() {
        frmMatriculas = new FrmMatriculas();
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmMatriculas);
        btnAgregar.addActionListener(evt -> agregar());
        
        btnModificar = (JButton) getComponentByName("btnModificar", frmMatriculas);
        btnModificar.addActionListener(evt -> modificar());
        
        btnEliminar = (JButton) getComponentByName("btnEliminar", frmMatriculas);
        btnEliminar.addActionListener(evt -> eliminar());
        
        tblCursos = (JTable) getComponentByName("tblCursos", frmMatriculas);

        listarMatricula();
        
        return frmMatriculas;
    }
    
    private void agregar() {
        new AgregarMatricula(estudiante, ciclo).iniciar(frm);
        listarMatricula();
    }
    
    private void modificar() {
        new AgregarMatricula(estudiante, ciclo).iniciar(frm, matriculas.get(tblCursos.getSelectedRow()));
        listarMatricula();
    }
    
    private void eliminar() {
        matriculas.get(tblCursos.getSelectedRow()).eliminar();
        listarMatricula();
    }
    
    private void listarMatricula() {
        matriculas = Matricula.listarMatriculas(ciclo, estudiante);
        matriculas.sort((m, m1) -> {
            String nombre1 = m.getCurso().getNombre();
            String nombre2 = m1.getCurso().getNombre();
            return nombre1.compareTo(nombre2);
        });
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Profesor");
        Object datos[] = new Object[2];
        
        matriculas.forEach(m -> {
            datos[0] = m.getCurso().getNombre();
            datos[1] = m.getProfesor().getApellidos() + ", " + m.getProfesor().getNombre();
            modelo.addRow(datos);
        });
        tblCursos.setModel(modelo);
    }
    
}
