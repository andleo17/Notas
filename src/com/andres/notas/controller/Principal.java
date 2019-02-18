
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmPrincipal;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal {
    
    private final Estudiante estudiante;
    private FrmPrincipal frmPrincipal;
    private Ciclo ciclo;
    
    public Principal(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public void iniciar() {
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        frmPrincipal.setTitle("Menú principal");
        
        colocarEstudiante();
        colocarCiclo();
        listarMatricula();
    }
    
    private void colocarEstudiante() {
        JLabel lblEstudiante = (JLabel) frmPrincipal.getComponentByName("lblEstudiante");
        lblEstudiante.setText(estudiante.getApellidos() + ", " + estudiante.getNombre());
    }
    
    private void colocarCiclo() {
        this.ciclo = Ciclo.obtenerCiclo();
        JLabel lblCiclo = (JLabel) frmPrincipal.getComponentByName("lblCiclo");
        lblCiclo.setText(ciclo.getNombre());
        System.out.println(ciclo.getId());
    }
    
    private void listarMatricula() {
        ArrayList<Matricula> matriculas = Matricula.listarMatriculas(ciclo, estudiante);
        JTable tblCursos = (JTable) frmPrincipal.getComponentByName("tblCursos");
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
