
package com.andres.notas.controller;

import com.andres.notas.model.Curso;
import com.andres.notas.view.FrmCursos;
import com.andres.notas.view.FrmPrincipal;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
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
        GridBagConstraints gbl = new GridBagConstraints();
        AtomicInteger i = new AtomicInteger(0);
        lista.forEach(c -> {
            JPanel panel = new CCurso(c, frmPrincipal).getElementCurso();
            gbl.gridx = 0;
            gbl.gridy = i.getAndIncrement();
            gbl.fill = GridBagConstraints.HORIZONTAL;
            gbl.anchor = GridBagConstraints.NORTH;
            gbl.weightx = 1.0;
            gbl.insets = new Insets(5, 5, 5, 5);
            pnlContenido.add(panel, gbl);
        });
        gbl.gridx = 0;
        gbl.gridy = i.get();
        gbl.weighty = 1.0;
        pnlContenido.add(new JPanel(), gbl);
        pnlContenido.updateUI();
    }
    
    private void agregar() {
        new AgregarCurso(frmPrincipal);
    }
    
}
