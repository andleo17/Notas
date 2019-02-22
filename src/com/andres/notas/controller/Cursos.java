
package com.andres.notas.controller;

import com.andres.notas.model.Curso;
import com.andres.notas.view.FrmCursos;
import com.andres.notas.view.FrmPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Cursos implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmCursos frmCursos;
    
    private JButton btnAgregar;
    private JPanel  pnlContenido;
    
    public Cursos(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }
    
    public JPanel iniciar() {
        frmCursos = new FrmCursos();
        
        frmPrincipal.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent we) {
                listar();
            }
            
        });
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmCursos);
        btnAgregar.addActionListener(evt -> agregar());
        
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmCursos);
        listar();
        
        return frmCursos;
    }
    
    private void listar() {
        ArrayList<Curso> lista = Curso.listar();
        pnlContenido.removeAll();
        
        lista.forEach(c -> pnlContenido.add(new CCurso(c, frmPrincipal).getElementCurso()));
        pnlContenido.updateUI();
    }
    
    private void agregar() {
        new AgregarCurso(frmPrincipal);
    }
    
}
