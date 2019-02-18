
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmLogin;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Login implements IMapeable{

    private FrmLogin frmLogin;
    private Estudiante estudiante;
    
    public void iniciar() {
        frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        frmLogin.setTitle("Bienvenido");
        
        JButton btnIngresar = (JButton) getComponentByName("btnIngresar", frmLogin);
        btnIngresar.addActionListener(evt -> {
            iniciarSesion();
        });
        
        JButton btnRegistro = (JButton) getComponentByName("btnRegistro", frmLogin);
        btnRegistro.addActionListener(evt -> {
            registrar();
        });
        
        JButton btnCambiarPassword = (JButton) getComponentByName("btnCambiarPassword", frmLogin);
        btnCambiarPassword.addActionListener(evt -> {
            actualizar();
        });
    }
    
    private void iniciarSesion() {
        estudiante = new Estudiante();
        JTextField txtEmail = (JTextField) getComponentByName("txtEmail", frmLogin);
        JTextField txtPassword = (JTextField) getComponentByName("txtPassword", frmLogin);
        
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        
        estudiante = estudiante.iniciarSesion(email, password);
        if (estudiante != null) {
            new Principal(estudiante).iniciar();
        }else {
            System.err.println("Ingreso incorrecto");
        }
    }
    
    private void registrar() {
        new Registro().iniciar();
    }
    
    private void actualizar() {
        new CambiarPassword().iniciar();
    }
    
}
