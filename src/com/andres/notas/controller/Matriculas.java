
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmMatriculas;
import com.andres.notas.view.FrmPrincipal;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Matriculas implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmMatriculas frmMatriculas;
    private final Ciclo ciclo;
    private final Estudiante estudiante;
    
    private JButton btnAgregar;
    private JPanel pnlContenido;
    
    public Matriculas(FrmPrincipal frmPrincipal, Estudiante estudiante, Ciclo ciclo) {
        this.frmPrincipal = frmPrincipal;
        this.estudiante = estudiante;
        this.ciclo = ciclo;
    }
    
    public JPanel iniciar() {
        frmMatriculas = new FrmMatriculas();
        
        frmPrincipal.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent we) {
                listar();
            }
            
        });
        
        btnAgregar = (JButton) getComponentByName("btnAgregar", frmMatriculas);
        btnAgregar.addActionListener(evt -> agregar());
        
        pnlContenido = (JPanel) getComponentByName("pnlContenido", frmMatriculas);
        listar();
        return frmMatriculas;
    }
    
    private void listar() {
        ArrayList<Matricula> lista = Matricula.listarMatriculas(ciclo, estudiante);
        pnlContenido.removeAll();
        GridBagConstraints gbl = new GridBagConstraints();
        AtomicInteger i = new AtomicInteger(0);
        lista.forEach(m -> {
            JPanel panel = new CMatricula(m, frmPrincipal).getElementMatricula();
            gbl.gridx = 0;
            gbl.gridy = i.getAndIncrement();
            gbl.fill = GridBagConstraints.HORIZONTAL;
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
        new AgregarMatricula(frmPrincipal, estudiante, ciclo);
    }
    
}
