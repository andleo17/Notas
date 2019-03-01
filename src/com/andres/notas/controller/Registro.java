
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmLogin;
import com.andres.notas.view.FrmRegistro;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Registro implements IMapeable{
    
    private final FrmLogin frmLogin;
    private FrmRegistro frmRegistro;
    private JButton btnRegistro;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JTextField txtConfirmPassword;
    
    public Registro(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        iniciar();
    }
    
    private void iniciar() {
        frmRegistro = new FrmRegistro(frmLogin, false);
        frmRegistro.setVisible(true);
        frmRegistro.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frmRegistro.setLocationRelativeTo(null);
        
        btnRegistro = (JButton) getComponentByName("btnRegistro", frmRegistro);
        btnRegistro.addActionListener(evt -> registrar());
        
        txtNombre = (JTextField) getComponentByName("txtNombre", frmRegistro);
        txtEmail = (JTextField) getComponentByName("txtEmail", frmRegistro);
        txtApellidos = (JTextField) getComponentByName("txtApellidos", frmRegistro);
        txtPassword = (JTextField) getComponentByName("txtPassword", frmRegistro);
        txtConfirmPassword = (JTextField) getComponentByName("txtConfirmPassword", frmRegistro);
        txtConfirmPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String password = txtPassword.getText();
                String cPassword = txtConfirmPassword.getText();
                
                JSeparator sprPassword = (JSeparator) getComponentByName("sprPassword", frmRegistro);
                JSeparator sprConfirmPassword = (JSeparator) getComponentByName("sprConfirmPassword", frmRegistro);
                
                if(password.equals(cPassword)){
                    sprPassword.setForeground(Color.green);
                    sprConfirmPassword.setForeground(Color.green);
                }else {
                    sprPassword.setForeground(Color.red);
                    sprConfirmPassword.setForeground(Color.red);
                }
            }
        });
        
        frmRegistro.setModal(true);
        frmRegistro.setVisible(false);
        frmRegistro.setVisible(true);
    }
    
    private void registrar() {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        
        if(!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            if(password.equals(confirmPassword)) {
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(txtNombre.getText());
                estudiante.setApellidos(txtApellidos.getText());
                estudiante.setEmail(txtEmail.getText());
                estudiante.setPassword(txtPassword.getText());
                if (Estudiante.iniciarSesion(email, password) == null) {
                    estudiante.agregar();
                    frmRegistro.dispose();
                } else JOptionPane.showMessageDialog(frmRegistro, "Estudiante ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else JOptionPane.showMessageDialog(frmRegistro, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(frmRegistro, "Ingrese los datos", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
