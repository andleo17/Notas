
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmPrincipal;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal implements IMapeable{
    
    private final Estudiante estudiante;
    private FrmPrincipal frmPrincipal;
    private Ciclo ciclo;
    
    private JPanel pnlContenido;
    private JButton btnMatriculas;
    private JButton btnCursos;
    private JButton btnProfesores;
    private JButton btnNotas;
    
    public Principal(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public void iniciar() {
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        frmPrincipal.setTitle("Menú principal");
        frmPrincipal.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmPrincipal);
        btnMatriculas = (JButton) getComponentByName("btnMatriculas", frmPrincipal);
        btnMatriculas.addActionListener(evt -> abrirMatriculas());
        btnCursos = (JButton) getComponentByName("btnCursos", frmPrincipal);
        btnProfesores = (JButton) getComponentByName("btnProfesores", frmPrincipal);
        btnNotas = (JButton) getComponentByName("btnNotas", frmPrincipal);
        
        colocarEstudiante();
        colocarCiclo();
    }
    
    private void abrirMatriculas() {
        Matriculas m = new Matriculas(frmPrincipal, estudiante, ciclo);
        colocarPanel(m.iniciar());
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
    
    private void colocarPanel(JPanel panel) {
        panel.setSize(500, 500);
        panel.setLocation(0, 0);
        pnlContenido.removeAll();
        pnlContenido.add(panel, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
}
