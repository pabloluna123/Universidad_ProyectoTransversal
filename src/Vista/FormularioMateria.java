/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.MateriaData;
import Modelo.Materia;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class FormularioMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioMateria
     */
    
    private MateriaData data;
    
    public FormularioMateria() {
        initComponents();
        data = new MateriaData();
    }
    
    public void activarCampos() {
        jtfLegajo.setEnabled(true);
        jtfNombre.setEnabled(true);
        jtfAño.setEnabled(true);
        jcbEstado.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbGuardar.setEnabled(true);
    }
    
    public void desactivarCampos() {
        jtfLegajo.setEnabled(false);
        jtfNombre.setEnabled(false);
        jtfAño.setEnabled(false);
        jcbEstado.setEnabled(false);
        jbBuscar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbActualizar.setEnabled(false);
    }
    
    private void limpiarCampos() {
        jtfNombre.setText("");
        jtfAño.setText("");
        jcbEstado.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoDePantallajPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfLegajo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfAño = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JCheckBox();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(204, 204, 255));
        setVisible(true);

        fondoDePantallajPanel.setBackground(new java.awt.Color(153, 153, 255));
        fondoDePantallajPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Formulario Materia");
        fondoDePantallajPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 237, 35));

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Legajo");
        fondoDePantallajPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 68, -1));

        jtfLegajo.setBackground(new java.awt.Color(102, 102, 255));
        jtfLegajo.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jtfLegajo.setForeground(new java.awt.Color(255, 255, 255));
        jtfLegajo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtfLegajo.setEnabled(false);
        fondoDePantallajPanel.add(jtfLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 154, 23));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");
        fondoDePantallajPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 84, 27));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Año");
        fondoDePantallajPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 73, 28));

        jtfNombre.setBackground(new java.awt.Color(102, 102, 255));
        jtfNombre.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jtfNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtfNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtfNombre.setEnabled(false);
        fondoDePantallajPanel.add(jtfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 154, 27));

        jtfAño.setBackground(new java.awt.Color(102, 102, 255));
        jtfAño.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jtfAño.setForeground(new java.awt.Color(255, 255, 255));
        jtfAño.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtfAño.setEnabled(false);
        fondoDePantallajPanel.add(jtfAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 153, 28));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estado");
        fondoDePantallajPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jcbEstado.setBackground(new java.awt.Color(153, 153, 255));
        jcbEstado.setForeground(new java.awt.Color(102, 102, 255));
        jcbEstado.setEnabled(false);
        fondoDePantallajPanel.add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jbGuardar.setBackground(new java.awt.Color(102, 102, 255));
        jbGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jbGuardar.setText("Guardar");
        jbGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbGuardar.setEnabled(false);
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        fondoDePantallajPanel.add(jbGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        jbActualizar.setBackground(new java.awt.Color(102, 102, 255));
        jbActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbActualizar.setText("Actualizar");
        jbActualizar.setEnabled(false);
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });
        fondoDePantallajPanel.add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        jbNuevo.setBackground(new java.awt.Color(102, 102, 255));
        jbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbNuevo.setText("Nuevo");
        jbNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });
        fondoDePantallajPanel.add(jbNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        jbSalir.setBackground(new java.awt.Color(102, 102, 255));
        jbSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        fondoDePantallajPanel.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 70, -1));

        jbBuscar.setBackground(new java.awt.Color(102, 102, 255));
        jbBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("Buscar");
        jbBuscar.setEnabled(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        fondoDePantallajPanel.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 88, 27));
        fondoDePantallajPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 390, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoDePantallajPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoDePantallajPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
         if ( jtfNombre.getText().equals("") || jtfAño.getText().equals("") ||  !(jcbEstado.isSelected())) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos exepto legajo");
        } else {
            
        
            String nombre = jtfNombre.getText();
            int anio = Integer.parseInt(jtfAño.getText());
            boolean estado = jcbEstado.isSelected();
            
            Materia m = new Materia(anio,nombre,estado); 
            
            m.setNombre(nombre);
            m.setAnio(anio);
            m.setEstado(estado);

            data.guardarMateria(m);
            limpiarCampos();
            desactivarCampos();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        
        int legajo = Integer.parseInt(jtfLegajo.getText());
        String nombre = jtfNombre.getText();
        int anio = Integer.parseInt(jtfAño.getText());
        boolean estado = jcbEstado.isSelected();

        Materia m = new Materia (legajo,anio,nombre,estado);
        
        data.ActualizarMateria(m);
        limpiarCampos();
        desactivarCampos();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        activarCampos();
        jbActualizar.setEnabled(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
         try { 
         
         int legajo = Integer.parseInt(jtfLegajo.getText());

         Materia m = data.BuscarMateriaXId(legajo);  
               
         if (m.getAnio() > 0){
                    
                        jtfNombre.setText(m.getNombre());
                        jtfAño.setText(m.getAnio()+ "");
                        jcbEstado.setSelected(m.isEstado());
                        jbActualizar.setEnabled(true);
                        jbGuardar.setEnabled(false);
         }  else{
             JOptionPane.showMessageDialog(this, " materia no encontrada");
             jtfLegajo.requestFocus();
             limpiarCampos();
             
         } 
         }  catch (NumberFormatException ex){JOptionPane.showMessageDialog(this, "debe ingresar un número");
            jtfLegajo.setText("");
            jtfLegajo.requestFocus();
            limpiarCampos();
            }  
    }//GEN-LAST:event_jbBuscarActionPerformed
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoDePantallajPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JTextField jtfAño;
    private javax.swing.JTextField jtfLegajo;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
