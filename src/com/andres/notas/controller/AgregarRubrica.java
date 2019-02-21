
package com.andres.notas.controller;

import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarRubrica;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AgregarRubrica implements IMapeable{
    
    private FrmAgregarRubrica frmAgregarRubrica;
    private Rubrica rubrica;
    
    public void iniciar(java.awt.Window frame) {
        frmAgregarRubrica = new FrmAgregarRubrica(frame, Dialog.ModalityType.MODELESS);
        frmAgregarRubrica.setTitle("Agregar Rúbrica");
        frmAgregarRubrica.setLocationRelativeTo(null);
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarRubrica);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarRubrica.setModal(true);
        frmAgregarRubrica.setVisible(false);
        frmAgregarRubrica.setVisible(true);
    }
    
    public void iniciar(java.awt.Window frame, Rubrica rubrica) {
        this.rubrica = rubrica;
        
        frmAgregarRubrica = new FrmAgregarRubrica(frame, Dialog.ModalityType.MODELESS);
        frmAgregarRubrica.setTitle("Modificar Rúbrica");
        frmAgregarRubrica.setLocationRelativeTo(null);
        
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
        
        int numeroNotas = Integer.valueOf(txtNumeroNotas.getText());
        ArrayList<Nota> notas = new ArrayList<>();
        
        for (int i = 1; i <= numeroNotas; i++) {
            Nota nota = new Nota();
            nota.setNumeroNota(i);
            notas.add(nota);
        }
        
        rubrica = new Rubrica();
        rubrica.setNombre(txtNombre.getText());
        rubrica.setPeso(Float.valueOf(txtPeso.getText()) / 100);
        rubrica.setNotas(notas);
        
        frmAgregarRubrica.dispose();
    }
    
    private void modificar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarRubrica);
        JTextField txtPeso = (JTextField) getComponentByName("txtPeso", frmAgregarRubrica);
        
        rubrica.setNombre(txtNombre.getText());
        rubrica.setPeso(Float.valueOf(txtPeso.getText()) / 100);
        
        frmAgregarRubrica.dispose();
    }
    
    public Rubrica getRubrica() {
        return rubrica;
    }
    
}
