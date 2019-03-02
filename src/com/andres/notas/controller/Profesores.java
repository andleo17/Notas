
package com.andres.notas.controller;

import com.andres.notas.model.Profesor;
import com.andres.notas.view.FrmPrincipal;
import com.andres.notas.view.FrmProfesores;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        GridBagConstraints gbl = new GridBagConstraints();
        
        if (!lista.isEmpty()) {
            Insets margin = new Insets(5, 5, 5, 5);
            AtomicInteger i = new AtomicInteger(0);
            lista.forEach(p -> {
                JPanel panel = new CProfesor(p, frmPrincipal).getElementProfesor();
                gbl.gridx = 0;
                gbl.gridy = i.getAndIncrement();
                gbl.fill = GridBagConstraints.HORIZONTAL;
                gbl.anchor = GridBagConstraints.NORTH;
                gbl.weightx = 1.0;
                gbl.insets = margin;
                pnlContenido.add(panel, gbl);
            });
            gbl.gridx = 0;
            gbl.gridy = lista.size();
            gbl.weighty = 1.0;
            pnlContenido.add(new JPanel(), gbl);
        } else {
            JLabel label = new JLabel("No se encuentran profesores");
            label.setFont(new Font("Microsoft Sans Serif", 0, 30));
            gbl.gridx = 0;
            gbl.gridy = 0;
            gbl.anchor = GridBagConstraints.CENTER;
            gbl.weighty = 1.0;
            pnlContenido.add(label, gbl);
        }
        
        pnlContenido.updateUI();
    }
    
    private void agregar() {
        new AgregarProfesor(frmPrincipal);
    }
    
}
