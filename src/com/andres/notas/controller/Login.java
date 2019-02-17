
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmLogin;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Login {

    private FrmLogin frmLogin;
    private Estudiante estudiante;
    
    public void iniciar() {
        frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        frmLogin.setTitle("Bienvenido");
        
        JButton btnIngresar = (JButton) frmLogin.getComponentByName("btnIngresar");
        btnIngresar.addActionListener(evt -> {
            iniciarSesion();
            iniciarSesionOK();
        });
    }
    
    public void iniciarSesion() {
        estudiante = new Estudiante();
        JTextField txtEmail = (JTextField) frmLogin.getComponentByName("txtEmail");
        JTextField txtPassword = (JTextField) frmLogin.getComponentByName("txtPassword");
        
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        
        estudiante = estudiante.iniciarSesion(email, password);
    }
    
    public void iniciarSesionOK() {
        if (estudiante != null) {
            System.out.println("Ingreso correcto");
        }else {
            System.err.println("Ingreso incorrecto");
        }
    }
    
}
