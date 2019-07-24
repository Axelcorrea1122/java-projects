/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.folder;

import dao.Auto;
import dao.FechaUtils;
import dao.Motor;
import dao.VehiculoException;
import java.text.ParseException;
import java.util.Calendar;

/**
 *
 * @author axelc
 */
public class detalleDao extends javax.swing.JPanel {
    
    private Auto auto;
    private Motor motor;
    private boolean editable;
    
    public detalleDao() {
        initComponents();
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        vinTF.setEditable(editable);
        marcaTF.setEditable(editable);
        modeloTF.setEditable(editable);
        colorTF.setEditable(editable);
        fechaFabTF.setEditable(editable);
        cantPuertasTF.setEditable(editable);
        motorIdTF.setEditable(editable);
        motorMarcaTF.setEditable(editable);
        motorModeloTF.setEditable(editable);
        motorCilindradaTF.setEditable(editable);
        motorTipoCombustibleTF.setEditable(editable);        
        
    }
    
    
    public void cargarDatos(){
        if(auto != null){
            vinTF.setText(auto.getVin());
            marcaTF.setText(auto.getMarca());
            modeloTF.setText(auto.getModelo());
            colorTF.setText(auto.getColor());
            fechaFabTF.setText(FechaUtils.toString(auto.getFechaFab()));
            cantPuertasTF.setText(Integer.toString(auto.getCantPuertas()));
            motorIdTF.setText(auto.getMotor().getId());
            motorMarcaTF.setText(auto.getMotor().getMarca());
            motorModeloTF.setText(auto.getMotor().getModelo());
            motorCilindradaTF.setText(auto.getMotor().getCilindrada());
            motorTipoCombustibleTF.setText(auto.getMotor().getTipoCombustible());
        }else{
            vinTF.setText("");
            marcaTF.setText("");
            modeloTF.setText("");
            colorTF.setText("");
            fechaFabTF.setText("");
            cantPuertasTF.setText("");
            motorIdTF.setText("");
            motorMarcaTF.setText("");
            motorModeloTF.setText("");
            motorCilindradaTF.setText("");
            motorTipoCombustibleTF.setText("");
        }
        
        vinTF.requestFocus();
    }
    
    
    public void guardarDatos() throws VehiculoException, ParseException{
        if(auto == null){
            auto = new Auto();
            motor = new Motor();
        }
        auto.setVin(vinTF.getText());
        auto.setMarca(marcaTF.getText());
        auto.setModelo(modeloTF.getText());
        auto.setColor(colorTF.getText());
        //fechaFabTF.commitEdit();
        auto.setFechaFab(FechaUtils.txtACalendar(fechaFabTF.getText()));
        System.out.println(auto.getFechaFab());
        auto.setCantPuertas(Integer.parseInt(cantPuertasTF.getText()));
        motor.setId(motorIdTF.getText());
        motor.setMarca(motorMarcaTF.getText());
        motor.setModelo(motorModeloTF.getText());
        motor.setCilindrada(motorCilindradaTF.getText());
        motor.setTipoCombustible(motorTipoCombustibleTF.getText());
        auto.setMotor(motor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        vinTF = new javax.swing.JTextField();
        marcaTF = new javax.swing.JTextField();
        modeloTF = new javax.swing.JTextField();
        colorTF = new javax.swing.JTextField();
        motorIdTF = new javax.swing.JTextField();
        motorMarcaTF = new javax.swing.JTextField();
        motorModeloTF = new javax.swing.JTextField();
        motorCilindradaTF = new javax.swing.JTextField();
        motorTipoCombustibleTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cantPuertasTF = new javax.swing.JTextField();
        fechaFabTF = new javax.swing.JFormattedTextField();

        jLabel1.setText("Vin:");

        jLabel2.setText("Marca:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Color:");

        jLabel5.setText("Fecha Fabricacion:");

        jLabel6.setText("Motor Id");

        jLabel7.setText("Motor Marca:");

        jLabel8.setText("Motor Modelo:");

        jLabel9.setText("Tipo Combustible:");

        jLabel10.setText("Cilindrada:");

        vinTF.setEditable(false);

        marcaTF.setEditable(false);

        modeloTF.setEditable(false);

        colorTF.setEditable(false);

        motorIdTF.setEditable(false);

        motorMarcaTF.setEditable(false);

        motorModeloTF.setEditable(false);
        motorModeloTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorModeloTFActionPerformed(evt);
            }
        });

        motorCilindradaTF.setEditable(false);

        motorTipoCombustibleTF.setEditable(false);

        jLabel12.setText("Cant. Puertas:");

        cantPuertasTF.setEditable(false);
        cantPuertasTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantPuertasTFActionPerformed(evt);
            }
        });

        fechaFabTF.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(marcaTF)
                    .addComponent(modeloTF)
                    .addComponent(colorTF)
                    .addComponent(motorIdTF)
                    .addComponent(motorMarcaTF)
                    .addComponent(motorModeloTF)
                    .addComponent(motorCilindradaTF)
                    .addComponent(motorTipoCombustibleTF)
                    .addComponent(vinTF, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(cantPuertasTF)
                    .addComponent(fechaFabTF))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {colorTF, marcaTF, modeloTF, motorCilindradaTF, motorIdTF, motorMarcaTF, motorModeloTF, motorTipoCombustibleTF, vinTF});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(vinTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marcaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(modeloTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(colorTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fechaFabTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cantPuertasTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(motorIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(motorMarcaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(motorModeloTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(motorCilindradaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(motorTipoCombustibleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void motorModeloTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorModeloTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorModeloTFActionPerformed

    private void cantPuertasTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantPuertasTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantPuertasTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantPuertasTF;
    private javax.swing.JTextField colorTF;
    private javax.swing.JFormattedTextField fechaFabTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField marcaTF;
    private javax.swing.JTextField modeloTF;
    private javax.swing.JTextField motorCilindradaTF;
    private javax.swing.JTextField motorIdTF;
    private javax.swing.JTextField motorMarcaTF;
    private javax.swing.JTextField motorModeloTF;
    private javax.swing.JTextField motorTipoCombustibleTF;
    private javax.swing.JTextField vinTF;
    // End of variables declaration//GEN-END:variables
}
