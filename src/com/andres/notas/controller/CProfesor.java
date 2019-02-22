
package com.andres.notas.controller;

import com.andres.notas.elements.ElementProfesor;
import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmPrincipal;
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
        if (respuesta == 0) profesor.eliminar();
    }
    
    public ElementProfesor getElementProfesor() {
        return elementProfesor;
    }

}
