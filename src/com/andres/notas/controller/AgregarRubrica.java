
package com.andres.notas.controller;

import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import com.andres.notas.view.FrmAgregarRubrica;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AgregarRubrica implements IMapeable{
    
    private final FrmAgregarMatricula frmAgregarMatricula;
    private Rubrica rubrica;
    private FrmAgregarRubrica frmAgregarRubrica;
    private JButton btnAgregar;
    private JTextField txtNombre;
    private JTextField txtPeso;
    private JTextField txtNumeroNotas;
    
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
        txtPeso = (JTextField) getComponentByName("txtPeso", frmAgregarRubrica);
        txtNumeroNotas = (JTextField) getComponentByName("txtNumeroNotas", frmAgregarRubrica);
        
        if (rubrica == null) {
            rubrica = new Rubrica();
            frmAgregarRubrica.setTitle("Agregar Rúbrica");
            btnAgregar.addActionListener(evt -> agregar());
        } else {
            frmAgregarRubrica.setTitle("Modificar Rúbrica");
            btnAgregar.setText("Modificar");
            btnAgregar.addActionListener(evt -> modificar());
            txtNombre.setText(rubrica.getNombre());
            txtPeso.setText(String.valueOf(rubrica.getPeso() * 100));
            txtNumeroNotas.setText(String.valueOf(rubrica.getNotas().size()));
        }
        
        frmAgregarRubrica.setModal(true);
        frmAgregarRubrica.setVisible(false);
        frmAgregarRubrica.setVisible(true);
    }
    
    private void obtenerDatos() {
        rubrica.setNombre(txtNombre.getText());
        rubrica.setPeso(Float.valueOf(txtPeso.getText()) / 100);
    }
    
    private void agregar() {
        ArrayList<Nota> notas = new ArrayList<>();
        for (int i = 1; i <= Integer.valueOf(txtNumeroNotas.getText()); i++) {
            Nota nota = new Nota();
            nota.setNumeroNota(i);
            notas.add(nota);
        }
        obtenerDatos();
        rubrica.setNotas(notas);
        frmAgregarRubrica.dispose();
    }
    
    private void modificar() {
        obtenerDatos();
        rubrica.actualizar();
        frmAgregarRubrica.dispose();
    }
    
    public Rubrica getRubrica() {
        return rubrica;
    }
    
}
