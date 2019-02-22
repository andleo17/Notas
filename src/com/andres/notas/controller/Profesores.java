
package com.andres.notas.controller;

import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmPrincipal;
import com.andres.notas.view.FrmProfesores;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Profesores implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    
    private FrmProfesores frmProfesores;
    
    private JButton btnAgregar;
    private JPanel  pnlContenido;
    
    public Profesores(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }
    
    public JPanel iniciar() {
        frmProfesores = new FrmProfesores();
        
        frmPrincipal.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent we) {
                listar();
            }
            
        });
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmProfesores);
        btnAgregar.addActionListener(evt -> agregar());
        
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmProfesores);
        listar();
        
        return frmProfesores;
    }
    
    private void listar() {
        ArrayList<Profesor> lista = Profesor.listar();
        pnlContenido.removeAll();
        
        lista.forEach(p -> pnlContenido.add(new CProfesor(p, frmPrincipal).getElementProfesor()));
        pnlContenido.updateUI();
    }
    
    private void agregar() {
        new AgregarProfesor(frmPrincipal);
    }
    
}
