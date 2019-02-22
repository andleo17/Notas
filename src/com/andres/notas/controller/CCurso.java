
package com.andres.notas.controller;

import com.andres.notas.elements.ElementCurso;
import com.andres.notas.model.Curso;
import com.andres.notas.view.FrmPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CCurso implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    
    private final Curso curso;
    private ElementCurso elementCurso;
    
    private JLabel lblNombre;
    private JLabel lblCreditos;
    
    private JButton btnModificar;
    private JButton btnEliminar;
    
    public CCurso(Curso curso, FrmPrincipal frmPrincipal) {
        this.curso = curso;
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    private void iniciar() {
        elementCurso = new ElementCurso();
        
        lblNombre = (JLabel) getComponentByName("lblNombre", elementCurso);
        lblCreditos = (JLabel) getComponentByName("lblCreditos", elementCurso);
        btnModificar = (JButton) getComponentByName("btnModificar", elementCurso);
        btnModificar.addActionListener(evt -> modificar());
        btnEliminar = (JButton) getComponentByName("btnEliminar", elementCurso);
        btnEliminar.addActionListener(evt -> eliminar());
        
        lblNombre.setText(curso.getNombre());
        lblCreditos.setText(curso.getCreditos() + " créditos");
    }
    
    private void modificar() {
        new AgregarCurso(frmPrincipal, curso);
    }
    
    private void eliminar() {
        int respuesta = JOptionPane.showConfirmDialog(frmPrincipal, "¿Desea eliminar " + curso.getNombre() + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) curso.eliminar();
    }
    
    public ElementCurso getElementCurso() {
        return elementCurso;
    }
    
}
