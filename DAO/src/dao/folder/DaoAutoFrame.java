package dao.folder;


import dao.Auto;
import dao.DAOAutoBD;
import dao.DaoException;
import dao.VehiculoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.awt.resources.awt;


public class DaoAutoFrame extends javax.swing.JFrame {

    private DAOAutoBD manager;
    private DaoAutoTableModel model;
    
    
    
    public DaoAutoFrame(DAOAutoBD manager) throws DaoException{
        initComponents();
        this.manager = manager;
        this.model = new DaoAutoTableModel(manager);
        this.model.updateModel();
        this.tabla.setModel(model);
        this.tabla.getSelectionModel().addListSelectionListener(e ->{
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            buscar.setEnabled(seleccionValida);
            eliminar.setEnabled(seleccionValida);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        editar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalleDao = new dao.folder.detalleDao();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolbar.setRollover(true);

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dao/folder/agregar.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.setBorder(null);
        agregar.setContentAreaFilled(false);
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agregar.setVerifyInputWhenFocusTarget(false);
        agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        toolbar.add(agregar);
        toolbar.add(jSeparator1);

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dao/folder/editar.png"))); // NOI18N
        editar.setText("Editar");
        editar.setBorder(null);
        editar.setContentAreaFilled(false);
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.setEnabled(false);
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        toolbar.add(editar);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dao/folder/buscar.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.setBorder(null);
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.setEnabled(false);
        buscar.setFocusable(false);
        buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(buscar);

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dao/folder/eliminar.png"))); // NOI18N
        eliminar.setText("Borrar");
        eliminar.setBorder(null);
        eliminar.setEnabled(false);
        eliminar.setFocusable(false);
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        toolbar.add(eliminar);
        toolbar.add(jSeparator3);
        toolbar.add(jSeparator4);

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dao/folder/confirmar.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setBorder(null);
        guardar.setContentAreaFilled(false);
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.setEnabled(false);
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        toolbar.add(guardar);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dao/folder/cancelar.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setBorder(null);
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setEnabled(false);
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

        tabla.setBackground(new java.awt.Color(240, 240, 240));
        tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tabla);

        detalleDao.setPreferredSize(new java.awt.Dimension(500, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalleDao, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(detalleDao, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private Auto getAutoSeleccionado() throws DaoException{
        String vin = (String)tabla.getValueAt(tabla.getSelectedRow(), 0);
        return manager.buscar(vin);
    }
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        detalleDao.setAuto(null);
        detalleDao.cargarDatos();
        detalleDao.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_agregarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            Auto auto = getAutoSeleccionado();
            detalleDao.setAuto(auto);
            detalleDao.setEditable(true);
            detalleDao.cargarDatos();
            guardar.setEnabled(true);
            cancelar.setEnabled(true);
            
            
        } catch (DaoException ex) {
            Logger.getLogger(DaoAutoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalleDao.setAuto(null);
        detalleDao.setEditable(false);
        detalleDao.cargarDatos();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            detalleDao.guardarDatos();
            Auto au = detalleDao.getAuto();
            if( au.getVin() == null){
                manager.guardar(au);
            }else{
                manager.actualizar(au);
            }
            detalleDao.setAuto(null);
            detalleDao.setEditable(true);
            detalleDao.cargarDatos();
            tabla.clearSelection();
            guardar.setEnabled(false);
            cancelar.setEnabled(false);
            
            model.updateModel();
            model.fireTableDataChanged();
        } catch (VehiculoException | ParseException | DaoException ex) {
            Logger.getLogger(DaoAutoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que quieres borrar este registro",
                "Borrar auto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            try {
                Auto auto = getAutoSeleccionado();
                manager.eliminar(auto.getVin());
                model.updateModel();
                model.fireTableDataChanged();
            } catch (DaoException ex) {
                Logger.getLogger(DaoAutoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws dao.DaoException
     */
    public static void main(String args[]) throws SQLException, DaoException{
            DAOAutoBD manager = new DAOAutoBD("localhost", "autos", 3306, "root", "Correa1122");
            java.awt.EventQueue.invokeLater(() -> {
                try {
                    new DaoAutoFrame(manager).setVisible(true);
                } catch (DaoException ex) {
                    Logger.getLogger(DaoAutoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private dao.folder.detalleDao detalleDao;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTable tabla;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
}
