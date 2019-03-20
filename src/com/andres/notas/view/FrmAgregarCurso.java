
package com.andres.notas.view;

public class FrmAgregarCurso extends javax.swing.JDialog {

    public FrmAgregarCurso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        pnlContenido = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblNumeroCreditos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        txtNumeroCreditos = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 450));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlFondo.setBackground(new java.awt.Color(245, 245, 245));
        pnlFondo.setLayout(new java.awt.GridBagLayout());

        pnlContenido.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        pnlContenido.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        pnlContenido.add(lblNombre, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        pnlContenido.add(txtNombre, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        pnlContenido.add(jSeparator1, gridBagConstraints);

        lblNumeroCreditos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblNumeroCreditos.setText("N° de créditos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        pnlContenido.add(lblNumeroCreditos, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        pnlContenido.add(jSeparator2, gridBagConstraints);

        btnAgregar.setBackground(new java.awt.Color(204, 0, 0));
        btnAgregar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregar.setMargin(new java.awt.Insets(0, 15, 0, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        pnlContenido.add(btnAgregar, gridBagConstraints);

        txtNumeroCreditos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNumeroCreditos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtNumeroCreditos.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtNumeroCreditos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtNumeroCreditos.setValue(new Integer(0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        pnlContenido.add(txtNumeroCreditos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(40, 20, 30, 20);
        pnlFondo.add(pnlContenido, gridBagConstraints);

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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroCreditos;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtNumeroCreditos;
    // End of variables declaration//GEN-END:variables
}
