
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmPrincipal;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal implements IMapeable{
    
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
        frmPrincipal.setLocationRelativeTo(null);
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmPrincipal);
        btnAgregar.addActionListener(evt -> agregar());
        
        colocarEstudiante();
        colocarCiclo();
        listarMatricula();
    }
    
    private void colocarEstudiante() {
        JLabel lblEstudiante = (JLabel) getComponentByName("lblEstudiante", frmPrincipal);
        lblEstudiante.setText(estudiante.getApellidos() + ", " + estudiante.getNombre());
    }
    
    private void colocarCiclo() {
        this.ciclo = Ciclo.obtenerCiclo();
        JLabel lblCiclo = (JLabel) getComponentByName("lblCiclo", frmPrincipal);
        lblCiclo.setText(ciclo.getNombre());
    }
    
    private void agregar() {
        new AgregarMatricula(estudiante, ciclo).iniciar(frmPrincipal);
        listarMatricula();
    }
    
    private void listarMatricula() {
        ArrayList<Matricula> matriculas = Matricula.listarMatriculas(ciclo, estudiante);
        matriculas.sort((m, m1) -> {
            String nombre1 = m.getCurso().getNombre();
            String nombre2 = m1.getCurso().getNombre();
            return nombre1.compareTo(nombre2);
        });
        JTable tblCursos = (JTable) getComponentByName("tblCursos", frmPrincipal);
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
