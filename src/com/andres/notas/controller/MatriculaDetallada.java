
package com.andres.notas.controller;

import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmMatriculaDetallada;
import com.andres.notas.view.FrmPrincipal;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MatriculaDetallada implements IMapeable{
    
    private FrmPrincipal frmPrincipal;
    private Matriculas matriculas;
    private FrmMatriculaDetallada frmMatriculaDetallada;
    private Matricula matricula;
    private JLabel lblCurso;
    private JLabel lblProfesor;
    private JButton btnVolver;
    private JPanel pnlContenido;
    private JPanel pnlNotas;
    
    public MatriculaDetallada(Matricula matricula, FrmPrincipal frmPrincipal) {
        this.matricula = matricula;
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    private void iniciar() {
        frmMatriculaDetallada = new FrmMatriculaDetallada();
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmPrincipal);
        pnlNotas = (JPanel) getComponentByName("pnlNotas", frmMatriculaDetallada);
        pnlContenido.removeAll();
        pnlContenido.add(frmMatriculaDetallada);
        pnlContenido.revalidate();
        pnlContenido.repaint();
        lblCurso = (JLabel) getComponentByName("lblCurso", frmMatriculaDetallada);
        lblProfesor = (JLabel) getComponentByName("lblProfesor", frmMatriculaDetallada);
        btnVolver = (JButton) getComponentByName("btnVolver", frmMatriculaDetallada);
        btnVolver.addActionListener(evt -> volver());
        lblCurso.setText(matricula.getCurso().getNombre());
        lblProfesor.setText(matricula.getProfesor().getNombre());
        mostrarNotas();
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
    
    private void mostrarNotas(){
        AtomicInteger i = new AtomicInteger(0);
        matricula.getRubricas().forEach(r -> {
            JLabel rubrica = new JLabel();
            rubrica.setBackground(new java.awt.Color(255, 255, 255));
            rubrica.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
            rubrica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            rubrica.setText(r.getNombre());
            rubrica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            rubrica.setOpaque(true);
            GridBagConstraints gbc = new java.awt.GridBagConstraints();
            gbc.gridx = i.get();
            gbc.gridy = 0;
            gbc.gridwidth = r.getNotas().size() + 1;
            gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 10;
            gbc.ipady = 10;
            pnlNotas.add(rubrica, gbc);

            StringBuilder p = new StringBuilder();
            
            for (String c1 : r.getNombre().split(" "))
                p.append(c1.charAt(0));

            r.getNotas().forEach(n -> {
                JLabel rubricaNombre = new JLabel();
                rubricaNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
                rubricaNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                rubricaNombre.setText(p.toString() + n.getNumeroNota());
                rubricaNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                GridBagConstraints gb = new java.awt.GridBagConstraints();
                gb.gridx = i.get();
                gb.gridy = 1;
                gb.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gb.ipadx = 10;
                gb.ipady = 10;
                pnlNotas.add(rubricaNombre, gb);
                
                JTextField nota = new JTextField();
                nota.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
                nota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                nota.setText(String.valueOf(n.getNota()));
                nota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = i.getAndIncrement();
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.ipadx = 10;
                gridBagConstraints.ipady = 10;
                pnlNotas.add(nota, gridBagConstraints);
            });
            JLabel promedioNombre = new JLabel();
            promedioNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
            promedioNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            promedioNombre.setText("Promedio");
            promedioNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            GridBagConstraints gb = new java.awt.GridBagConstraints();
            gb.gridx = i.get();
            gb.gridy = 1;
            gb.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gb.ipadx = 10;
            gb.ipady = 10;
            pnlNotas.add(promedioNombre, gb);

            JTextField promedio = new JTextField();
            promedio.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));
            promedio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            promedio.setText(String.valueOf(r.getPromedio()));
            promedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = i.getAndIncrement();
            gridBagConstraints.gridy = 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.ipadx = 10;
            gridBagConstraints.ipady = 10;
            pnlNotas.add(promedio, gridBagConstraints);
        });
    }
    
}
