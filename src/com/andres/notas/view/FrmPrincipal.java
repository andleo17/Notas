
package com.andres.notas.view;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlMenu = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMatriculas = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
        btnProfesores = new javax.swing.JButton();
        pnlContenido = new javax.swing.JPanel();
        pnlFooter = new javax.swing.JPanel();
        lblEstudiante_txt = new javax.swing.JLabel();
        lblEstudiante = new javax.swing.JLabel();
        lblCiclo_txt = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlMenu.setLayout(new java.awt.GridBagLayout());

        pnlLogo.setBackground(new java.awt.Color(213, 0, 0));
        pnlLogo.setLayout(new java.awt.GridBagLayout());

        lblLogo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 35)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setText("Notas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 120);
        pnlLogo.add(lblLogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        pnlMenu.add(pnlLogo, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(241, 241, 241));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnMatriculas.setBackground(new java.awt.Color(245, 245, 245));
        btnMatriculas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnMatriculas.setText("Matrículas");
        btnMatriculas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMatriculas.setBorderPainted(false);
        btnMatriculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMatriculas.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel2.add(btnMatriculas, gridBagConstraints);

        btnCursos.setBackground(new java.awt.Color(245, 245, 245));
        btnCursos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnCursos.setText("Cursos");
        btnCursos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCursos.setBorderPainted(false);
        btnCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCursos.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel2.add(btnCursos, gridBagConstraints);

        btnProfesores.setBackground(new java.awt.Color(245, 245, 245));
        btnProfesores.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnProfesores.setText("Profesores");
        btnProfesores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnProfesores.setBorderPainted(false);
        btnProfesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfesores.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel2.add(btnProfesores, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMenu.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pnlMenu, gridBagConstraints);

        pnlContenido.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(pnlContenido, gridBagConstraints);

        pnlFooter.setBackground(new java.awt.Color(204, 0, 0));
        pnlFooter.setLayout(new java.awt.GridBagLayout());

        lblEstudiante_txt.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lblEstudiante_txt.setForeground(new java.awt.Color(255, 255, 255));
        lblEstudiante_txt.setText("Estudiante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 0);
        pnlFooter.add(lblEstudiante_txt, gridBagConstraints);

        lblEstudiante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        lblEstudiante.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        pnlFooter.add(lblEstudiante, gridBagConstraints);

        lblCiclo_txt.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lblCiclo_txt.setForeground(new java.awt.Color(255, 255, 255));
        lblCiclo_txt.setText("Ciclo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 200, 10, 0);
        pnlFooter.add(lblCiclo_txt, gridBagConstraints);

        lblCiclo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblCiclo.setForeground(new java.awt.Color(255, 255, 255));
        lblCiclo.setText("Ciclo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        pnlFooter.add(lblCiclo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(pnlFooter, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnMatriculas;
    private javax.swing.JButton btnProfesores;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCiclo;
    private javax.swing.JLabel lblCiclo_txt;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblEstudiante_txt;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
