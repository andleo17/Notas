
package com.andres.notas.view;

public class FrmAgregarMatricula extends javax.swing.JDialog {

    public FrmAgregarMatricula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblCursos = new javax.swing.JLabel();
        cboCursos = new javax.swing.JComboBox<>();
        lblProfesores = new javax.swing.JLabel();
        cboProfesores = new javax.swing.JComboBox<>();
        btnAgregarMatricula = new javax.swing.JButton();
        btnAgregarRubrica = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlRubricas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlFondo.setBackground(new java.awt.Color(243, 243, 243));
        pnlFondo.setPreferredSize(new java.awt.Dimension(800, 400));
        pnlFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblCursos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lblCursos.setText("Seleccionar Curso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 10, 0);
        jPanel1.add(lblCursos, gridBagConstraints);

        cboCursos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel1.add(cboCursos, gridBagConstraints);

        lblProfesores.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lblProfesores.setText("Seleccionar Profesor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 10, 0);
        jPanel1.add(lblProfesores, gridBagConstraints);

        cboProfesores.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel1.add(cboProfesores, gridBagConstraints);

        btnAgregarMatricula.setBackground(new java.awt.Color(204, 0, 0));
        btnAgregarMatricula.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnAgregarMatricula.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMatricula.setText("Registrar Matrícula");
        btnAgregarMatricula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        jPanel1.add(btnAgregarMatricula, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        pnlFondo.add(jPanel1, gridBagConstraints);

        btnAgregarRubrica.setBackground(new java.awt.Color(204, 0, 0));
        btnAgregarRubrica.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnAgregarRubrica.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarRubrica.setText("Agregrar Rúbrica");
        btnAgregarRubrica.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 0, 0);
        pnlFondo.add(btnAgregarRubrica, gridBagConstraints);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlRubricas.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(pnlRubricas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 20, 20);
        pnlFondo.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pnlFondo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMatricula;
    private javax.swing.JButton btnAgregarRubrica;
    private javax.swing.JComboBox<String> cboCursos;
    private javax.swing.JComboBox<String> cboProfesores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCursos;
    private javax.swing.JLabel lblProfesores;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlRubricas;
    // End of variables declaration//GEN-END:variables
}
