
package com.andres.notas.controller;

import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Curso;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.model.Nota;
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
    public  static ArrayList<Rubrica> rubricas;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;
    private JComboBox cboCursos;
    private JComboBox cboProfesores;
    private JButton btnAgregarRubrica;
    private JButton btnAgregarMatricula;
    private JPanel pnlRubricas;
    
    public AgregarMatricula(FrmPrincipal frmPrincipal, Estudiante estudiante, Ciclo ciclo) {
        this.frmPrincipal = frmPrincipal;
        this.estudiante = estudiante;
        this.ciclo = ciclo;
        iniciar();
    }
    
    public AgregarMatricula(FrmPrincipal frmPrincipal, Matricula matricula) {
        this.frmPrincipal = frmPrincipal;
        this.matricula = matricula;
        iniciar();
    }
    
    private void iniciar() {
        frmAgregarMatricula = new FrmAgregarMatricula(frmPrincipal, false);
        frmAgregarMatricula.setVisible(true);
        frmAgregarMatricula.setLocationRelativeTo(null);
        frmAgregarMatricula.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent w) {
                listarRubricas();
            }
        });
        
        pnlRubricas = (JPanel) getComponentByName("pnlRubricas", frmAgregarMatricula);
        cboCursos = (JComboBox) getComponentByName("cboCursos", frmAgregarMatricula);
        cboProfesores = (JComboBox) getComponentByName("cboProfesores", frmAgregarMatricula);
        
        btnAgregarRubrica = (JButton) getComponentByName("btnAgregarRubrica", frmAgregarMatricula);
        btnAgregarRubrica.addActionListener(evt -> agregarRubrica());        
        
        btnAgregarMatricula = (JButton) getComponentByName("btnAgregarMatricula", frmAgregarMatricula);
        listarCursos();
        listarProfesores();
        
        this.rubricas = new ArrayList<>();
        
        if (matricula == null) {
            matricula = new Matricula();
            matricula.setRubricas(new ArrayList<>());
            matricula.setCiclo(ciclo);
            matricula.setEstudiante(estudiante);
            frmAgregarMatricula.setTitle("Agregar Matrícula");
            btnAgregarMatricula.addActionListener(evt -> agregarMatricula());
        } else {
            matricula.getRubricas().forEach(r -> rubricas.add(r));
            frmAgregarMatricula.setTitle("Modificar Matrícula");
            btnAgregarMatricula.setText("Modificar");
            btnAgregarMatricula.addActionListener(evt -> modificarMatricula());

            cboCursos.setSelectedItem(matricula.getCurso().getNombre());
            cboCursos.setEnabled(false);
            cboProfesores.setSelectedItem(matricula.getProfesor().getApellidos() + ", " + matricula.getProfesor().getNombre());
        }
        frmAgregarMatricula.setModal(true);
        frmAgregarMatricula.setVisible(false);
        frmAgregarMatricula.setVisible(true);
    }
    
    private void listarCursos() {
        cursos = Curso.listar();
        cboCursos.removeAllItems();
        cursos.forEach(c -> cboCursos.addItem(c.getNombre()));
        cboCursos.setSelectedIndex(-1);
    }
    
    private void listarProfesores() {
        profesores = Profesor.listar();
        cboProfesores.removeAllItems();
        profesores.forEach(p -> cboProfesores.addItem(p.getApellidos() + ", " + p.getNombre()));
        cboProfesores.setSelectedIndex(-1);
    }
    
    private void agregarRubrica() {
        AgregarRubrica agregarRubrica = new AgregarRubrica(frmAgregarMatricula);
        if (agregarRubrica.getRubrica() != null) {
            rubricas.add(agregarRubrica.getRubrica());
            listarRubricas();
        }
    }
    
    private void listarRubricas() {
        pnlRubricas.removeAll();
        GridBagConstraints gbl = new GridBagConstraints();
        AtomicInteger i = new AtomicInteger(0);
        Insets margin = new Insets(5, 5, 5, 5);
        rubricas.forEach(r -> {
            r.setNumeroRubrica(rubricas.indexOf(r) + 1);
            JPanel panel = new CRubrica(r, frmAgregarMatricula).getElementRubrica();
            gbl.gridx = 0;
            gbl.gridy = i.getAndIncrement();
            gbl.fill = GridBagConstraints.HORIZONTAL;
            gbl.anchor = GridBagConstraints.NORTH;
            gbl.weightx = 1.0;
            gbl.insets = margin;
            pnlRubricas.add(panel, gbl);
        });
        gbl.gridx = 0;
        gbl.gridy = i.get();
        gbl.weighty = 1.0;
        pnlRubricas.add(new JPanel(), gbl);
        pnlRubricas.updateUI();
    }
    
    private void agregarMatricula() {
        float peso = 0;
        for (Rubrica r : rubricas) peso = peso + r.getPeso();
        rubricas.forEach(r -> matricula.getRubricas().add(r));
        if(cboCursos.getSelectedIndex() != -1 && cboProfesores.getSelectedIndex() != -1){
            if (!matricula.getRubricas().isEmpty()) {
                if (peso == 1) {
                    matricula.setCurso(cursos.get(cboCursos.getSelectedIndex()));
                    matricula.setProfesor(profesores.get(cboProfesores.getSelectedIndex()));
                    try {
                        matricula.agregar();
                        frmAgregarMatricula.dispose();
                    } catch (SQLException e) {
                        switch (Integer.valueOf(e.getSQLState())){
                            case 23505:
                                JOptionPane.showMessageDialog(frmAgregarMatricula, "Matrícula ya registrada", "Error al registrar", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                System.err.println("Otro error");
                                System.err.println(Integer.valueOf(e.getSQLState()));
                                break;
                        }
                    }
                } else JOptionPane.showMessageDialog(frmAgregarMatricula, "Ingrese correctamente los pesos", "Error al registrar", JOptionPane.ERROR_MESSAGE);
            } else JOptionPane.showMessageDialog(frmAgregarMatricula, "Ingrese rúbricas", "Error al registrar", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(frmAgregarMatricula, "Seleccione un curso o un profesor", "Error al registrar", JOptionPane.ERROR_MESSAGE);
    }
    
    private void modificarMatricula() {
        matricula.setProfesor(profesores.get(cboProfesores.getSelectedIndex()));
        ArrayList<Rubrica> rub = Rubrica.listar(matricula);
        float peso = 0;
        for (Rubrica r : rubricas) peso = peso + r.getPeso();
        if (peso == 1) {
            AtomicInteger i = new AtomicInteger();
            rubricas.forEach(r -> {
                try {
                    Rubrica r1 = rub.get(i.getAndIncrement());
                    if (!r1.getNombre().equals(r.getNombre()) 
                            || r1.getPeso() != r.getPeso()) {
                        try {
                            r.actualizar();
                        } catch (SQLException e) {
                        }
                    }
                    if (r1.getNotas().size() != r.getNotas().size()) {
                        try {
                            for (Nota n : r1.getNotas()) n.eliminar();
                            for (Nota n : r.getNotas()) n.agregar();
                        } catch (SQLException e) {
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException g) {
                    r.setMatricula(matricula);
                    try {
                        r.agregar();
                        for (Nota n : r.getNotas()) n.agregar();
                    } catch (SQLException e) {
                    }
                }
            });
            if (rub.size() > rubricas.size()) {
                try {
                    for (int j = rubricas.size(); j < rub.size(); j++) {
                        Rubrica r = rub.get(j);
                        for (Nota n : r.getNotas()) n.eliminar();
                        r.eliminar();
                    }
                } catch (SQLException e) {
                }
            }
            matricula.getRubricas().clear();
            rubricas.forEach(r ->matricula.getRubricas().add(r));
            if ((matricula.getProfesor().getApellidos() + ", " + matricula.getProfesor().getNombre()).equals(cboProfesores.getSelectedItem().toString())){
                try {
                    matricula.actualizar();
                } catch (SQLException ex) {
                }
            }
            frmAgregarMatricula.dispose();
        } else JOptionPane.showMessageDialog(frmAgregarMatricula, "Ingrese correctamente los pesos", "Error al registrar", JOptionPane.ERROR_MESSAGE);
    }
    
}
