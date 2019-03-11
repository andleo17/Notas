
package com.andres.notas.controller;

import com.andres.notas.model.Matricula;
import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmMatriculaDetallada;
import com.andres.notas.view.FrmPrincipal;
import com.sun.java.swing.plaf.windows.WindowsSliderUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MatriculaDetallada implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmMatriculaDetallada frmMatriculaDetallada;
    private final Matricula matricula;
    private JLabel lblCurso;
    private JLabel lblProfesor;
    private JButton btnVolver;
    private JPanel pnlContenido;
    private JPanel pnlNotas;
    private ArrayList<Notas> notas;
    private JTextField promedioFinal;
    private JTextField promedioCampus;
    private JButton btnHallarNotas;
    private DecimalFormat df = new DecimalFormat("#.##");
    
    private class Notas {
        Rubrica rubrica;
        JSlider medidor;
        ArrayList<JTextField> txtNotas;
        
        public Notas(Rubrica rubrica, JSlider medidor) {
            this.rubrica = rubrica;
            this.medidor = medidor;
            txtNotas = new ArrayList<>();
        }
    }
    
    public MatriculaDetallada(Matricula matricula, FrmPrincipal frmPrincipal) {
        this.matricula = matricula;
        this.frmPrincipal = frmPrincipal;
        notas = new ArrayList<>();
        iniciar();
    }
    
    private void iniciar() {
        mostrar();
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        pnlNotas = (JPanel) getComponentByName("pnlNotas", frmMatriculaDetallada);
        lblCurso = (JLabel) getComponentByName("lblCurso", frmMatriculaDetallada);
        lblProfesor = (JLabel) getComponentByName("lblProfesor", frmMatriculaDetallada);
        
        btnVolver = (JButton) getComponentByName("btnVolver", frmMatriculaDetallada);
        btnVolver.addActionListener(evt -> volver());
        
        btnHallarNotas = (JButton) getComponentByName("btnHallarNotas", frmMatriculaDetallada);
        btnHallarNotas.addActionListener(evt -> hallarNotas());
        
        lblCurso.setText(matricula.getCurso().getNombre());
        lblProfesor.setText(matricula.getProfesor().getApellidos() + ", " + matricula.getProfesor().getNombre());
        
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
        
        Hashtable labelTable = new Hashtable();
        labelTable.put(100, new JLabel("    Muy importante"));
        labelTable.put(50, new JLabel("    Normal"));
        labelTable.put(0, new JLabel("    Meh"));
        
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
            
            JSlider medidor = new JSlider(JSlider.VERTICAL, 0, 100, 100);
                    medidor.setMajorTickSpacing(10);
                    medidor.setMinorTickSpacing(10);
                    medidor.setPaintTicks(true);
                    medidor.setPaintLabels(true);
                    medidor.setSnapToTicks(true);
                    medidor.setUI(new WindowsSliderUI(medidor));
                    medidor.setLabelTable(labelTable);
                    medidor.setFocusable(false);
                    
            posicion.gridy = 3;
            posicion.insets = new Insets(20, 0, 20, 0);
            
            pnlNotas.add(medidor, posicion);
            
            Notas notes = new Notas(r, medidor);
            
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
                posicion.insets = new Insets(0, 0, 0, 0);
                posicion.gridwidth = 1;
                
                pnlNotas.add(rubricaNombre, posicion);
                
                JTextField  nota = new JTextField();
                            nota.setBackground(fondoNota);
                            nota.setFont(fuenteNota);
                            nota.setHorizontalAlignment(SwingConstants.CENTER);
                            nota.setBorder(bordeNegro);
                if (n.getNota() != -1) nota.setText(String.valueOf(n.getNota()));
                nota.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent de) {
                        hallarPromedio(nota);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent de) {
                        hallarPromedio(nota);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent de) {
                        hallarPromedio(nota);
                    }
                });
                
                posicion.gridx = i.getAndIncrement();
                posicion.gridy = 2;
                
                pnlNotas.add(nota, posicion);
                
                notes.txtNotas.add(nota);
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

            JTextField  promedio = new JTextField(df.format(r.getPromedio()));
                        promedio.setBackground(fondoPromedio);
                        promedio.setFont(fuentePromedio);
                        promedio.setHorizontalAlignment(SwingConstants.CENTER);
                        promedio.setBorder(bordeNegro);
                        promedio.getDocument().addDocumentListener(new DocumentListener() {
                            @Override
                            public void insertUpdate(DocumentEvent de) {
                                hallarPromedioFinal();
                            }

                            @Override
                            public void removeUpdate(DocumentEvent de) {
                                hallarPromedioFinal();
                            }

                            @Override
                            public void changedUpdate(DocumentEvent de) {
                                hallarPromedioFinal();
                            }
                        });
            
            posicion.gridx = i.getAndIncrement();
            posicion.gridy = 2;
            
            pnlNotas.add(promedio, posicion);
            
            notes.txtNotas.add(promedio);
            notas.add(notes);
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

        promedioFinal = new JTextField(df.format(matricula.getPromedioFinal()));
        promedioFinal.setBackground(fondoPromedioFinal);
        promedioFinal.setFont(fuentePromedioFinal);
        promedioFinal.setHorizontalAlignment(SwingConstants.CENTER);
        promedioFinal.setBorder(bordeNegro);
        promedioFinal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                hallarPromedioCampus();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                hallarPromedioCampus();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                hallarPromedioCampus();
            }
        });

        posicion.gridx = i.getAndIncrement();
        posicion.gridy = 2;
        posicion.gridheight = 1;
        posicion.fill = GridBagConstraints.HORIZONTAL;

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

        promedioCampus = new JTextField(String.valueOf(Math.round(matricula.getPromedioFinal())));
        promedioCampus.setBackground(fondoPromedioCampus);
        promedioCampus.setFont(fuentePromedioCampus);
        promedioCampus.setHorizontalAlignment(SwingConstants.CENTER);
        promedioCampus.setBorder(bordeNegro);

        posicion.gridx = i.get();
        posicion.gridy = 2;
        posicion.gridheight = 1;
        posicion.fill = GridBagConstraints.HORIZONTAL;

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
    
    private void hallarPromedio(JTextField txt) {
        Notas nota = null;
        float suma = 0;
        int i = 0;
        for (Notas n : notas) for (JTextField t : n.txtNotas) if (t == txt) nota = n;
        for (i = 0; i < nota.txtNotas.size() - 1; i++) {
            JTextField t = nota.txtNotas.get(i);
            float numero = (t.getText().isEmpty()) ? 0 : convertir(t.getText());
            suma = suma + numero;
        }
        nota.txtNotas.get(nota.txtNotas.size() -1).setText(df.format(suma / i));
    }
    
    private void hallarPromedioFinal() {
        float suma = 0;
        for (Notas n : notas) {
            float numero = (n.txtNotas.get(n.txtNotas.size() - 1).getText().isEmpty()) ? 0 : convertir(n.txtNotas.get(n.txtNotas.size() - 1).getText());
            suma = suma + n.rubrica.getPeso() * numero;
        }
        promedioFinal.setText(df.format(suma));
    }
    
    private void hallarPromedioCampus() {
        float numero = promedioFinal.getText().isEmpty() ? 0 : convertir(promedioFinal.getText());
        promedioCampus.setText(String.valueOf(Math.round(numero)));
    }
    
    private float convertir(String str) {
        float numero;
        try {
            numero = df.parse(str).floatValue();
        } catch (ParseException e) {
            numero = -1;
        }
        return numero;
    }
    
    private void hallarNotas() {
        float promedioEsperado = (promedioCampus.getText().isEmpty()) ? 0 : convertir(promedioCampus.getText());
        ArrayList<Notas> filtro = new ArrayList<>();
        notas.forEach(n -> {
            Notas nota = new Notas(n.rubrica, n.medidor);
            for (int i = 0; i < n.txtNotas.size() - 1; i++) {
                JTextField t = n.txtNotas.get(i);
                if (n.rubrica.getNotas().get(i).getNota() == -1) nota.txtNotas.add(t);
            }
            filtro.add(nota);
        });
        filtro.sort((f, f1) -> {
            Integer valorA = f.medidor.getValue();
            Integer valorB = f1.medidor.getValue();
            return valorB.compareTo(valorA);
        });
        float promedios[][] = new float[filtro.size()][2];
        int total = 0;
        for (int i = 0; i < filtro.size(); i++) {
            total = total + filtro.get(i).medidor.getValue();
        }
        for (int i = 0; i < filtro.size(); i++) {
            promedios[i][0] = (filtro.get(i).medidor.getValue() * promedioEsperado) / (total * filtro.get(i).rubrica.getPeso());
            promedios[i][1] = filtro.get(i).rubrica.getPeso();
        }
        float pF = 0;
        for (float p[] : promedios) {
            if(p[0] > 20){
                p[0] = 20;
            }
            pF = pF + p[0] * p[1];
        }
        if (pF != promedioEsperado) {
            for (float p[] : promedios) {
                while (Math.round(pF) != promedioEsperado) {
                    if(p[0] < 20){
                        p[0] = p[0] + 0.01F;
                    }
                    pF = 0;
                    for (float p1[] : promedios) pF = pF + p1[0] * p1[1];
                }
            }
        }
        AtomicInteger i = new AtomicInteger(0);
        filtro.forEach(f -> {
            float promedioNota = promedios[i.getAndIncrement()][0] * f.rubrica.getNotas().size();
            int sinNota = 0;
            for (Nota n: f.rubrica.getNotas()) {
                if (n.getNota() != -1) promedioNota = promedioNota - n.getNota();
                else sinNota++;
            }
            promedioNota = promedioNota / sinNota;
            for (JTextField t : f.txtNotas) t.setText(df.format(promedioNota));
        });
    }
    
}
