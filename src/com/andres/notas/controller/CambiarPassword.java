
package com.andres.notas.controller;

import com.andres.notas.model.Estudiante;
import com.andres.notas.view.FrmCambiarPassword;
import com.andres.notas.view.FrmLogin;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class CambiarPassword implements IMapeable{
    
    private final FrmLogin frmLogin;
    private FrmCambiarPassword frmCambiarPassword;
    private JButton btnCambiar;
    private JTextField txtEmail;
    private JTextField txtPasswordActual;
    private JTextField txtPasswordNuevo;
    private JTextField txtConfirmPassword;
    
    public CambiarPassword(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        iniciar();
    }
    
    private void iniciar() {
        frmCambiarPassword = new FrmCambiarPassword(frmLogin, false);
        frmCambiarPassword.setVisible(true);
        frmCambiarPassword.setTitle("Cambiar contraseña");
        frmCambiarPassword.setLocationRelativeTo(null);
        
        btnCambiar = (JButton) getComponentByName("btnCambiar", frmCambiarPassword);
        btnCambiar.addActionListener(evt -> actualizar());
        
        txtEmail = (JTextField) getComponentByName("txtEmail", frmCambiarPassword);
        txtPasswordActual = (JTextField) getComponentByName("txtPasswordActual", frmCambiarPassword);
        txtPasswordNuevo = (JTextField) getComponentByName("txtPasswordNuevo", frmCambiarPassword);
        txtConfirmPassword = (JTextField) getComponentByName("txtConfirmPassword", frmCambiarPassword);
        txtConfirmPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String password = txtPasswordNuevo.getText();
                String cPassword = txtConfirmPassword.getText();
                
                JSeparator sprPassword = (JSeparator) getComponentByName("sprPassword", frmCambiarPassword);
                JSeparator sprConfirmPassword = (JSeparator) getComponentByName("sprConfirmPassword", frmCambiarPassword);
                
                if(password.equals(cPassword)){
                    sprPassword.setForeground(Color.green);
                    sprConfirmPassword.setForeground(Color.green);
                }else {
                    sprPassword.setForeground(Color.red);
                    sprConfirmPassword.setForeground(Color.red);
                }
            }
        });
        
        frmCambiarPassword.setModal(true);
        frmCambiarPassword.setVisible(false);
        frmCambiarPassword.setVisible(true);
    }
    
    private void actualizar() {
        String email = txtEmail.getText();
        String passActual = txtPasswordActual.getText();
        String nuevaPass = txtPasswordNuevo.getText();
        String confPass = txtConfirmPassword.getText();
        
        if (!email.isEmpty() && !passActual.isEmpty() && !nuevaPass.isEmpty() && !confPass.isEmpty()) {
            if (nuevaPass.equals(confPass)) {
                Estudiante e = Estudiante.iniciarSesion(email, passActual);
                if (e != null) {
                    try {
                        e.setPassword(nuevaPass);
                        e.actualizar();
                        frmCambiarPassword.dispose();
                    } catch (SQLException ex) {
                        switch (Integer.valueOf(ex.getSQLState())){
                            case 23505:
                                JOptionPane.showMessageDialog(frmCambiarPassword, "Email ya existe", "Error al modificar", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                System.err.println("Otro error");
                                System.err.println(Integer.valueOf(ex.getSQLState()));
                                break;
                        }
                    }
                } else JOptionPane.showMessageDialog(frmCambiarPassword, "Estudiante no registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else JOptionPane.showMessageDialog(frmCambiarPassword, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(frmCambiarPassword, "Ingrese los datos", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
