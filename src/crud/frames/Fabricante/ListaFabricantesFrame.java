
package crud.frames.Fabricante;

import EmpresaDao.DAOException;
import EmpresaDao.DaoManager;
import EmpresaDao.mysql.MySQLDaoManager;
import Modelo.Fabricante;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ListaFabricantesFrame extends javax.swing.JFrame {
    
    private DaoManager manager;
    
    private FabricanteTableModel model;
    
    public ListaFabricantesFrame(DaoManager manager) throws DAOException{
        initComponents();
        this.manager = manager;
        this.model = new FabricanteTableModel(manager.getFabricanteDao());
        obtenerDatos();
        this.tabla.setModel(model);
        this.tabla.getSelectionModel().addListSelectionListener(e ->{
            boolean seleccionValida =(tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });
    }
    
    final void obtenerDatos() throws DAOException{
        progreso.setText("Actualizando Modelo...");
        model.updateModel();
        progreso.setText(model.getRowCount()+"fabricantes visibles");
        
    }
    

    @SuppressWarnings("unchecked")
    
    private Fabricante getFabricanteSeleccionado() throws DAOException{
        Long id = (Long) tabla.getValueAt(tabla.getSelectedRow(), 0);
        
        return manager.getFabricanteDao().obtener(id);
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        toolbar = new javax.swing.JToolBar();
        add = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new crud.frames.Fabricante.DetalleFabricantePanel();
        progreso = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolbar.setRollover(true);

        add.setText("Nuevo");
        add.setFocusable(false);
        add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        toolbar.add(add);

        editar.setText("Editar");
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        toolbar.add(editar);

        borrar.setText("Borrar");
        borrar.setFocusable(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        toolbar.add(borrar);

        guardar.setText("Guardar");
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        toolbar.add(guardar);

        cancelar.setText("Cancelar");
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        toolbar.add(cancelar);

        getContentPane().add(toolbar, java.awt.BorderLayout.PAGE_START);

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
        jPanel1.add(detalle, java.awt.BorderLayout.PAGE_START);

        progreso.setText("jLabel1");
        jPanel1.add(progreso, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            Fabricante fabricante = getFabricanteSeleccionado();
            detalle.setFabricante(fabricante); 
            detalle.setEditable(true);
            detalle.loadData();
            guardar.setEnabled(true);
            cancelar.setEnabled(true);
            
        } catch (DAOException ex) {
            Logger.getLogger(ListaFabricantesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalle.setFabricante(null);
        detalle.setEditable(false);
        detalle.loadData();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        detalle.setFabricante(null);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_addActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
     try{
        detalle.saveData();
        Fabricante fab = detalle.getFabricante();
        if(fab.getId()==null){
           manager.getFabricanteDao().insertar(fab);
        }else{
            
                manager.getFabricanteDao().modificar(fab);
        }
                detalle.setFabricante(null);
                detalle.setEditable(false);
                detalle.loadData();
                tabla.clearSelection();
                guardar.setEnabled(false);
                cancelar.setEnabled(false);
                
                obtenerDatos();
                model.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(ListaFabricantesFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro q quieres borrar este fabricante?", 
                "Borrar fabricante", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            try {
                Fabricante fabricante = getFabricanteSeleccionado();
                manager.getFabricanteDao().eliminar(fabricante);
                obtenerDatos();
                model.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(ListaFabricantesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_borrarActionPerformed

    
    public static void main(String args[]) throws SQLException {
        DaoManager manager = new MySQLDaoManager("localhost:3306", "ecodosruedas_ltda", "root", "123456");
       
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ListaFabricantesFrame(manager).setVisible(true);
            } catch (DAOException ex) {
                Logger.getLogger(ListaFabricantesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private crud.frames.Fabricante.DetalleFabricantePanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel progreso;
    private javax.swing.JTable tabla;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
}
