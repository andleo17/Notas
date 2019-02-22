
package com.andres.notas.controller;

import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmAgregarProfesor;
import com.andres.notas.view.FrmPrincipal;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgregarProfesor implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmAgregarProfesor frmAgregarProfesor;
    private Profesor profesor;
    
    public AgregarProfesor(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    public AgregarProfesor(FrmPrincipal frmPrincipal, Profesor profesor) {
        this.frmPrincipal = frmPrincipal;
        iniciar(profesor);
    }
    
    private void iniciar() {
        frmAgregarProfesor = new FrmAgregarProfesor(frmPrincipal, Dialog.ModalityType.MODELESS);
        frmAgregarProfesor.setTitle("Agregar Profesor");
        frmAgregarProfesor.setLocationRelativeTo(null);
        frmAgregarProfesor.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmAgregarProfesor.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                agregar();
            }
        });
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarProfesor);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarProfesor.setModal(true);
        frmAgregarProfesor.setVisible(false);
        frmAgregarProfesor.setVisible(true);
    }
    
    private void iniciar(Profesor profesor) {
        this.profesor = profesor;
        
        frmAgregarProfesor = new FrmAgregarProfesor(frmPrincipal, Dialog.ModalityType.MODELESS);
        frmAgregarProfesor.setTitle("Modificar Profesor");
        frmAgregarProfesor.setLocationRelativeTo(null);
        frmAgregarProfesor.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmAgregarProfesor.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                agregar();
            }
        });
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarProfesor);
        btnAgregar.setText("Modificar");
        btnAgregar.addActionListener(evt -> actualizar());
        
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarProfesor);
        txtNombre.setText(profesor.getNombre());
        
        JTextField txtApellidos = (JTextField) getComponentByName("txtApellidos", frmAgregarProfesor);
        txtApellidos.setText(profesor.getApellidos());
        
        JTextField txtEmail = (JTextField) getComponentByName("txtEmail", frmAgregarProfesor);
        txtEmail.setText(profesor.getEmail());
        
        frmAgregarProfesor.setModal(true);
        frmAgregarProfesor.setVisible(false);
        frmAgregarProfesor.setVisible(true);
    }
    
    private void agregar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarProfesor);
        JTextField txtApellidos = (JTextField) getComponentByName("txtApellidos", frmAgregarProfesor);
        JTextField txtEmail = (JTextField) getComponentByName("txtEmail", frmAgregarProfesor);
        
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String email = txtEmail.getText();
        
        if (!nombre.isEmpty() || !apellidos.isEmpty() || !email.isEmpty()) {
            if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
                profesor = new Profesor();
                profesor.setNombre(nombre);
                profesor.setApellidos(apellidos);
                profesor.setEmail(email);
                profesor.agregar();
    
                frmAgregarProfesor.dispose();
            } else {
                JOptionPane.showMessageDialog(frmAgregarProfesor, "Faltan datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(frmAgregarProfesor, "¿Seguro que no quiere registrar un curso?", "Mensaje", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) frmAgregarProfesor.dispose();
        }
        
    }
    
    private void actualizar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarProfesor);
        JTextField txtApellidos = (JTextField) getComponentByName("txtApellidos", frmAgregarProfesor);
        JTextField txtEmail = (JTextField) getComponentByName("txtEmail", frmAgregarProfesor);
        
        profesor.setNombre(txtNombre.getText());
        profesor.setApellidos(txtApellidos.getText());
        profesor.setEmail(txtEmail.getText());
        profesor.actualizar();
        
        frmAgregarProfesor.dispose();
    }
    
}
