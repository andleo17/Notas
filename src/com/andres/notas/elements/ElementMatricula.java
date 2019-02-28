
package com.andres.notas.elements;

public class ElementMatricula extends javax.swing.JPanel {

    public ElementMatricula() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblCurso = new javax.swing.JLabel();
        lblProfesor = new javax.swing.JLabel();
        lblPromedio = new javax.swing.JLabel();
        lblNotas = new javax.swing.JLabel();
        lblProfesor1 = new javax.swing.JLabel();
        lblProfesor2 = new javax.swing.JLabel();
        lblProfesor3 = new javax.swing.JLabel();
        btnDetalles = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 243, 243));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        setMinimumSize(new java.awt.Dimension(354, 120));
        setPreferredSize(new java.awt.Dimension(354, 120));
        setLayout(new java.awt.GridBagLayout());

        lblCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        lblCurso.setText("Curso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        add(lblCurso, gridBagConstraints);

        lblProfesor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblProfesor.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor.setText("Profesor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblProfesor, gridBagConstraints);

        lblPromedio.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblPromedio.setForeground(new java.awt.Color(102, 102, 102));
        lblPromedio.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblPromedio, gridBagConstraints);

        lblNotas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblNotas.setForeground(new java.awt.Color(102, 102, 102));
        lblNotas.setText("x / y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblNotas, gridBagConstraints);

        lblProfesor1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        lblProfesor1.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor1.setText("Profesor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblProfesor1, gridBagConstraints);

        lblProfesor2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        lblProfesor2.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor2.setText("Promedio Final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblProfesor2, gridBagConstraints);

        lblProfesor3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        lblProfesor3.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor3.setText("N. Faltantes/N. Completas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblProfesor3, gridBagConstraints);

        btnDetalles.setBackground(new java.awt.Color(255, 255, 255));
        btnDetalles.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        btnDetalles.setText("Ver detalles");
        btnDetalles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDetalles.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(btnDetalles, gridBagConstraints);

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnModificar.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(btnModificar, gridBagConstraints);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminar.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(btnEliminar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JLabel lblProfesor1;
    private javax.swing.JLabel lblProfesor2;
    private javax.swing.JLabel lblProfesor3;
    private javax.swing.JLabel lblPromedio;
    // End of variables declaration//GEN-END:variables
}
