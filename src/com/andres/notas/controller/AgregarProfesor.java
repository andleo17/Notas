
package com.andres.notas.controller;

import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmAgregarProfesor;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AgregarProfesor implements IMapeable{
    
    private FrmAgregarProfesor frmAgregarProfesor;
    private Profesor profesor;
    
    public void iniciar(java.awt.Frame parent) {
        frmAgregarProfesor = new FrmAgregarProfesor(parent, false);
        frmAgregarProfesor.setTitle("Agregar Profesor");
        frmAgregarProfesor.setLocationRelativeTo(null);
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarProfesor);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarProfesor.setModal(true);
        frmAgregarProfesor.setVisible(false);
        frmAgregarProfesor.setVisible(true);
    }
    
    public void iniciar(java.awt.Frame parent, Profesor profesor) {
        this.profesor = profesor;
        
        frmAgregarProfesor = new FrmAgregarProfesor(parent, true);
        frmAgregarProfesor.setTitle("Modificar Profesor");
        frmAgregarProfesor.setLocationRelativeTo(null);
        
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
        
        profesor = new Profesor();
        profesor.setNombre(txtNombre.getText());
        profesor.setApellidos(txtApellidos.getText());
        profesor.setEmail(txtEmail.getText());
        profesor.agregar();
        
        frmAgregarProfesor.dispose();
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
