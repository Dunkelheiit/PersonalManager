/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalmanager;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.

/**
 *
 * @authors Dunkel, DunklerHeld
 */
public class personalGUI extends javax.swing.JFrame {

    /**
     * Creates new form personalGUI
     */
    public personalGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPersonal = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuOptions = new javax.swing.JMenu();
        mitNewMitarbeiter = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mitarbeiter");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabPersonal.setModel(model);
        tabPersonal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tabPersonal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabPersonal);

        mnuOptions.setText("Optionen");

        mitNewMitarbeiter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        mitNewMitarbeiter.setText("Neuen Mitarbeiter hinzufügen");
        mitNewMitarbeiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNewMitarbeiterActionPerformed(evt);
            }
        });
        mnuOptions.add(mitNewMitarbeiter);

        jMenuBar1.add(mnuOptions);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("MitarbeiterForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tabPersonal.setModel(model);
        model.addColumn("Name");
        model.addColumn("Mitarbeiter-ID");
        model.addColumn("Gehalt");
        model.addColumn("Zeit gearbeitet");
        
        int mID = (int)(Math.random() * 8999) + 1000;
        
        Mitarbeiter mitarbeiter = new Mitarbeiter("Perlick, Tim", mID, 8.50);
        
        insertMitarbeiter(mitarbeiter);
        
    }//GEN-LAST:event_formWindowOpened

    private void mitNewMitarbeiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNewMitarbeiterActionPerformed

        getNewWorkerInfo();
        
    }//GEN-LAST:event_mitNewMitarbeiterActionPerformed

    private DefaultTableModel model = new DefaultTableModel(0, 0) {};
    
    
    public void insertMitarbeiter(Mitarbeiter m) {
        
        model.addRow(new Object[]{m.getName(), "#" + m.getPersonalNumber(), m.getSalary() + "€", m.getTime() + "h"});
        
        /*tabPersonal.setValueAt(m.getName(), 0, 0); 
        tabPersonal.setValueAt("#" + m.getPersonalNumber(), 0, 1);
        tabPersonal.setValueAt(m.getSalary() + "€", 0, 2);
        tabPersonal.setValueAt(m.getTime() + "h", 0, 3); */
    }
    
    private void getNewWorkerInfo(){
        
      JTextField firstNameField = new JTextField(5);
      JTextField lastNameField = new JTextField(5);
      JTextField salaryField = new JTextField(5);

      JPanel newWorker = new JPanel();
      newWorker.add(new JLabel("Vorname"));
      newWorker.add(firstNameField);
      newWorker.add(Box.createHorizontalStrut(10));
      newWorker.add(new JLabel("Nachname"));
      newWorker.add(lastNameField);
      newWorker.add(Box.createHorizontalStrut(10));
      newWorker.add(new JLabel("Gehalt"));
      newWorker.add(salaryField);

      int result = JOptionPane.showConfirmDialog(null, newWorker, 
               "Daten für neuen Mitarbeiter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      
      if (result == JOptionPane.OK_OPTION) {
          
         System.out.println("Vorname: " + firstNameField.getText());
         System.out.println("Nachname: " + lastNameField.getText());
         System.out.println("Gehalt: " + salaryField.getText());
         
         double salary = 0;
         
          try {
              
              salary = Double.parseDouble(salaryField.getText());
              
          } catch (Exception e) {
              
              JOptionPane.showMessageDialog(this, "Fehler bei eingabe der Daten \nBitte erneut versuchen!", "Fehler", JOptionPane.ERROR_MESSAGE);
              getNewWorkerInfo();
              
          }
         
         int mID = (int)(Math.random() * 8999) + 1000;
         
          if (salary != 0) {
              
              Mitarbeiter mitarbeiter = new Mitarbeiter(lastNameField.getText() + "," + firstNameField.getText(), mID, salary);
         
              insertMitarbeiter(mitarbeiter);
              
          }
         
    }
    }
    
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(personalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personalGUI().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mitNewMitarbeiter;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JTable tabPersonal;
    // End of variables declaration//GEN-END:variables
}
