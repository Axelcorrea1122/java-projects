/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import com.sun.glass.events.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author nestor
 */
public class ConversorJFrame extends javax.swing.JFrame
{
        private Conversor conversor; 
        private ConversorPulgCent conversorPulgCent;
       
        private Map<String, Conversor> mapaConversores;
	/**
	 * Creates new form ConversorJFrame
	 */
	public ConversorJFrame()
	{
		initComponents();
		setLocationRelativeTo(null);
                
                mapaConversores = new HashMap<>();
                mapaConversores.put("Pulgadas / Centimetros", new ConversorPulgCent());
                mapaConversores.put("Millas / Kilometros",new ConversorMillasKilometros());
                mapaConversores.put("Calorias / Julios",new ConversorCalJul());
                mapaConversores.put("Celsius / Kelvin",new ConversorCelsiusKelvin());
                mapaConversores.put("Libras / Kilogramos",new ConversorLibrasKilogramos());
                mapaConversores.put("Km/h / m/s",new ConversorKmHoraMSeg());
                mapaConversores.put("Fahrenheit / Celsius",new ConversorFahCelsius());
                mapaConversores.put("Megabit/s / KiloBytes/s ",new ConversorMbKB());
                
                for(String key : mapaConversores.keySet())
                    conversorComboBox.addItem(key);
                
                
                       
                conversor = mapaConversores.get(conversorComboBox.getSelectedItem()); 
                
                setLabels();
                
	}

    private void setLabels() {
        ALabel.setText(conversor.nameA());
        BLabel.setText(conversor.nameB());
       
    }

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        ATextField = new javax.swing.JTextField();
        BTextField = new javax.swing.JTextField();
        ConvertirjButton = new javax.swing.JButton();
        ALabel = new javax.swing.JLabel();
        BLabel = new javax.swing.JLabel();
        conversorComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ATextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ATextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ATextFieldKeyTyped(evt);
            }
        });

        BTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BTextFieldKeyTyped(evt);
            }
        });

        ConvertirjButton.setText("Convertir");
        ConvertirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertirjButtonActionPerformed(evt);
            }
        });

        ALabel.setText("A");

        BLabel.setText("B");

        conversorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conversorComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione la conversion: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ALabel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConvertirjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conversorComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conversorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ALabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(ATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConvertirjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	
    private void ConvertirjButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ConvertirjButtonActionPerformed
    {//GEN-HEADEREND:event_ConvertirjButtonActionPerformed
		
        if(AtoB)
        {
            String aString = ATextField.getText();
            aString = aString.replace(',', '.');
		
            double a;
            try
            {
                    a = Double.valueOf(aString);
            }
            catch(NumberFormatException ex)
            {
                    JOptionPane.showMessageDialog(this, "No se pudo convertir. Ingrese sólo números.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
		
            double b = conversor.aToB(a);
            String bString = String.format("%.4f", b);
            BTextField.setText(bString);
        }
        else
        {
            String bString = BTextField.getText();
            bString = bString.replace(",",".");
        
            double b;
        
            try
            {
                b = Double.valueOf(bString);
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this,"El valor ingresado no es correcto.","Error", JOptionPane.ERROR_MESSAGE);
                return ;
            }    
            
            double a = conversor.bToA(b);
        
            String aString = String.format("%.4f",a);
        
            ATextField.setText(aString);
        }
    }//GEN-LAST:event_ConvertirjButtonActionPerformed
	
	
    private void ATextFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ATextFieldKeyTyped
    {//GEN-HEADEREND:event_ATextFieldKeyTyped
        sentido = 1;
         AtoB = true;
    }//GEN-LAST:event_ATextFieldKeyTyped
	
	
    private void BTextFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_BTextFieldKeyTyped
    {//GEN-HEADEREND:event_BTextFieldKeyTyped
        sentido = 2;
        AtoB = false;
    }//GEN-LAST:event_BTextFieldKeyTyped

    private void conversorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conversorComboBoxActionPerformed
        conversor = mapaConversores.get(conversorComboBox.getSelectedItem()); 
                
        setLabels();
    }//GEN-LAST:event_conversorComboBoxActionPerformed

    private void ATextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ATextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            String aString = ATextField.getText();
            aString = aString.replace(',', '.');
		
            double a;
            try
            {
                    a = Double.valueOf(aString);
            }
            catch(NumberFormatException ex)
            {
                    JOptionPane.showMessageDialog(this, "No se pudo convertir. Ingrese sólo números.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
		
            double b = conversor.aToB(a);
            String bString = String.format("%.4f", b);
            BTextField.setText(bString);
        }
    }//GEN-LAST:event_ATextFieldKeyPressed

    private void BTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTextFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String bString = BTextField.getText();
            bString = bString.replace(",",".");
        
            double b;
        
            try
            {
                b = Double.valueOf(bString);
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this,"El valor ingresado no es correcto.","Error", JOptionPane.ERROR_MESSAGE);
                return ;
            }    
            
            double a = conversor.bToA(b);
        
            String aString = String.format("%.4f",a);
        
            ATextField.setText(aString);
        }
    }//GEN-LAST:event_BTextFieldKeyPressed
	
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch(ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(ConversorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(ConversorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(ConversorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(ConversorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new ConversorJFrame().setVisible(true);
			}
		});
	}
	
	
	private int sentido;
	private boolean AtoB;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ALabel;
    private javax.swing.JTextField ATextField;
    private javax.swing.JLabel BLabel;
    private javax.swing.JTextField BTextField;
    private javax.swing.JButton ConvertirjButton;
    private javax.swing.JComboBox<String> conversorComboBox;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
