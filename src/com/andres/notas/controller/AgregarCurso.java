
package com.andres.notas.controller;

import com.andres.notas.model.Curso;
import com.andres.notas.view.FrmAgregarCurso;
import com.andres.notas.view.FrmPrincipal;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgregarCurso implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmAgregarCurso frmAgregarCurso;
    private Curso curso;
    
    public AgregarCurso(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    public AgregarCurso(FrmPrincipal frmPrincipal, Curso curso) {
        this.frmPrincipal = frmPrincipal;
        iniciar(curso);
    }
    
    private void iniciar() {
        frmAgregarCurso = new FrmAgregarCurso(frmPrincipal, Dialog.ModalityType.MODELESS);
        frmAgregarCurso.setTitle("Agregar curso");
        frmAgregarCurso.setLocationRelativeTo(null);
        frmAgregarCurso.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmAgregarCurso.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                agregar();
            }
        });
        
        JButton btnAgregar = (JButton) getComponentByName("btnAgregar", frmAgregarCurso);
        btnAgregar.addActionListener(evt -> agregar());
        
        frmAgregarCurso.setModal(true);
        frmAgregarCurso.setVisible(false);
        frmAgregarCurso.setVisible(true);
    }
    
    private void iniciar(Curso curso) {
        this.curso = curso;
        
        frmAgregarCurso = new FrmAgregarCurso(frmPrincipal, Dialog.ModalityType.MODELESS);
        frmAgregarCurso.setTitle("Modificar curso");
        frmAgregarCurso.setLocationRelativeTo(null);
        frmAgregarCurso.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmAgregarCurso.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                agregar();
            }
        });
        
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
        
        try {
            curso = new Curso();
            curso.setNombre(txtNombre.getText());
            curso.setCreditos(Integer.valueOf(txtNumeroCreditos.getText()));
            curso.agregar();
            
            frmAgregarCurso.dispose();
        } catch (Exception e) {
            int respuesta = JOptionPane.showConfirmDialog(frmAgregarCurso, "¿Seguro que no quiere registrar un curso?", "Mensaje", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) frmAgregarCurso.dispose();
        }
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
