
package com.andres.notas.controller;

import com.andres.notas.elements.ElementMatricula;
import com.andres.notas.model.Matricula;
import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmPrincipal;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CMatricula implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    
    private final Matricula matricula;
    private ElementMatricula elementMatricula;
    
    private JLabel lblCurso;
    private JLabel lblProfesor;
    private JLabel lblPromedio;
    private JLabel lblNotas;
    
    private JButton btnDetalles;
    private JButton btnModificar;
    private JButton btnEliminar;
    
    public CMatricula(Matricula matricula, FrmPrincipal frmPrincipal) {
        this.matricula = matricula;
        this.frmPrincipal = frmPrincipal;
        iniciar();
    }
    
    private void iniciar() {
        elementMatricula = new ElementMatricula();
        
        lblCurso = (JLabel) getComponentByName("lblCurso", elementMatricula);
        lblProfesor = (JLabel) getComponentByName("lblProfesor", elementMatricula);
        lblPromedio = (JLabel) getComponentByName("lblPromedio", elementMatricula);
        lblNotas = (JLabel) getComponentByName("lblNotas", elementMatricula);
        
        btnDetalles = (JButton) getComponentByName("btnDetalles", elementMatricula);
        btnDetalles.addActionListener(evt -> verDetalles());
        
        btnModificar = (JButton) getComponentByName("btnModificar", elementMatricula);
        btnModificar.addActionListener(evt -> modificar());
        
        btnEliminar = (JButton) getComponentByName("btnEliminar", elementMatricula);
        btnEliminar.addActionListener(evt -> eliminar());
        
        lblCurso.setText(matricula.getCurso().getNombre());
        lblProfesor.setText(matricula.getProfesor().getApellidos() + ", " + matricula.getProfesor().getNombre());
        lblPromedio.setText(String.valueOf(matricula.getPromedioFinal()));
        
        int nC = 0, nF = 0;
        for (Rubrica r : matricula.getRubricas()) {
            for (Nota n : r.getNotas()) {
                if (n.getNota() == -1) nF++; else nC++;
            }
        }
        lblNotas.setText(nF + " / " + nC);
    }
    
    private void verDetalles() {
        new MatriculaDetallada(matricula, frmPrincipal);
    }
    
    private void modificar() {
        new AgregarMatricula(frmPrincipal, matricula);
    }
    
    private void eliminar() {
        int respuesta = JOptionPane.showConfirmDialog(frmPrincipal, "¿Desea eliminar la matricula de " + matricula.getCurso().getNombre() + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            try {
                for (Rubrica r : matricula.getRubricas()) {
                    for (Nota n : r.getNotas()) {
                        n.eliminar();
                    }
                    r.eliminar();
                }
                matricula.eliminar();
            } catch (SQLException e) {
                switch (Integer.valueOf(e.getSQLState())){
                    default:
                        System.err.println("Otro error");
                        System.err.println(Integer.valueOf(e.getSQLState()));
                        break;
                }
            }
        }
    }
    
    public ElementMatricula getElementMatricula() {
        return elementMatricula;
    }
    
}
