
package com.andres.notas.view;

public class FrmAgregarMatricula extends javax.swing.JDialog {

    public FrmAgregarMatricula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        btnAgregarRubrica = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cboProfesores = new javax.swing.JComboBox<>();
        cboCursos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregarMatricula = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlRubricas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlFondo.setBackground(new java.awt.Color(243, 243, 243));

        btnAgregarRubrica.setBackground(new java.awt.Color(204, 0, 0));
        btnAgregarRubrica.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnAgregarRubrica.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarRubrica.setText("Agregrar Rúbrica");
        btnAgregarRubrica.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboProfesores.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jPanel1.add(cboProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 125, 260, -1));

        cboCursos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jPanel1.add(cboCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 58, 260, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setText("Seleccionar Curso:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 31, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel2.setText("Seleccionar Profesor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 98, -1, -1));

        btnAgregarMatricula.setBackground(new java.awt.Color(204, 0, 0));
        btnAgregarMatricula.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnAgregarMatricula.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMatricula.setText("Registrar Matrícula");
        btnAgregarMatricula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(btnAgregarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 160, 30));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlRubricas.setLayout(new java.awt.GridLayout(0, 1, 3, 5));
        jScrollPane2.setViewportView(pnlRubricas);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnAgregarRubrica, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 279, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnAgregarRubrica, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMatricula;
    private javax.swing.JButton btnAgregarRubrica;
    private javax.swing.JComboBox<String> cboCursos;
    private javax.swing.JComboBox<String> cboProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlRubricas;
    // End of variables declaration//GEN-END:variables
}
