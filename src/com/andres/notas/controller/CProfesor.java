
package com.andres.notas.controller;

import com.andres.notas.elements.ElementProfesor;
import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmPrincipal;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CProfesor implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    
    private final Profesor profesor;
    private ElementProfesor elementProfesor;
    
    private JLabel lblNombre;
    private JLabel lblEmail;
    
    private JButton btnModificar;
    private JButton btnEliminar;
    
    public CProfesor(Profesor profesor, FrmPrincipal frmPrincipal) {
        this.profesor = profesor;
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    private void iniciar() {
        elementProfesor = new ElementProfesor();
        
        lblNombre = (JLabel) getComponentByName("lblNombre", elementProfesor);
        lblEmail = (JLabel) getComponentByName("lblEmail", elementProfesor);
        btnModificar = (JButton) getComponentByName("btnModificar", elementProfesor);
        btnModificar.addActionListener(evt -> modificar());
        btnEliminar = (JButton) getComponentByName("btnEliminar", elementProfesor);
        btnEliminar.addActionListener(evt -> eliminar());
        
        lblNombre.setText(profesor.getApellidos() + ", " + profesor.getNombre());
        lblEmail.setText(profesor.getEmail());
    }
    
    private void modificar() {
        new AgregarProfesor(frmPrincipal, profesor);
    }
    
    private void eliminar() {
        
        int respuesta = JOptionPane.showConfirmDialog(frmPrincipal, "¿Desea eliminar a " + profesor.getApellidos() + ", " + profesor.getNombre() + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            try {
                profesor.eliminar();
            } catch (SQLException e) {
                switch (Integer.valueOf(e.getSQLState())){
                    case 23503:
                        JOptionPane.showMessageDialog(frmPrincipal, "Profesor asociado a una matrícula, elimine la matrícula primero", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        System.err.println("Otro error");
                        System.err.println(Integer.valueOf(e.getSQLState()));
                        break;
                }
            }
        }
    }
    
    public ElementProfesor getElementProfesor() {
        return elementProfesor;
    }

}
