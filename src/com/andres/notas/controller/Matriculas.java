
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.view.FrmMatriculas;
import com.andres.notas.view.FrmPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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
        
        lista.forEach(m -> pnlContenido.add(new CMatricula(m, frmPrincipal).getElementMatricula()));
        pnlContenido.updateUI();
    }
    
    private void agregar() {
        new AgregarMatricula(frmPrincipal, estudiante, ciclo);
    }
    
}
