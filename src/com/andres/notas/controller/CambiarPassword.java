
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmCambiarPassword;
import com.andres.notas.view.FrmLogin;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CambiarPassword implements IMapeable{
    
    private final FrmLogin frmLogin;
    private FrmCambiarPassword frmCambiarPassword;
    private JButton btnCambiar;
    private JTextField txtEmail;
    private JTextField txtPasswordActual;
    private JTextField txtPasswordNueva;
    private JTextField txtPasswordRepetido;
    
    public CambiarPassword(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        iniciar();
    }
    
    private void iniciar() {
        frmCambiarPassword = new FrmCambiarPassword(frmLogin, false);
        frmCambiarPassword.setVisible(true);
        frmCambiarPassword.setTitle("Cambiar contraseña");
        frmCambiarPassword.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frmCambiarPassword.setLocationRelativeTo(null);
        
        btnCambiar = (JButton) getComponentByName("btnCambiar", frmCambiarPassword);
        btnCambiar.addActionListener(evt -> actualizar());
        
        txtEmail = (JTextField) getComponentByName("txtEmail", frmCambiarPassword);
        txtPasswordActual = (JTextField) getComponentByName("txtPasswordActual", frmCambiarPassword);
        txtPasswordNueva = (JTextField) getComponentByName("txtPasswordNueva", frmCambiarPassword);
        txtPasswordRepetido = (JTextField) getComponentByName("txtPasswordRepetido", frmCambiarPassword);
        
        frmCambiarPassword.setModal(true);
        frmCambiarPassword.setVisible(false);
        frmCambiarPassword.setVisible(true);
    }
    
    private void actualizar() {
        Estudiante estudiante = new Estudiante();
        Estudiante e = estudiante.iniciarSesion(txtEmail.getText(), txtPasswordActual.getText());
        e.setPassword(txtPasswordNueva.getText());
        e.actualizar();
        frmCambiarPassword.dispose();
    }
    
}
