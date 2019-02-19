
package com.andres.notas.controller;

import com.andres.notas.model.Curso;
import com.andres.notas.view.FrmAgregarCurso;
import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AgregarCurso implements IMapeable{
    
    private FrmAgregarCurso frmAgregarCurso;
    private Curso curso;
    
    public void iniciar(java.awt.Window frame) {
        frmAgregarCurso = new FrmAgregarCurso(frame, Dialog.ModalityType.MODELESS);
        frmAgregarCurso.setTitle("Agregar curso");
        frmAgregarCurso.setLocationRelativeTo(null);
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarCurso);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarCurso.setModal(true);
        frmAgregarCurso.setVisible(false);
        frmAgregarCurso.setVisible(true);
    }
    
    public void iniciar(java.awt.Window frame, Curso curso) {
        this.curso = curso;
        
        frmAgregarCurso = new FrmAgregarCurso(frame, Dialog.ModalityType.MODELESS);
        frmAgregarCurso.setTitle("Modificar curso");
        frmAgregarCurso.setLocationRelativeTo(null);
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarCurso);
        btnAgregar.setText("Modificar");
        btnAgregar.addActionListener(evt -> actualizar());
        
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarCurso);
        txtNombre.setText(curso.getNombre());
        
        JTextField txtNumeroCreditos = (JTextField) getComponentByName("txtNumeroCreditos", frmAgregarCurso);
        txtNumeroCreditos.setText(String.valueOf(curso.getCreditos()));
        
        frmAgregarCurso.setModal(true);
        frmAgregarCurso.setVisible(false);
        frmAgregarCurso.setVisible(true);
    }
    
    private void agregar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarCurso);
        JTextField txtNumeroCreditos = (JTextField) getComponentByName("txtNumeroCreditos", frmAgregarCurso);
        
        curso = new Curso();
        curso.setNombre(txtNombre.getText());
        curso.setCreditos(Integer.valueOf(txtNumeroCreditos.getText()));
        curso.agregar();
        
        frmAgregarCurso.dispose();
    }
    
    private void actualizar() {
        JTextField txtNombre = (JTextField) getComponentByName("txtNombre", frmAgregarCurso);
        JTextField txtNumeroCreditos = (JTextField) getComponentByName("txtNumeroCreditos", frmAgregarCurso);
        
        curso.setNombre(txtNombre.getText());
        curso.setCreditos(Integer.valueOf(txtNumeroCreditos.getText()));
        curso.actualizar();
        
        frmAgregarCurso.dispose();
    }
    
}
