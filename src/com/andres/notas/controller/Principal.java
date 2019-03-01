
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal implements IMapeable{
    
    private final Estudiante estudiante;
    private FrmPrincipal frmPrincipal;
    private Ciclo ciclo;
    
    private JPanel pnlContenido;
    private JLabel lblEstudiante;
    private JLabel lblCiclo;
    private JButton btnMatriculas;
    private JButton btnCursos;
    private JButton btnProfesores;
    
    public Principal(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public void iniciar() {
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        frmPrincipal.setTitle("Menú principal");
        frmPrincipal.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmPrincipal);
        
        lblCiclo = (JLabel) getComponentByName("lblCiclo", frmPrincipal);
        lblEstudiante = (JLabel) getComponentByName("lblEstudiante", frmPrincipal);
        
        btnMatriculas = (JButton) getComponentByName("btnMatriculas", frmPrincipal);
        btnMatriculas.addActionListener(evt -> abrirMatriculas());
        
        btnCursos = (JButton) getComponentByName("btnCursos", frmPrincipal);
        btnCursos.addActionListener(evt -> abrirCursos());
        
        btnProfesores = (JButton) getComponentByName("btnProfesores", frmPrincipal);
        btnProfesores.addActionListener(evt -> abrirProfesores());
        
        colocarEstudiante();
        colocarCiclo();
    }
    
    private void abrirMatriculas() {
        Matriculas m = new Matriculas(frmPrincipal, estudiante, ciclo);
        colocarPanel(m.iniciar());
    }
    
    private void abrirProfesores() {
        Profesores p = new Profesores(frmPrincipal);
        colocarPanel(p.iniciar());
    }
    
    private void abrirCursos() {
        Cursos c = new Cursos(frmPrincipal);
        colocarPanel(c.iniciar());
    }
    
    private void colocarEstudiante() {
        lblEstudiante.setText(estudiante.getApellidos() + ", " + estudiante.getNombre());
    }
    
    private void colocarCiclo() {
        this.ciclo = Ciclo.obtenerCiclo();
        lblCiclo.setText(ciclo.getNombre());
    }
    
    private void colocarPanel(JPanel panel) {
        pnlContenido.removeAll();
        pnlContenido.add(panel);
        pnlContenido.updateUI();
    }
    
}
