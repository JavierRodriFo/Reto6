
package crud.frames.Bicicleta;

import EmpresaDao.DAOException;
import EmpresaDao.DaoManager;
import EmpresaDao.mysql.MySQLDaoManager;
import Modelo.Bicicleta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class ListaBicicletasFrame extends javax.swing.JFrame {

    private DaoManager manager;
    
    private BicicletaTableModel model;
    
    public ListaBicicletasFrame(DaoManager manager) throws DAOException{
        initComponents();
        this.manager = manager;
        this.model = new BicicletaTableModel(manager.getBicicletaDao());
        this.tabla.setModel(model);
        obtenerDatos();
        this.tabla.getSelectionModel().addListSelectionListener(e ->{ 
            boolean seleccionValida =(tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });
        
    }
      final void obtenerDatos() throws DAOException{
        progreso.setText("Actualizando Modelo...");
        model.updateModel();
        model.fireTableDataChanged();
        progreso.setText(model.getRowCount()+"fabricantes visibles");
        
    }
    

    
     private Bicicleta getBicicletaSeleccionada() throws DAOException{
        Long id = (Long) tabla.getValueAt(tabla.getSelectedRow(), 0);
        
        return manager.getBicicletaDao().obtener(id);
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        add = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        editar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        borrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        cancelar = new javax.swing.JButton();
        progreso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new crud.frames.Bicicleta.DetalleBicicletaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Bicicleta");

        jToolBar1.setRollover(true);

        add.setText("Nuevo");
        add.setFocusable(false);
        add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jToolBar1.add(add);
        jToolBar1.add(jSeparator1);

        editar.setText("Editar");
        editar.setEnabled(false);
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jToolBar1.add(editar);
        jToolBar1.add(jSeparator2);

        borrar.setText("Borrar");
        borrar.setEnabled(false);
        borrar.setFocusable(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jToolBar1.add(borrar);
        jToolBar1.add(jSeparator3);

        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);
        jToolBar1.add(jSeparator4);

        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelar);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        progreso.setText("Preparado");
        progreso.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        getContentPane().add(progreso, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        detalle.setBicicleta(null);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_addActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            Bicicleta bicicleta = getBicicletaSeleccionada();
            detalle.setBicicleta(bicicleta);
            detalle.loadData();
            detalle.setEditable(true);
            guardar.setEnabled(true); 
            cancelar.setEnabled(true);
        } catch (DAOException ex) {
            Logger.getLogger(ListaBicicletasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro q quieres borrar este Bicicleta?", 
                "Borrar bicicleta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
           
            try {
                Bicicleta aBorrar = getBicicletaSeleccionada();
                manager.getBicicletaDao().eliminar(aBorrar);
                obtenerDatos();
                tabla.clearSelection();
                editar.setEnabled(false);
                borrar.setEnabled(false);
                guardar.setEnabled(false); 
                cancelar.setEnabled(false);
            } catch (DAOException ex) {
                Logger.getLogger(ListaBicicletasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalle.setBicicleta(null);
        detalle.setEditable(false);
        detalle.loadData();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
       try{
        detalle.saveData();
        Bicicleta bic = detalle.getBicicleta();
        if(bic.getId()==null){
           manager.getBicicletaDao().insertar(bic);
        }else{
            
                manager.getBicicletaDao().modificar(bic);
        }
               obtenerDatos();
                detalle.setBicicleta(null);
                detalle.setEditable(false);
                detalle.loadData();
                tabla.clearSelection();
                guardar.setEnabled(false);
                cancelar.setEnabled(false);
                
                getBicicletaSeleccionada();
                model.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(ListaBicicletasFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_guardarActionPerformed


    public static void main(String args[]) throws SQLException {
         DaoManager manager = new MySQLDaoManager("localhost:3306", "ecodosruedas_ltda", "root", "123456");
       
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ListaBicicletasFrame(manager).setVisible(true);
            } catch (DAOException ex) {
                Logger.getLogger(ListaBicicletasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private crud.frames.Bicicleta.DetalleBicicletaPanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel progreso;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
