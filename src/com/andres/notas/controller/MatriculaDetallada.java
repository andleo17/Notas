
package com.andres.notas.controller;

import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmMatriculaDetallada;
import com.andres.notas.view.FrmPrincipal;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MatriculaDetallada implements IMapeable{
    
    private FrmPrincipal frmPrincipal;
    private Matriculas matriculas;
    private FrmMatriculaDetallada frmMatriculaDetallada;
    private Matricula matricula;
    private JLabel lblCurso;
    private JLabel lblProfesor;
    private JButton btnVolver;
    private JPanel pnlContenido;
    
    public MatriculaDetallada(Matricula matricula, FrmPrincipal frmPrincipal) {
        this.matricula = matricula;
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    private void iniciar() {
        frmMatriculaDetallada = new FrmMatriculaDetallada();
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmPrincipal);
        frmMatriculaDetallada.setSize(500, 500);
        frmMatriculaDetallada.setLocation(0, 0);
        pnlContenido.removeAll();
        pnlContenido.add(frmMatriculaDetallada, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
        lblCurso = (JLabel) getComponentByName("lblCurso", frmMatriculaDetallada);
        lblProfesor = (JLabel) getComponentByName("lblProfesor", frmMatriculaDetallada);
        btnVolver = (JButton) getComponentByName("btnVolver", frmMatriculaDetallada);
        btnVolver.addActionListener(evt -> volver());
        lblCurso.setText(matricula.getCurso().getNombre());
        lblProfesor.setText(matricula.getProfesor().getNombre());
    }
    
    private void volver() {
        matriculas = new Matriculas(frmPrincipal, matricula.getEstudiante(), matricula.getCiclo());
        JPanel frm = matriculas.iniciar();
        frm.setSize(500, 500);
        frm.setLocation(0, 0);
        pnlContenido.removeAll();
        pnlContenido.add(frm, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
}
