
package com.andres.notas.controller;

import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarRubrica;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AgregarRubrica implements IMapeable{
    
    private FrmAgregarRubrica frmAgregarRubrica;
    private Rubrica rubrica;
    
    public void iniciar(javax.swing.JFrame frame) {
        frmAgregarRubrica = new FrmAgregarRubrica(frame, false);
        frmAgregarRubrica.setTitle("Agregar Rúbrica");
        frmAgregarRubrica.setLocationRelativeTo(null);
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarRubrica);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarRubrica.setModal(true);
        frmAgregarRubrica.setVisible(false);
        frmAgregarRubrica.setVisible(true);
    }
    
    //Falta implementar esto
    private void agregar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarRubrica);
        JTextField txtNumeroNotas = (JTextField) getComponentByName("txtNumeroNotas", frmAgregarRubrica);
        JTextField txtPeso = (JTextField) getComponentByName("txtPeso", frmAgregarRubrica);
        
        rubrica = new Rubrica();
        rubrica.setNombre(txtNombre.getText());
        rubrica.setPeso(Float.valueOf(txtPeso.getText()) / 100);
    }
    
    public Rubrica getRubrica() {
        return rubrica;
    }
    
}
