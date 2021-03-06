
package com.andres.notas.controller;

import com.andres.notas.model.Curso;
import com.andres.notas.view.FrmAgregarCurso;
import com.andres.notas.view.FrmPrincipal;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgregarCurso implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmAgregarCurso frmAgregarCurso;
    private JTextField txtNombre;
    private JFormattedTextField txtNumeroCreditos;
    private JButton btnAgregar;
    private Curso curso;
    
    public AgregarCurso(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    public AgregarCurso(FrmPrincipal frmPrincipal, Curso curso) {
        this.frmPrincipal = frmPrincipal;
        this.curso = curso;
        iniciar();
    }
    
    private void iniciar() {
        frmAgregarCurso = new FrmAgregarCurso(frmPrincipal, false);
        frmAgregarCurso.setLocationRelativeTo(null);
        frmAgregarCurso.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarCurso);
        txtNumeroCreditos = (JFormattedTextField) getComponentByName("txtNumeroCreditos", frmAgregarCurso);
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarCurso);
        
        if (curso == null) {
            curso = new Curso();
            frmAgregarCurso.setTitle("Agregar curso");
            btnAgregar.addActionListener(evt -> agregar());
        } else {
            frmAgregarCurso.setTitle("Modificar curso");
            btnAgregar.setText("Modificar");
            btnAgregar.addActionListener(evt -> actualizar());
            txtNombre.setText(curso.getNombre());
            txtNumeroCreditos.setText(String.valueOf(curso.getCreditos()));
        }

        frmAgregarCurso.setModal(true);
        frmAgregarCurso.setVisible(false);
        frmAgregarCurso.setVisible(true);
    }
    
    private void obtenerDatos() {
        curso.setNombre(txtNombre.getText());
        curso.setCreditos(Integer.valueOf(txtNumeroCreditos.getText()));
    }
    
    private void agregar() {
        if (!txtNombre.getText().isEmpty() && Integer.valueOf(txtNumeroCreditos.getText()) > 0) {
            try {
                obtenerDatos();
                curso.agregar();
                frmAgregarCurso.dispose();
            } catch (SQLException e) {
                switch (Integer.valueOf(e.getSQLState())){
                    case 23505:
                        JOptionPane.showMessageDialog(frmPrincipal, "Curso ya existe", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        System.err.println("Otro error");
                        System.err.println(Integer.valueOf(e.getSQLState()));
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(frmAgregarCurso, "Ingrese los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizar() {
        if (!txtNombre.getText().isEmpty() && Integer.valueOf(txtNumeroCreditos.getText()) > 0) {
            try {
                obtenerDatos();
                curso.actualizar();
                frmAgregarCurso.dispose();
            } catch (SQLException e) {
                switch (Integer.valueOf(e.getSQLState())){
                    case 23505:
                        JOptionPane.showMessageDialog(frmPrincipal, "Curso ya existe", "Error al modificar", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        System.err.println("Otro error");
                        System.err.println(Integer.valueOf(e.getSQLState()));
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(frmAgregarCurso, "Ingrese los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
