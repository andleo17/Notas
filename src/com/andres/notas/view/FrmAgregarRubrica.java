
package com.andres.notas.view;

public class FrmAgregarRubrica extends javax.swing.JDialog {

    public FrmAgregarRubrica(java.awt.Window parent, ModalityType modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblNumeroNotas = new javax.swing.JLabel();
        txtNumeroNotas = new javax.swing.JTextField();
        lblPorcentaje = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 450));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlFondo.setBackground(new java.awt.Color(245, 245, 245));
        pnlFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblNombre, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtNombre, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(jSeparator1, gridBagConstraints);

        lblPeso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblPeso.setText("Peso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblPeso, gridBagConstraints);

        txtPeso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtPeso.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPeso.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtPeso, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(jSeparator2, gridBagConstraints);

        lblNumeroNotas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblNumeroNotas.setText("N° de notas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblNumeroNotas, gridBagConstraints);

        txtNumeroNotas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtNumeroNotas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNumeroNotas.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtNumeroNotas, gridBagConstraints);

        lblPorcentaje.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lblPorcentaje.setText("%");
        lblPorcentaje.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 50);
        jPanel1.add(lblPorcentaje, gridBagConstraints);

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(jSeparator3, gridBagConstraints);

        btnAgregar.setBackground(new java.awt.Color(204, 0, 0));
        btnAgregar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregar.setMargin(new java.awt.Insets(2, 15, 2, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPanel1.add(btnAgregar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(40, 20, 30, 20);
        pnlFondo.add(jPanel1, gridBagConstraints);

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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroNotas;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroNotas;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
