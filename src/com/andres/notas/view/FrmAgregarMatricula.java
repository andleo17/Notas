
package com.andres.notas.view;

public class FrmAgregarMatricula extends javax.swing.JFrame {

    public FrmAgregarMatricula() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboCursos = new javax.swing.JComboBox<>();
        btnAgregarCurso = new javax.swing.JButton();
        btnModificarCurso = new javax.swing.JButton();
        btnQuitarCurso = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboProfesores = new javax.swing.JComboBox<>();
        btnAgregarProfesor = new javax.swing.JButton();
        btnModificarProfesor = new javax.swing.JButton();
        btnQuitarProfesor = new javax.swing.JButton();
        btnAgregarRubrica = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRubricas = new javax.swing.JTable();
        btnAgregarMatricula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccionar Curso:");

        btnAgregarCurso.setText("Agregar");

        btnModificarCurso.setText("Modificar");

        btnQuitarCurso.setText("Quitar");

        jLabel2.setText("Seleccionar Profesor:");

        btnAgregarProfesor.setText("Agregar");

        btnModificarProfesor.setText("Modificar");

        btnQuitarProfesor.setText("Quitar");

        btnAgregarRubrica.setText("Agregrar Rúbrica");

        tblRubricas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Rúbrica", "Nombre", "Peso", "N° Notas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRubricas);
        if (tblRubricas.getColumnModel().getColumnCount() > 0) {
            tblRubricas.getColumnModel().getColumn(0).setResizable(false);
            tblRubricas.getColumnModel().getColumn(1).setResizable(false);
            tblRubricas.getColumnModel().getColumn(3).setResizable(false);
        }

        btnAgregarMatricula.setText("Agregar Matrícula");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarCurso)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarCurso)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitarCurso))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarProfesor)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarProfesor)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitarProfesor))
                            .addComponent(btnAgregarRubrica))
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(btnAgregarMatricula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCurso)
                    .addComponent(btnModificarCurso)
                    .addComponent(btnQuitarCurso))
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProfesor)
                    .addComponent(btnModificarProfesor)
                    .addComponent(btnQuitarProfesor))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarRubrica)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnAgregarMatricula)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCurso;
    private javax.swing.JButton btnAgregarMatricula;
    private javax.swing.JButton btnAgregarProfesor;
    private javax.swing.JButton btnAgregarRubrica;
    private javax.swing.JButton btnModificarCurso;
    private javax.swing.JButton btnModificarProfesor;
    private javax.swing.JButton btnQuitarCurso;
    private javax.swing.JButton btnQuitarProfesor;
    private javax.swing.JComboBox<String> cboCursos;
    private javax.swing.JComboBox<String> cboProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblRubricas;
    // End of variables declaration//GEN-END:variables
}
