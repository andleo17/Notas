
package com.andres.notas.controller;

import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import com.andres.notas.view.FrmAgregarRubrica;
import java.awt.Dialog;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgregarRubrica implements IMapeable{
    
    private final FrmAgregarMatricula frmAgregarMatricula;
    private Rubrica rubrica;
    private FrmAgregarRubrica frmAgregarRubrica;
    private JButton btnAgregar;
    private JTextField txtNombre;
    private JFormattedTextField txtPeso;
    private JFormattedTextField txtNumeroNotas;
    
    public AgregarRubrica(FrmAgregarMatricula frmAgregarMatricula) {
        this.frmAgregarMatricula = frmAgregarMatricula;
        iniciar();
    }
    
    public AgregarRubrica(FrmAgregarMatricula frmAgregarMatricula, Rubrica rubrica) {
        this.frmAgregarMatricula = frmAgregarMatricula;
        this.rubrica = rubrica;
        iniciar();
    }
    
    private void iniciar() {
        frmAgregarRubrica = new FrmAgregarRubrica(frmAgregarMatricula, Dialog.ModalityType.MODELESS);
        frmAgregarRubrica.setLocationRelativeTo(null);
        frmAgregarRubrica.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarRubrica);
        txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarRubrica);
        txtPeso = (JFormattedTextField) getComponentByName("txtPeso", frmAgregarRubrica);
        txtNumeroNotas = (JFormattedTextField) getComponentByName("txtNumeroNotas", frmAgregarRubrica);
        
        if (rubrica == null) {
            frmAgregarRubrica.setTitle("Agregar Rúbrica");
            btnAgregar.addActionListener(evt -> agregar());
        } else {
            frmAgregarRubrica.setTitle("Modificar Rúbrica");
            btnAgregar.setText("Modificar");
            btnAgregar.addActionListener(evt -> modificar());
            txtNombre.setText(rubrica.getNombre());
            txtPeso.setText(String.valueOf(rubrica.getPeso() * 10 * 10));
            txtNumeroNotas.setText(String.valueOf(rubrica.getNotas().size()));
        }
        
        frmAgregarRubrica.setModal(true);
        frmAgregarRubrica.setVisible(false);
        frmAgregarRubrica.setVisible(true);
    }
    
    private void obtenerDatos() {
        rubrica.setNombre(txtNombre.getText());
        rubrica.setPeso(Float.valueOf(txtPeso.getText()) / 100F);
    }
    
    private void agregar() {
        if (!txtNombre.getText().isEmpty() && Integer.valueOf(txtPeso.getText()) > 0 && Integer.valueOf(txtPeso.getText()) < 100 && Integer.valueOf(txtNumeroNotas.getText()) > 0) {
            rubrica = new Rubrica();
            ArrayList<Nota> notas = new ArrayList<>();
            for (int i = 1; i <= Integer.valueOf(txtNumeroNotas.getText()); i++) {
                Nota nota = new Nota();
                nota.setRubrica(rubrica);
                nota.setNumeroNota(i);
                notas.add(nota);
            }
            obtenerDatos();
            rubrica.setNotas(notas);
            frmAgregarRubrica.dispose();
        } else {
            JOptionPane.showMessageDialog(frmAgregarRubrica, "Ingrese correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificar() {
        if (!txtNombre.getText().isEmpty() && Float.valueOf(txtPeso.getText()) > 0 && Float.valueOf(txtPeso.getText()) < 100 && Integer.valueOf(txtNumeroNotas.getText()) > 0) {
            if (rubrica.getNotas().size() != Integer.valueOf(txtNumeroNotas.getText())) {
                if (rubrica.getNotas().size() > Integer.valueOf(txtNumeroNotas.getText())) {
                    List<Nota> notas = rubrica.getNotas().stream().filter(n -> n.getNota() == -1).collect(Collectors.toList());
                    if (notas.size() >= Integer.valueOf(txtNumeroNotas.getText())) {
                        while (rubrica.getNotas().size() > Integer.valueOf(txtNumeroNotas.getText())) {
                            rubrica.getNotas().remove(notas.get(notas.size() - 1));
                            notas.remove(notas.size() - 1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frmAgregarRubrica, "No se pueden eliminar notas completas", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    for (int i = 0; i < Integer.valueOf(txtNumeroNotas.getText()) - rubrica.getNotas().size(); i++) {
                        Nota nota = new Nota();
                        nota.setRubrica(rubrica);
                        rubrica.getNotas().add(nota);
                    }
                }
                for (int i = 1; i <= rubrica.getNotas().size(); i++) {
                    rubrica.getNotas().get(i - 1).setNumeroNota(i);
                }
            }
            obtenerDatos();
            frmAgregarRubrica.dispose();
        } else JOptionPane.showMessageDialog(frmAgregarRubrica, "Ingrese correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public Rubrica getRubrica() {
        return rubrica;
    }
    
}
