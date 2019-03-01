
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmLogin;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login implements IMapeable{

    private FrmLogin frmLogin;
    private JButton btnIngresar;
    private JButton btnRegistro;
    private JButton btnCambiarPassword;
    private JTextField txtEmail;
    private JTextField txtPassword;
    
    public void iniciar() {
        frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        frmLogin.setTitle("Bienvenido");
        frmLogin.setResizable(false);
        frmLogin.setLocationRelativeTo(null);
        
        btnIngresar = (JButton) getComponentByName("btnIngresar", frmLogin);
        btnIngresar.addActionListener(evt -> iniciarSesion());
        
        btnRegistro = (JButton) getComponentByName("btnRegistro", frmLogin);
        btnRegistro.addActionListener(evt -> registrar());
        
        btnCambiarPassword = (JButton) getComponentByName("btnCambiarPassword", frmLogin);
        btnCambiarPassword.addActionListener(evt -> actualizar());
        
        txtEmail = (JTextField) getComponentByName("txtEmail", frmLogin);
        txtPassword = (JTextField) getComponentByName("txtPassword", frmLogin);
    }
    
    private void iniciarSesion() {
        Estudiante estudiante = Estudiante.iniciarSesion(txtEmail.getText(), txtPassword.getText());
        if (estudiante != null) {
            frmLogin.dispose();
            new Principal(estudiante).iniciar();
        } else JOptionPane.showMessageDialog(frmLogin, "Email y/o contraseña incorrectos", "Login incorrecto", JOptionPane.ERROR_MESSAGE);
    }
    
    private void registrar() {
        new Registro(frmLogin);
    }
    
    private void actualizar() {
        new CambiarPassword(frmLogin);
    }
    
}
