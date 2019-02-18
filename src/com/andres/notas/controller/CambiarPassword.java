
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmCambiarPassword;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CambiarPassword implements IMapeable{
    
    FrmCambiarPassword frmCambiarPassword;
    
    public void iniciar() {
        frmCambiarPassword = new FrmCambiarPassword();
        frmCambiarPassword.setVisible(true);
        frmCambiarPassword.setTitle("Cambiar contraseña");
        
        JButton btnCambiar = (JButton) getComponentByName("btnCambiar", frmCambiarPassword);
        btnCambiar.addActionListener(evt -> {
            actualizar();
        });
    }
    
    private void actualizar() {
        JTextField txtEmail = (JTextField) getComponentByName("txtEmail", frmCambiarPassword);
        JTextField txtPasswordActual = (JTextField) getComponentByName("txtPasswordActual", frmCambiarPassword);
        JTextField txtPasswordNueva = (JTextField) getComponentByName("txtPasswordNueva", frmCambiarPassword);
        JTextField txtPasswordRepetido = (JTextField) getComponentByName("txtPasswordRepetido", frmCambiarPassword);
        
        Estudiante estudiante = new Estudiante();
        Estudiante e = estudiante.iniciarSesion(txtEmail.getText(), txtPasswordActual.getText());
        e.setPassword(txtPasswordNueva.getText());
        e.actualizar();
        frmCambiarPassword.dispose();
    }
    
}
