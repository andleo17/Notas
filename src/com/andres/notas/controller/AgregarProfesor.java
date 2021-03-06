
package com.andres.notas.controller;

import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmAgregarProfesor;
import com.andres.notas.view.FrmPrincipal;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgregarProfesor implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private Profesor profesor;
    private FrmAgregarProfesor frmAgregarProfesor;
    private JButton btnAgregar;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtEmail;
    
    public AgregarProfesor(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    public AgregarProfesor(FrmPrincipal frmPrincipal, Profesor profesor) {
        this.frmPrincipal = frmPrincipal;
        this.profesor = profesor;
        iniciar();
    }
    
    private void iniciar() {
        frmAgregarProfesor = new FrmAgregarProfesor(frmPrincipal, false);
        frmAgregarProfesor.setLocationRelativeTo(null);
        frmAgregarProfesor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarProfesor);
        txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarProfesor);
        txtApellidos = (JTextField) getComponentByName("txtApellidos", frmAgregarProfesor);
        txtEmail = (JTextField) getComponentByName("txtEmail", frmAgregarProfesor);
        
        if (profesor == null) {
            profesor = new Profesor();
            frmAgregarProfesor.setTitle("Agregar Profesor");
            btnAgregar.addActionListener(evt -> agregar());
        } else {
            frmAgregarProfesor.setTitle("Modificar Profesor");
            btnAgregar.setText("Modificar");
            btnAgregar.addActionListener(evt -> actualizar());
            txtNombre.setText(profesor.getNombre());
            txtApellidos.setText(profesor.getApellidos());
            txtEmail.setText(profesor.getEmail());
        }
        
        frmAgregarProfesor.setModal(true);
        frmAgregarProfesor.setVisible(false);
        frmAgregarProfesor.setVisible(true);
    }
    
    private void obtenerDatos() {
        profesor.setNombre(txtNombre.getText());
        profesor.setApellidos(txtApellidos.getText());
        profesor.setEmail(txtEmail.getText());
        
    }
    
    private void agregar() {
        if (!txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() && !txtEmail.getText().isEmpty()) {
            obtenerDatos();
            try {
                profesor.agregar();
                frmAgregarProfesor.dispose();
            } catch (SQLException e) {
                switch (Integer.valueOf(e.getSQLState())){
                    case 23505:
                        JOptionPane.showMessageDialog(frmAgregarProfesor, "Profesor ya registrado", "Error al registrar", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        System.err.println("Otro error");
                        System.err.println(Integer.valueOf(e.getSQLState()));
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(frmAgregarProfesor, "Complete los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizar() {
        if (!txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() && !txtEmail.getText().isEmpty()) {
            obtenerDatos();
            try {
                profesor.actualizar();
                frmAgregarProfesor.dispose();
            } catch (SQLException e) {
                switch (Integer.valueOf(e.getSQLState())){
                    case 23505:
                        JOptionPane.showMessageDialog(frmAgregarProfesor, "Email ya registrado", "Error al registrar", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        System.err.println("Otro error");
                        System.err.println(Integer.valueOf(e.getSQLState()));
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(frmAgregarProfesor, "Complete los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
