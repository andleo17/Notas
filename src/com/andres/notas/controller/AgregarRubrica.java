
package com.andres.notas.controller;

import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import com.andres.notas.view.FrmAgregarRubrica;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgregarRubrica implements IMapeable{
    
    private final FrmAgregarMatricula frmAgregarMatricula;
    private FrmAgregarRubrica frmAgregarRubrica;
    private Rubrica rubrica;
    
    public AgregarRubrica(FrmAgregarMatricula frmAgregarMatricula) {
        this.frmAgregarMatricula = frmAgregarMatricula;
        iniciar();
    }
    
    public AgregarRubrica(FrmAgregarMatricula frmAgregarMatricula, Rubrica rubrica) {
        this.frmAgregarMatricula = frmAgregarMatricula;
        iniciar(rubrica);
    }
    
    private void iniciar() {
        frmAgregarRubrica = new FrmAgregarRubrica(frmAgregarMatricula, Dialog.ModalityType.MODELESS);
        frmAgregarRubrica.setTitle("Agregar Rúbrica");
        frmAgregarRubrica.setLocationRelativeTo(null);
        frmAgregarRubrica.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmAgregarRubrica.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                agregar();
            }
        });
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarRubrica);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarRubrica.setModal(true);
        frmAgregarRubrica.setVisible(false);
        frmAgregarRubrica.setVisible(true);
    }
    
    private void iniciar(Rubrica rubrica) {
        this.rubrica = rubrica;
        
        frmAgregarRubrica = new FrmAgregarRubrica(frmAgregarMatricula, Dialog.ModalityType.MODELESS);
        frmAgregarRubrica.setTitle("Modificar Rúbrica");
        frmAgregarRubrica.setLocationRelativeTo(null);
        frmAgregarRubrica.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmAgregarRubrica.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                agregar();
            }
        });
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarRubrica);
        btnAgregar.setText("Modificar");
        btnAgregar.addActionListener(evt -> modificar());
        
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarRubrica);
        txtNombre.setText(rubrica.getNombre());
        
        JTextField txtPeso = (JTextField) getComponentByName("txtPeso", frmAgregarRubrica);
        txtPeso.setText(String.valueOf(rubrica.getPeso() * 100));
        
        JTextField txtNumeroNotas = (JTextField) getComponentByName("txtNumeroNotas", frmAgregarRubrica);
        txtNumeroNotas.setText(String.valueOf(rubrica.getNotas().size()));
        
        frmAgregarRubrica.setModal(true);
        frmAgregarRubrica.setVisible(false);
        frmAgregarRubrica.setVisible(true);
    }
    
    private void agregar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarRubrica);
        JTextField txtNumeroNotas = (JTextField) getComponentByName("txtNumeroNotas", frmAgregarRubrica);
        JTextField txtPeso = (JTextField) getComponentByName("txtPeso", frmAgregarRubrica);

        String nombre = txtNombre.getText();
        String p = txtPeso.getText();
        String n = txtNumeroNotas.getText();
        
        if (!nombre.isEmpty() || !p.isEmpty() || !n.isEmpty()) {
            if (!nombre.isEmpty() && !p.isEmpty() && !n.isEmpty()) {
                try {
                    Float peso = Float.valueOf(p) / 100;
                    int numeroNotas = Integer.valueOf(n);
                    ArrayList<Nota> notas = new ArrayList<>();

                    for (int i = 1; i <= numeroNotas; i++) {
                        Nota nota = new Nota();
                        nota.setNumeroNota(i);
                        notas.add(nota);
                    }

                    rubrica = new Rubrica();
                    rubrica.setNombre(nombre);
                    rubrica.setPeso(peso);
                    rubrica.setNotas(notas);

                    frmAgregarRubrica.dispose();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frmAgregarRubrica, "Ingrese correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frmAgregarRubrica, "Faltan datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(frmAgregarRubrica, "¿Seguro que no quiere registrar una rúbrica?", "Mensaje", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) frmAgregarRubrica.dispose();
        }
    }
    
    private void modificar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarRubrica);
        JTextField txtPeso = (JTextField) getComponentByName("txtPeso", frmAgregarRubrica);
        
        String nombre = txtNombre.getText();
        String p = txtPeso.getText();
        
        if (!nombre.isEmpty() && !p.isEmpty()) {
            try {
                rubrica.setNombre(nombre);
                rubrica.setPeso(Float.valueOf(p) / 100);

                frmAgregarRubrica.dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frmAgregarRubrica, "Ingrese correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frmAgregarRubrica, "Faltan datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public Rubrica getRubrica() {
        return rubrica;
    }
    
}
