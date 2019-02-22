
package com.andres.notas.elements;

public class ElementMatricula extends javax.swing.JPanel {

    public ElementMatricula() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        lblCurso = new javax.swing.JLabel();
        lblProfesor = new javax.swing.JLabel();
        lblPromedio = new javax.swing.JLabel();
        lblNotas = new javax.swing.JLabel();
        lblProfesor1 = new javax.swing.JLabel();
        lblProfesor2 = new javax.swing.JLabel();
        lblProfesor3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnModificar.setFocusPainted(false);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminar.setFocusPainted(false);

        btnDetalles.setBackground(new java.awt.Color(255, 255, 255));
        btnDetalles.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        btnDetalles.setText("Ver detalles");
        btnDetalles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDetalles.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btnDetalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        lblCurso.setText("Curso");

        lblProfesor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblProfesor.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor.setText("Profesor");

        lblPromedio.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblPromedio.setForeground(new java.awt.Color(102, 102, 102));
        lblPromedio.setText("0");

        lblNotas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblNotas.setForeground(new java.awt.Color(102, 102, 102));
        lblNotas.setText("x / y");

        lblProfesor1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        lblProfesor1.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor1.setText("Profesor:");

        lblProfesor2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        lblProfesor2.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor2.setText("Promedio Final:");

        lblProfesor3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        lblProfesor3.setForeground(new java.awt.Color(102, 102, 102));
        lblProfesor3.setText("N. Faltantes/N. Completas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCurso)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProfesor1)
                            .addComponent(lblProfesor2)
                            .addComponent(lblProfesor3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPromedio)
                            .addComponent(lblProfesor)
                            .addComponent(lblNotas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfesor)
                    .addComponent(lblProfesor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPromedio)
                    .addComponent(lblProfesor2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotas)
                    .addComponent(lblProfesor3))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JLabel lblProfesor1;
    private javax.swing.JLabel lblProfesor2;
    private javax.swing.JLabel lblProfesor3;
    private javax.swing.JLabel lblPromedio;
    // End of variables declaration//GEN-END:variables
}
