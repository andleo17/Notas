
package com.andres.notas.controller;

import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmMatriculaDetallada;
import com.andres.notas.view.FrmPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MatriculaDetallada implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmMatriculaDetallada frmMatriculaDetallada;
    private final Matricula matricula;
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
        mostrar();
        
        pnlNotas = (JPanel) getComponentByName("pnlNotas", frmMatriculaDetallada);
        lblCurso = (JLabel) getComponentByName("lblCurso", frmMatriculaDetallada);
        lblProfesor = (JLabel) getComponentByName("lblProfesor", frmMatriculaDetallada);
        
        btnVolver = (JButton) getComponentByName("btnVolver", frmMatriculaDetallada);
        btnVolver.addActionListener(evt -> volver());
        
        lblCurso.setText(matricula.getCurso().getNombre());
        lblProfesor.setText(matricula.getProfesor().getNombre());
        
        mostrarNotas();
    }
    
    private void volver() {
        Matriculas matriculas = new Matriculas(frmPrincipal, matricula.getEstudiante(), matricula.getCiclo());
        JPanel frm = matriculas.iniciar();
        pnlContenido.removeAll();
        pnlContenido.add(frm);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    private void mostrarNotas(){
        AtomicInteger i = new AtomicInteger(0);
        Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK);
        
        Color fondoRubrica = Color.WHITE;
        Font fuenteRubrica = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoRubricaNombre = Color.WHITE;
        Font fuenteRubricaNombre = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoNota = Color.WHITE;
        Font fuenteNota = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoPromedioNombre = Color.WHITE;
        Font fuentePromedioNombre = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoPromedio = Color.WHITE;
        Font fuentePromedio = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoPromedioFinalNombre = Color.WHITE;
        Font fuentePromedioFinalNombre = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoPromedioFinal = Color.WHITE;
        Font fuentePromedioFinal = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoPromedioCampusNombre = Color.WHITE;
        Font fuentePromedioCampusNombre = new Font("Microsoft Sans Serif", 0, 14);
        
        Color fondoPromedioCampus = Color.WHITE;
        Font fuentePromedioCampus = new Font("Microsoft Sans Serif", 0, 14);
        
        GridBagConstraints posicion = new GridBagConstraints(
        /* gridX */         0,
        /* gridY */         0,
        /* gridWidth */     1,
        /* gridHeight */    1,
        /* weightX */       1,
        /* weightY */       0,
        /* anchor */        GridBagConstraints.CENTER,
        /* fill */          GridBagConstraints.HORIZONTAL,
        /* insets */        new Insets(0, 0, 0, 0),
        /* ipadX */         10,
        /* ipadY */         10
        );
        
        matricula.getRubricas().forEach(r -> {
            JLabel  rubrica = new JLabel(r.getNombre());
                    rubrica.setBackground(fondoRubrica);
                    rubrica.setFont(fuenteRubrica);
                    rubrica.setHorizontalAlignment(SwingConstants.CENTER);
                    rubrica.setBorder(bordeNegro);
                    rubrica.setOpaque(true);
            
            posicion.gridx = i.get();
            posicion.gridy = 0;
            posicion.gridwidth = r.getNotas().size() + 1;
            
            pnlNotas.add(rubrica, posicion);
            
            String siglas = obtenerSiglas(r.getNombre());
            
            r.getNotas().forEach(n -> {
                JLabel  rubricaNombre = new JLabel(siglas + n.getNumeroNota());
                        rubricaNombre.setBackground(fondoRubricaNombre);
                        rubricaNombre.setFont(fuenteRubricaNombre);
                        rubricaNombre.setHorizontalAlignment(SwingConstants.CENTER);
                        rubricaNombre.setBorder(bordeNegro);
                        rubricaNombre.setOpaque(true);
                
                posicion.gridx = i.get();
                posicion.gridy = 1;
                posicion.gridwidth = 1;
                
                pnlNotas.add(rubricaNombre, posicion);
                
                JTextField  nota = new JTextField();
                            nota.setBackground(fondoNota);
                            nota.setFont(fuenteNota);
                            nota.setHorizontalAlignment(SwingConstants.CENTER);
                            nota.setBorder(bordeNegro);
                if (n.getNota() != -1) nota.setText(String.valueOf(n.getNota()));
                
                posicion.gridx = i.getAndIncrement();
                posicion.gridy = 2;
                
                pnlNotas.add(nota, posicion);
            });
            
            JLabel  promedioNombre = new JLabel("Promedio");
                    promedioNombre.setBackground(fondoPromedioNombre);
                    promedioNombre.setFont(fuentePromedioNombre);
                    promedioNombre.setHorizontalAlignment(SwingConstants.CENTER);
                    promedioNombre.setBorder(bordeNegro);
                    promedioNombre.setOpaque(true);
            
            posicion.gridx = i.get();
            posicion.gridy = 1;
            
            pnlNotas.add(promedioNombre, posicion);

            JTextField  promedio = new JTextField(String.valueOf(r.getPromedio()));
                        promedio.setBackground(fondoPromedio);
                        promedio.setFont(fuentePromedio);
                        promedio.setHorizontalAlignment(SwingConstants.CENTER);
                        promedio.setBorder(bordeNegro);
            
            posicion.gridx = i.getAndIncrement();
            posicion.gridy = 2;
            
            pnlNotas.add(promedio, posicion);
        });
        
        JLabel  promedioFinalNombre = new JLabel("<html><body><center>Promedio<br>Final</center></body></html>");
                promedioFinalNombre.setBackground(fondoPromedioFinalNombre);
                promedioFinalNombre.setFont(fuentePromedioFinalNombre);
                promedioFinalNombre.setHorizontalAlignment(SwingConstants.CENTER);
                promedioFinalNombre.setBorder(bordeNegro);
                promedioFinalNombre.setOpaque(true);
            
        posicion.gridx = i.get();
        posicion.gridy = 0;
        posicion.gridheight = 2;
        posicion.fill = GridBagConstraints.BOTH;

        pnlNotas.add(promedioFinalNombre, posicion);

        JTextField  promedioFinal = new JTextField(String.valueOf(matricula.getPromedioFinal()));
                    promedioFinal.setBackground(fondoPromedioFinal);
                    promedioFinal.setFont(fuentePromedioFinal);
                    promedioFinal.setHorizontalAlignment(SwingConstants.CENTER);
                    promedioFinal.setBorder(bordeNegro);

        posicion.gridx = i.getAndIncrement();
        posicion.gridy = 2;

        pnlNotas.add(promedioFinal, posicion);
        
        JLabel  promedioCampusNombre = new JLabel("<html><body><center>Promedio<br>Campus</center></body></html>");
                promedioCampusNombre.setBackground(fondoPromedioCampusNombre);
                promedioCampusNombre.setFont(fuentePromedioCampusNombre);
                promedioCampusNombre.setHorizontalAlignment(SwingConstants.CENTER);
                promedioCampusNombre.setBorder(bordeNegro);
                promedioCampusNombre.setOpaque(true);
            
        posicion.gridx = i.get();
        posicion.gridy = 0;
        posicion.gridheight = 2;
        posicion.fill = GridBagConstraints.BOTH;

        pnlNotas.add(promedioCampusNombre, posicion);

        JTextField  promedioCampus = new JTextField(String.valueOf(Math.round(matricula.getPromedioFinal())));
                    promedioCampus.setBackground(fondoPromedioCampus);
                    promedioCampus.setFont(fuentePromedioCampus);
                    promedioCampus.setHorizontalAlignment(SwingConstants.CENTER);
                    promedioCampus.setBorder(bordeNegro);

        posicion.gridx = i.get();
        posicion.gridy = 2;

        pnlNotas.add(promedioCampus, posicion);
        
    }
    
    private void mostrar() {
        frmMatriculaDetallada = new FrmMatriculaDetallada();
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmPrincipal);
        pnlContenido.removeAll();
        pnlContenido.add(frmMatriculaDetallada);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    
    private String obtenerSiglas(String nombre) {
        StringBuilder p = new StringBuilder();
        for (String s : nombre.split(" ")) p.append(s.charAt(0));
        return p.toString();
    }
    
}
