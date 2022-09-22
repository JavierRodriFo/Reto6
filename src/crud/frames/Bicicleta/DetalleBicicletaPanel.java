
package crud.frames.Bicicleta;

import Modelo.Bicicleta;


public class DetalleBicicletaPanel extends javax.swing.JPanel {

   
    private Bicicleta bicicleta;
    
    private boolean editable;

    
    public DetalleBicicletaPanel() {
        initComponents();
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        fabricante.setEditable(editable);
        precio.setEditable(editable);
        año.setEditable(editable);
    }
    
    public void loadData(){
        if(bicicleta != null){
             fabricante.setText(Long.toString(bicicleta.getId_Fabrica()));
             precio.setText(Integer.toString(bicicleta.getPrecioUnitario()));
             año.setText(bicicleta.getAño());
        }else{
            fabricante.setText("");
            precio.setText("");
            año.setText("");
        }
        
        fabricante.requestFocus();
    }
    
     public void saveData(){
        if(bicicleta == null){
            bicicleta = new Bicicleta();
        }
        bicicleta.setId_Fabrica(Long.parseLong(fabricante.getText()));
        bicicleta.setPrecioUnitario(Integer.parseInt(precio.getText()));
        bicicleta.setAño(año.getText());
    }
    

   

   

   
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fabricante = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        año = new javax.swing.JTextField();

        jLabel1.setText("Fabricante");

        jLabel2.setText("Precio Unitario");

        jLabel3.setText("Año");

        año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(año, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(precio)
                    .addComponent(fabricante))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField año;
    private javax.swing.JTextField fabricante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
