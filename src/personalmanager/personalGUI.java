/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalmanager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
        mitSave = new javax.swing.JMenuItem();
        mitReload = new javax.swing.JMenuItem();
        mitEdit = new javax.swing.JMenuItem();
        mitDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mitarbeiter");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabPersonal.setAutoCreateRowSorter(true);
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

        mitSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        mitSave.setText("Speichern");
        mitSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSaveActionPerformed(evt);
            }
        });
        mnuOptions.add(mitSave);

        mitReload.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mitReload.setText("Neu laden");
        mitReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitReloadActionPerformed(evt);
            }
        });
        mnuOptions.add(mitReload);

        mitEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mitEdit.setText("Mitarbeiter bearbeiten");
        mitEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEditActionPerformed(evt);
            }
        });
        mnuOptions.add(mitEdit);

        mitDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        mitDelete.setText("Mitarbeiter Löschen");
        mitDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitDeleteActionPerformed(evt);
            }
        });
        mnuOptions.add(mitDelete);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("MitarbeiterForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Mitarbeiter[] mitarbeiter = new Mitarbeiter[8999];
    int mitarbeiterCount = 0;
    
    String appdata = System.getenv("APPDATA");
        
        boolean success;
            
        String xmlfolder = appdata + "/PersonalManager/";
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tabPersonal.setModel(model);
        model.addColumn("Name");
        model.addColumn("Mitarbeiter-ID");
        model.addColumn("Gehalt");
        model.addColumn("Zeit gearbeitet");

        success = (new File(appdata + "/PersonalManager")).mkdirs();
        
        if (!success) {
                
            System.out.println("Folder creation Failed (" + xmlfolder + ")");
                
        }else{
                
            System.out.println("Folder created (" + xmlfolder + ")");
                
        }
        
        loadall();
        
        WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            
            closeMe();

        }
    };
        
    this.addWindowListener(exitListener);
        
    }//GEN-LAST:event_formWindowOpened

    private void mitNewMitarbeiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNewMitarbeiterActionPerformed

        getNewWorkerInfo();
        
    }//GEN-LAST:event_mitNewMitarbeiterActionPerformed

    private void mitSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSaveActionPerformed
        
        saveall();
        
    }//GEN-LAST:event_mitSaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveall();
        closeMe();
    }//GEN-LAST:event_formWindowClosing

    private void mitReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitReloadActionPerformed
        
        model.setRowCount(0);
        
        loadall();
        
    }//GEN-LAST:event_mitReloadActionPerformed

    private void mitDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitDeleteActionPerformed
        int delete = tabPersonal.getSelectedRow();
        Mitarbeiter m = mitarbeiter[delete];
        System.out.println(m.getName());
        System.out.println(m.getPersonalNumber());
    }//GEN-LAST:event_mitDeleteActionPerformed

    private void mitEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEditActionPerformed
        
      JTextField idField = new JTextField(5);
      
      JPanel editWorker = new JPanel();
      editWorker.add(new JLabel("Mitarbeiter-ID:"));
      editWorker.add(idField);

      int result = JOptionPane.showConfirmDialog(null, editWorker, 
               "Welchern Mitarbeiter bearbeiten?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      
      Mitarbeiter mit = null;
      boolean mitFound = false;
      
      if (result == JOptionPane.OK_OPTION) {
          
          int searchID = Integer.parseInt(idField.getText().trim());
          int toEditID = searchID - 1000;
          
          try{
          
          for (int i = 0; i <= toEditID; i++) {
              
              if (mitarbeiter[i].getPersonalNumber() == searchID) {
                  
                  mit = mitarbeiter[i];
                  i = toEditID;
                  mitFound = true;
              
              }
          }
          
          }catch(Exception ex){
              
              System.out.println("Muup");
              
          }
    
          if (mitFound == true) {
      
            JTextField nameField = new JTextField(15);
            JTextField salaryField = new JTextField(5);

            JPanel toEditWorker = new JPanel();
            toEditWorker.add(new JLabel("Vorname:"));
            toEditWorker.add(nameField);
            toEditWorker.add(Box.createHorizontalStrut(10));
            toEditWorker.add(new JLabel("Gehalt:"));
            toEditWorker.add(salaryField);
            
            nameField.setText(mit.getName());
            salaryField.setText(Double.toString(mit.getSalary()) + "€");
                  
            int resultEdit = JOptionPane.showConfirmDialog(null, toEditWorker, 
               "Neue Werte für Mitarbeiter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
              if (resultEdit == JOptionPane.OK_OPTION) {
                  
                  
                  
              }
      
          }else{
              
              JOptionPane.showMessageDialog(null, "Mitarbeiter mit der ID #" + searchID + " konnte nicht gefunden werden!", "Fehler", JOptionPane.OK_OPTION);
              
          }
          
      
          
      }
        
    }//GEN-LAST:event_mitEditActionPerformed

    JFileChooser fChooser = new JFileChooser();
    
    private void saveall() {
        try {
            
            for (int i = 0; i < mitarbeiterCount; i++) {
                
                JAXBContext jaxbContext = JAXBContext.newInstance(Mitarbeiter.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
                jaxbMarshaller.marshal(mitarbeiter[i], new File(xmlfolder + "mitarbeiter" + mitarbeiter[i].getPersonalNumber() + ".xml"));
                System.out.println("Mitarbeiter " + mitarbeiter[i].getName() + " gespeichert"); 
                
            }

        } catch (JAXBException ex) {
            Logger.getLogger(personalGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private DefaultTableModel model = new DefaultTableModel(0, 0) {
        @Override
        public boolean isCellEditable(int row, int column){return false;} 
            };
    
    
    public void insertMitarbeiter(Mitarbeiter m) {
        
        model.addRow(new Object[]{m.getName(), "#" + m.getPersonalNumber(), m.getSalary() + "€", m.getTime() + "h"});
        
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
         
         int mID = 1000 + mitarbeiterCount;
         
          if (salary != 0) {
              
              mitarbeiter[mitarbeiterCount] = new Mitarbeiter(lastNameField.getText() + ", " + firstNameField.getText(), mID, salary);
              insertMitarbeiter(mitarbeiter[mitarbeiterCount]);
              mitarbeiterCount++;
              
          }else{
              
              JOptionPane.showMessageDialog(this, "Fehler bei eingabe der Daten \nBitte erneut versuchen!", "Fehler", JOptionPane.ERROR_MESSAGE);
              getNewWorkerInfo();
              
          }
         
    }
    }
    
    private void closeMe(){
        
        PrintWriter writer = null;
        try {
            
            writer = new PrintWriter(xmlfolder + "settings.cfg");
            writer.print("workercount: " + mitarbeiterCount);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(personalGUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
            System.exit(0);
        }
        
        saveall();

    }
    
    public void loadall(){
        
        File config = new File(xmlfolder + "settings.cfg");
        
        String line = null;
        int workerCount;
        try {
            BufferedReader dat = new BufferedReader(new FileReader(config));
            line = dat.readLine();
            dat.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Datei nicht gefunden. Werde keine daten einlesen.");
        } catch (IOException ex) {
            Logger.getLogger(personalGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception x) {
            Logger.getLogger(personalGUI.class.getName()).log(Level.SEVERE, null, x);
            System.out.println("FEHLER! Erster Start?");
        }
        
        String linel = line.substring(line.lastIndexOf(':') + 2, line.length());
        workerCount = Integer.parseInt(linel);
        
        try {
            
            JAXBContext jc = JAXBContext.newInstance(Mitarbeiter.class);
            Unmarshaller um = jc.createUnmarshaller();
            File xmlfiles = new File(xmlfolder);
            File[] files = xmlfiles.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.contains("mitarbeiter")) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });

            for (int i = 0; i < workerCount; i++) {
            
                mitarbeiter[i] = (Mitarbeiter) um.unmarshal(files[i]);
                insertMitarbeiter(mitarbeiter[i]);
            
            }

        } catch (Exception e) {
            
            System.out.println("Fehler beim unmarshalen");
            Logger.getLogger(personalGUI.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        File x = new File(xmlfolder);

        mitarbeiterCount = workerCount;
        
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
                /*
                try {
                    
                    Connection con = DriverManager.getConnection("jdbc:mysql://darkdl.de:3306/ni520829_2sql1", "ni520829_2sql1", "Hallohallo");
                    Statement stmt = con.createStatement();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(personalGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                new personalGUI().setVisible(true);
            }
        });
        
    }
    
    
    
    //Alter Code (Friedhof):
    
    /*if (fChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            String path = fChooser.getSelectedFile().toString();
            String p = path.substring(0, path.lastIndexOf('\\') + 1);
            p = p + "mitarbeiter";
            System.out.println(path);
            System.out.println(p);
            System.out.println(mitarbeiter[0]);
            System.out.println(mitarbeiter[1]);
            
            try
            {
            while(true) {
            int i = 0;
            if(mitarbeiter[i] == null) {
            break;
            }
            BufferedWriter dat = new BufferedWriter(new FileWriter(p + mitarbeiter[i].getPersonalNumber() + ".txt"));
            dat.write(mitarbeiter[i].getName());
            dat.close();
            System.out.println("Success");
            }
            }
            catch (IOException x)
            {
            JOptionPane.showMessageDialog (null, "Kann Daten nicht speichern!");
            }
            }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitEdit;
    private javax.swing.JMenuItem mitNewMitarbeiter;
    private javax.swing.JMenuItem mitReload;
    private javax.swing.JMenuItem mitSave;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JTable tabPersonal;
    // End of variables declaration//GEN-END:variables
}
