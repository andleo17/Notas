
package com.andres.notas.view;

public class FrmCambiarPassword extends javax.swing.JDialog {

    public FrmCambiarPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblPasswordActual = new javax.swing.JLabel();
        txtPasswordActual = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        lblPasswordNuevo = new javax.swing.JLabel();
        txtPasswordNuevo = new javax.swing.JPasswordField();
        sprPassword = new javax.swing.JSeparator();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        sprConfirmPassword = new javax.swing.JSeparator();
        btnCambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlFondo.setBackground(new java.awt.Color(245, 245, 245));
        pnlFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblEmail.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblEmail, gridBagConstraints);

        txtEmail.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtEmail, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(jSeparator1, gridBagConstraints);

        lblPasswordActual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblPasswordActual.setText("Contraseña Actual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblPasswordActual, gridBagConstraints);

        txtPasswordActual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtPasswordActual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPasswordActual.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtPasswordActual, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(jSeparator2, gridBagConstraints);

        lblPasswordNuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblPasswordNuevo.setText("Nueva Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblPasswordNuevo, gridBagConstraints);

        txtPasswordNuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtPasswordNuevo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtPasswordNuevo, gridBagConstraints);

        sprPassword.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(sprPassword, gridBagConstraints);

        lblConfirmPassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        lblConfirmPassword.setText("Repetir Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        jPanel1.add(lblConfirmPassword, gridBagConstraints);

        txtConfirmPassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 50);
        jPanel1.add(txtConfirmPassword, gridBagConstraints);

        sprConfirmPassword.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 15, 50);
        jPanel1.add(sprConfirmPassword, gridBagConstraints);

        btnCambiar.setBackground(new java.awt.Color(204, 0, 0));
        btnCambiar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        btnCambiar.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar.setText("Cambiar contraseña");
        btnCambiar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCambiar.setMargin(new java.awt.Insets(2, 15, 2, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPanel1.add(btnCambiar, gridBagConstraints);

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
    private javax.swing.JButton btnCambiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPasswordActual;
    private javax.swing.JLabel lblPasswordNuevo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JSeparator sprConfirmPassword;
    private javax.swing.JSeparator sprPassword;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPasswordActual;
    private javax.swing.JPasswordField txtPasswordNuevo;
    // End of variables declaration//GEN-END:variables
}
