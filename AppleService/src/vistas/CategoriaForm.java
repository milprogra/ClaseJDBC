/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AccesoCategoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mjara
 */
public class CategoriaForm extends javax.swing.JInternalFrame {
    
    AccesoCategoria categoria = new AccesoCategoria();
    DefaultTableModel tm;
    int fila;
    int id;
    
    /**
     * Creates new form CategoriaForm
     */
    public CategoriaForm() {
        initComponents();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categoria");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        jLabel1.setText("Nombre");

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
      tm = (DefaultTableModel) tblCategoria.getModel();
        int sel = JOptionPane.showConfirmDialog(rootPane,"¿seguro que quieres Modificar?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (sel==0) {
           String nombre = txtNombre.getText();
            try {
                categoria.actualizarCategoria(id, nombre);
                tm.setValueAt(nombre, fila, 1);
                tblCategoria.setModel(tm);
                JOptionPane.showMessageDialog(rootPane,"Modificado con exito!","Guardado",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
            }
        }  
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int sel = JOptionPane.showConfirmDialog(rootPane,"¿seguro que quieres guardar?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (sel==0) {
           String nombre = txtNombre.getText();
            try {
                categoria.ingresarCategoria(nombre);
                eliminarTabla();
                JOptionPane.showMessageDialog(rootPane,"Guardado con exito!","Guardado",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al Guardar","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked

        fila = tblCategoria.getSelectedRow();
        tm = (DefaultTableModel) tblCategoria.getModel();
        id = Integer.parseInt(tm.getValueAt(fila, 0).toString());
        txtNombre.setText(tm.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_tblCategoriaMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tm = (DefaultTableModel) tblCategoria.getModel();
        int sel = JOptionPane.showConfirmDialog(rootPane,"¿seguro que quieres eliminar?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (sel==0) {
            try {
                categoria.eliminarCategoria(id);
                tm.removeRow(fila);
                tblCategoria.setModel(tm);
                JOptionPane.showMessageDialog(rootPane,"Eliminado con exito!","Eliminar",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al eliminar","Error",JOptionPane.ERROR_MESSAGE);
            }
        }    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode()== evt.VK_ENTER) {
            tm = (DefaultTableModel) tblCategoria.getModel();
            ResultSet rs = categoria.existenciaNombre(txtNombre.getText());
            eliminarTabla2();
            try {
                while (rs.next()) {
                    int id= rs.getInt("id");
                    String nombre= rs.getString("nombre");
                    tm.addRow(new Object[]{id,nombre});
                }
                tblCategoria.setModel(tm);
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtNombreKeyPressed
    
    private void cargarTabla(){
        tm = (DefaultTableModel) tblCategoria.getModel();
        ResultSet rs = categoria.listarCategoria();
        try {
            while (rs.next()) {
               int id = rs.getInt("id");
               String nombre = rs.getString("nombre");
               tm.addRow(new Object[]{id,nombre});
            }
            tblCategoria.setModel(tm);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void eliminarTabla(){
        int total = tblCategoria.getRowCount();
        tm = (DefaultTableModel) tblCategoria.getModel();
        for (int i = total-1; i >= 0; i--) {
            tm.removeRow(i);
        }
        cargarTabla();
    }
     private void eliminarTabla2(){
        int total = tblCategoria.getRowCount();
        tm = (DefaultTableModel) tblCategoria.getModel();
        for (int i = total-1; i >= 0; i--) {
            tm.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
