
package com.andres.notas.controller;

import com.andres.notas.elements.ElementRubrica;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CRubrica implements IMapeable{
    
    private final FrmAgregarMatricula frmAgregarMatricula;
    
    private final Rubrica rubrica;
    private ElementRubrica elementRubrica;
    
    private JButton btnEliminar;
    private JButton btnModificar;
    private JLabel lblNombre;
    private JLabel lblNotas;
    private JLabel lblNumero;
    private JLabel lblPeso;
    
    public CRubrica(Rubrica rubrica, FrmAgregarMatricula frmAgregarMatricula) {
        this.rubrica = rubrica;
        this.frmAgregarMatricula = frmAgregarMatricula;
        iniciar();
    }
    
    private void iniciar() {
        elementRubrica = new ElementRubrica();

        lblNombre = (JLabel) getComponentByName("lblNombre", elementRubrica);
        lblNotas = (JLabel) getComponentByName("lblNotas", elementRubrica);
        lblNumero = (JLabel) getComponentByName("lblNumero", elementRubrica);
        lblPeso = (JLabel) getComponentByName("lblPeso", elementRubrica);
        btnEliminar = (JButton) getComponentByName("btnEliminar", elementRubrica);
        btnEliminar.addActionListener(evt -> eliminar());
        btnModificar = (JButton) getComponentByName("btnModificar", elementRubrica);
        btnModificar.addActionListener(evt -> modificar());
        
        lblNumero.setText(String.valueOf(rubrica.getNumeroRubrica()));
        lblNombre.setText(rubrica.getNombre());
        lblPeso.setText((rubrica.getPeso() * 10 * 10)+ " %");
        lblNotas.setText(String.valueOf(rubrica.getNotas().size()));
    }
    
    private void modificar() {
        new AgregarRubrica(frmAgregarMatricula, rubrica);
    }
    
    private void eliminar() {
        int respuesta = JOptionPane.showConfirmDialog(frmAgregarMatricula, "¿Desea eliminar la rúbrica " + rubrica.getNombre() + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) AgregarMatricula.rubricas.remove(rubrica);
    }
    
    public JPanel getElementRubrica() {
        return elementRubrica;
    }
    
}
