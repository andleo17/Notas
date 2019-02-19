
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmRegistro;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Registro implements IMapeable{
    
    FrmRegistro frmRegistro;
    
    public void iniciar() {
        frmRegistro = new FrmRegistro();
        frmRegistro.setVisible(true);
        frmRegistro.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frmRegistro.setLocationRelativeTo(null);
        
        JButton btnRegistro = (JButton) getComponentByName("btnRegistro", frmRegistro);
        btnRegistro.addActionListener(evt -> {
            registrar();
        });
    }
    
    private void registrar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmRegistro);
        JTextField txtApellidos = (JTextField) getComponentByName("txtApellidos", frmRegistro);
        JTextField txtEmail = (JTextField) getComponentByName("txtEmail", frmRegistro);
        JTextField txtPassword = (JTextField) getComponentByName("txtPassword", frmRegistro);
        
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellidos(txtApellidos.getText());
        estudiante.setEmail(txtEmail.getText());
        estudiante.setPassword(txtPassword.getText());
        estudiante.agregar();
        frmRegistro.dispose();
    }
    
}
