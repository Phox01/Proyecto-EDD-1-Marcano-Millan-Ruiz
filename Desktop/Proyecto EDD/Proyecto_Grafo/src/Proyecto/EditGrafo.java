/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import static Proyecto.ImportMenu.grafo;
import javax.swing.JOptionPane;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class EditGrafo extends javax.swing.JFrame {

    private Archivotexto archivo = new Archivotexto();
    static Grafo grafo;

    /**
     * Creates new form OptionSelection
     */
    public EditGrafo(Grafo grafo) {
        initComponents();
        this.grafo = grafo;
        setLocationRelativeTo(null);

        Almacen pointer = grafo.getLista().getFirst();

        while (pointer != null) {

            option1.addItem(pointer.getName());
            option2.addItem(pointer.getName());

            pointer = pointer.getNext();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        show = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        input = new javax.swing.JTextField();
        option1 = new javax.swing.JComboBox<>();
        option2 = new javax.swing.JComboBox<>();
        adybutton = new javax.swing.JButton();
        addnodo = new javax.swing.JButton();
        inputnodo = new javax.swing.JTextField();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Sistemas Shop");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, -1));

        show.setText("Mostrar Adyacencias");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        jPanel1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, 200));

        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        jPanel1.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 50, -1));

        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });
        jPanel1.add(option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 60, 20));

        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        jPanel1.add(option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 60, 20));

        adybutton.setText("Agregar Adyacencia");
        adybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adybuttonActionPerformed(evt);
            }
        });
        jPanel1.add(adybutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        addnodo.setText("Agregar Almacen");
        addnodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnodoActionPerformed(evt);
            }
        });
        jPanel1.add(addnodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        jPanel1.add(inputnodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/pixels-video-games-wallpaper-preview.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 490, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        output.setText(grafo.printAdy());
    }//GEN-LAST:event_showActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
    }//GEN-LAST:event_option2ActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
    }//GEN-LAST:event_inputActionPerformed

    private void adybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adybuttonActionPerformed
        String mensaje1 = "";
        String mensaje2 = "";
        String number = "";

        mensaje1 = option1.getSelectedItem().toString();
        mensaje2 = option2.getSelectedItem().toString();
        number = input.getText();

        //Confirmar que es número
        boolean value = false;
        try {
            Integer.parseInt(number);
            value = true;
        } catch (Exception e) {
            value = false;
            JOptionPane.showMessageDialog(null, "El valor que ingresa no es numérico");
        }

        if (mensaje1.equals(mensaje2) || number.equals("0") || number.equals(" ") || number.equals("") || value == false) {
            JOptionPane.showMessageDialog(null, "No se puede hacer esa adyacencia");
            EditGrafo window2 = new EditGrafo(grafo);
            window2.show();
            this.dispose();
        } else {
            grafo.AddArco(grafo.returnNodoInIndex(mensaje1), grafo.returnNodoInIndex(mensaje2), Integer.parseInt(number));
            JOptionPane.showMessageDialog(null, "Adyacencia hecha");
            output.setText(grafo.printAdy());
            input.setText("");

        }


    }//GEN-LAST:event_adybuttonActionPerformed

    private void addnodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnodoActionPerformed
        try {
            String name = inputnodo.getText();
            Almacen aux = grafo.getLista().getFirst();
            boolean value = true;
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                if (aux.getName().toLowerCase().equals(name.toLowerCase())) {
                    JOptionPane.showMessageDialog(null, "Ese Almacen ya está creado");
                    inputnodo.setText("");
                    value = false;
                    break;
                }
                aux = aux.getNext();
            }
            if (value == true) {
                grafo.aumentarVerticesInsertar(name, new Stocklist());
                output.setText(grafo.printAdy());
                option1.addItem(name);
                option2.addItem(name);
                inputnodo.setText("");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }


    }//GEN-LAST:event_addnodoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

        OptionSelection window2 = new OptionSelection(grafo);
        window2.show();
        this.dispose();

    }//GEN-LAST:event_salirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditGrafo(grafo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnodo;
    private javax.swing.JButton adybutton;
    private javax.swing.JTextField input;
    private javax.swing.JTextField inputnodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> option1;
    private javax.swing.JComboBox<String> option2;
    private javax.swing.JTextArea output;
    private javax.swing.JButton salir;
    private javax.swing.JButton show;
    // End of variables declaration//GEN-END:variables
}
