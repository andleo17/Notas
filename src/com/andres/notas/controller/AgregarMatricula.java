
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Curso;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.model.Profesor;
import com.andres.notas.model.Rubrica;
import com.andres.notas.view.FrmAgregarMatricula;
import com.andres.notas.view.FrmPrincipal;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AgregarMatricula implements IMapeable{
    
    private final FrmPrincipal frmPrincipal;
    private FrmAgregarMatricula frmAgregarMatricula;
    private Matricula matricula;
    private Estudiante estudiante;
    private Ciclo ciclo;
    private ArrayList<Rubrica> rubricas;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;
    private int j;
    private AtomicInteger index;
    
    public AgregarMatricula(FrmPrincipal frmPrincipal, Estudiante estudiante, Ciclo ciclo) {
        this.frmPrincipal = frmPrincipal;
        this.rubricas = new ArrayList<>();
        this.estudiante = estudiante;
        this.ciclo = ciclo;
        index = new AtomicInteger(1);
        iniciar();
    }
    
    public AgregarMatricula(FrmPrincipal frmPrincipal, Matricula matricula) {
        this.frmPrincipal = frmPrincipal;
        this.rubricas = matricula.getRubricas();
        index = new AtomicInteger(this.rubricas.size() + 1);
        iniciar(matricula);
    }
    
    private void iniciar() {
        frmAgregarMatricula = new FrmAgregarMatricula(frmPrincipal, false);
        frmAgregarMatricula.setVisible(true);
        frmAgregarMatricula.setTitle("Agregar Matrícula");
        frmAgregarMatricula.setLocationRelativeTo(null);
        listarCursos();
        listarProfesores();
        
        frmAgregarMatricula.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent we) {
                listarRubricas();
            }
        });
        
        JButton btnAgregarRubrica = (JButton) getComponentByName("btnAgregarRubrica", frmAgregarMatricula);
        btnAgregarRubrica.addActionListener(evt -> agregarRubrica());        
        
        JButton btnAgregarMatricula = (JButton) getComponentByName("btnAgregarMatricula", frmAgregarMatricula);
        btnAgregarMatricula.addActionListener(evt -> agregarMatricula());
        
        frmAgregarMatricula.setModal(true);
        frmAgregarMatricula.setVisible(false);
        frmAgregarMatricula.setVisible(true);
    }
    
    private void iniciar(Matricula matricula) {
        this.matricula = matricula;
        rubricas = matricula.getRubricas();
        j = rubricas.size();
        
        frmAgregarMatricula = new FrmAgregarMatricula(frmPrincipal, false);
        frmAgregarMatricula.setVisible(true);
        frmAgregarMatricula.setTitle("Modificar Matrícula");
        frmAgregarMatricula.setLocationRelativeTo(null);
        listarCursos();
        listarProfesores();
        listarRubricas();
        
        frmAgregarMatricula.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent we) {
                listarRubricas();
            }
        });
        
        JButton btnAgregarRubrica = (JButton) getComponentByName("btnAgregarRubrica", frmAgregarMatricula);
        btnAgregarRubrica.addActionListener(evt -> agregarRubrica());        
        
        JButton btnAgregarMatricula = (JButton) getComponentByName("btnAgregarMatricula", frmAgregarMatricula);
        btnAgregarMatricula.setText("Modificar");
        btnAgregarMatricula.addActionListener(evt -> modificarMatricula());
        
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        
        cboCursos.setSelectedItem(matricula.getCurso().getNombre());
        cboCursos.setEnabled(false);
        cboProfesores.setSelectedItem(matricula.getProfesor().getApellidos() + ", " + matricula.getProfesor().getNombre());
        
        frmAgregarMatricula.setModal(true);
        frmAgregarMatricula.setVisible(false);
        frmAgregarMatricula.setVisible(true);
        
    }
    
    private void listarCursos() {
        cursos = Curso.listar();
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        cboCursos.removeAllItems();
        cursos.forEach(c -> cboCursos.addItem(c.getNombre()));
        cboCursos.setSelectedIndex(-1);
    }
    
    private void listarProfesores() {
        profesores = Profesor.listar();
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        cboProfesores.removeAllItems();
        profesores.forEach(p -> cboProfesores.addItem(p.getApellidos() + ", " + p.getNombre()));
        cboProfesores.setSelectedIndex(-1);
    }
    
    private void agregarRubrica() {
        AgregarRubrica agregarRubrica = new AgregarRubrica(frmAgregarMatricula);
        agregarRubrica.getRubrica().setNumeroRubrica(index.getAndIncrement());
        if (agregarRubrica.getRubrica() != null) rubricas.add(agregarRubrica.getRubrica());
        listarRubricas();
    }
    
    private void listarRubricas() {
        JPanel pnlRubricas = (JPanel) getComponentByName("pnlRubricas", frmAgregarMatricula);
        pnlRubricas.removeAll();
        GridBagConstraints gbl = new GridBagConstraints();
        AtomicInteger i = new AtomicInteger(0);
        rubricas.forEach(r -> {
            JPanel panel = new CRubrica(r, frmAgregarMatricula).getElementRubrica();
            gbl.gridx = 0;
            gbl.gridy = i.getAndIncrement();
            gbl.fill = GridBagConstraints.HORIZONTAL;
            gbl.anchor = GridBagConstraints.NORTH;
            gbl.weightx = 1.0;
            gbl.insets = new Insets(5, 5, 5, 5);
            pnlRubricas.add(panel, gbl);
        });
        gbl.gridx = 0;
        gbl.gridy = i.get();
        gbl.weighty = 1.0;
        pnlRubricas.add(new JPanel(), gbl);
        pnlRubricas.updateUI();
    }
    
    private void agregarMatricula() {
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        JComboBox cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        
        matricula = new Matricula();
        matricula.setCiclo(ciclo);
        matricula.setEstudiante(estudiante);
        if(cboCursos.getSelectedIndex() != -1 && cboProfesores.getSelectedIndex() != -1){
            if (!rubricas.isEmpty()) {
                matricula.setRubricas(rubricas);
                matricula.setCurso(cursos.get(cboCursos.getSelectedIndex()));
                matricula.setProfesor(profesores.get(cboProfesores.getSelectedIndex()));
                try {
                    matricula.agregar();
                    frmAgregarMatricula.dispose();
                } catch (SQLException e) {
                    switch (Integer.valueOf(e.getSQLState())){
                        case 23505:
                            JOptionPane.showMessageDialog(frmAgregarMatricula, "Matrícula ya registrada", "Error al registrar", JOptionPane.ERROR_MESSAGE);
                        default:
                            System.err.println("Otro error");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frmAgregarMatricula, "Ingrese rúbricas", "Error al registrar", JOptionPane.ERROR_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(frmAgregarMatricula, "Seleccione un curso o un profesor", "Error al registrar", JOptionPane.ERROR_MESSAGE);
    }
    
    private void modificarMatricula() {
        JComboBox cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        matricula.setProfesor(profesores.get(cboProfesores.getSelectedIndex()));
        
        if(j != rubricas.size()) {
            
            for (int i = j; i < rubricas.size(); i++) {
                Rubrica r = rubricas.get(i);
                r.setMatricula(matricula);
                r.setNumeroRubrica(i + 1);
                r.agregar();
            }
        }
        
        matricula.actualizar();
        frmAgregarMatricula.dispose();
    }
    
}
