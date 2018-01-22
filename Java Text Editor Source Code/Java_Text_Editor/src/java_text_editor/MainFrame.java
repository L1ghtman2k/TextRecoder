package java_text_editor;


import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {

    File currentEditingFile = null;
    int fontSize = 14;

    public MainFrame() {
        initComponents();
        
        seticon();
        //Filter Files to display
        //Set JFileChooser to accept only text files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileOpener.setFileFilter(filter);

        //Launch the application on the middle of Screen
        this.setLocationRelativeTo(null);
    
    }

    public MainFrame(File file) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        currentEditingFile = file;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileOpener.setFileFilter(filter);
        readTheParamFile(file);
    }

    public void readTheParamFile(File file) {
        try {
            Scanner scn = new Scanner(file);
            String buffer = "";
            while (scn.hasNext()) {
                buffer += scn.nextLine() + "\n";
            }
            display.setText(buffer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveChanges() {
        try {
            PrintWriter printWriter = new PrintWriter(currentEditingFile);
            printWriter.write(display.getText());
            printWriter.close();
            
//            JOptionPane.showMessageDialog(rootPane, "Saved", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static int b = 0;

    private void seticon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("text_edit.png")));
    }
private static class MyAction extends TimerTask {
        public void run() {
       
            String a;
            a = display.getText();
            a.replaceAll("\t", "     ");
            a = a.replaceAll("(?!\\r)\\n", "\r\n");
        try {
              String Direction = direction.replace("\\", "\\\\");
              
	      File file = new File(Direction + "\\" +String.valueOf(b) + ".txt");
	      FileWriter fw = new FileWriter(file);
              BufferedWriter out = new BufferedWriter(fw);
              out.write(a);
              out.flush();
              out.close();
    	}      catch (IOException e) {
	      e.printStackTrace();
        
        } 
        b+=1;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileOpener = new javax.swing.JFileChooser();
        saveDialog = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Start = new javax.swing.JButton();
        STOP1 = new javax.swing.JButton();
        Pause = new javax.swing.JButton();

        saveDialog.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveDialog.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Text Editor");

        jPanel1.setToolTipText("");

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        display.setColumns(20);
        display.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        display.setLineWrap(true);
        display.setRows(5);
        display.setPreferredSize(new java.awt.Dimension(1920, 1080));
        display.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                displayAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        display.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                displayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                displayKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(display);

        jButton4.setText("Decrease Font");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Increase Font");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_text_editor/Play.gif"))); // NOI18N
        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        STOP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_text_editor/Stop.gif"))); // NOI18N
        STOP1.setText("EXIT");
        STOP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STOP1ActionPerformed(evt);
            }
        });

        Pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_text_editor/YAP.png"))); // NOI18N
        Pause.setText("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Start, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STOP1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(470, 470, 470))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pause)
                        .addComponent(Start)
                        .addComponent(STOP1))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Pause, STOP1, Start, jButton3, jButton4});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        Timer timer = new Timer();

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        display.setFont(new java.awt.Font("Monospaced", 0, ++fontSize));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        display.setFont(new java.awt.Font("Monospaced", 0, --fontSize));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        
        timer = new Timer();
        timer.schedule(new MyAction(), 0, 1000);
        
    }//GEN-LAST:event_StartActionPerformed

    
    private void STOP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STOP1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_STOP1ActionPerformed

    private void displayAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_displayAncestorAdded
        
    }//GEN-LAST:event_displayAncestorAdded

    private void displayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyTyped
        
        
    }//GEN-LAST:event_displayKeyTyped

    private void displayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyPressed
       
    }//GEN-LAST:event_displayKeyPressed
private String myline = "";
    private void displayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyReleased
        
       // try{
        char a = evt.getKeyChar();
             
        if(a=='{')
        {
            display.insert("}", display.getCaretPosition());
            display.setCaretPosition(display.getCaretPosition()-1);
        }
        else if(a=='(')
        {
            display.insert(")", display.getCaretPosition());
            display.setCaretPosition(display.getCaretPosition()-1);
            
        }
        else if(a=='[')
        {
            display.insert("]", display.getCaretPosition());
            display.setCaretPosition(display.getCaretPosition()-1);
            
        }
        
        
        
        else if((a=='\n' || a=='\r') &&(myline.equals("{}") || myline.equals("()") || myline.equals("[]"))){
            
        
        int i = display.getCaretPosition()-2;
        char[] one =  display.getText().toCharArray();
        int tot = 0;
        while( i>=0 && one[i]!='\n' ){
            if (one[i] == '\t'){
            tot+=1;
            }
            i--;
        }
        for (int x = 0; x<tot; x++)
        {
          display.insert("\t", display.getCaretPosition());
        
       
        }
            
            
            
            
            display.insert("\t\n", display.getCaretPosition());
            
            for (int x = 0; x<=tot; x++)
        {
          display.insert("\t", display.getCaretPosition());
        
       
        }
            
            display.setCaretPosition(display.getCaretPosition()-2-tot);
            
        }
        
        else if (a=='\n' || a=='\r'){
        
        int i = display.getCaretPosition()-2;
        char[] one =  display.getText().toCharArray();
        int tot = 0;
        while( i>=0 && one[i]!='\n' ){
            if (one[i] == '\t'){
            
            tot+=1;
            }
            i--;
        }
        
        for (int x = 0; x<tot; x++)
        {
          display.insert("\t", display.getCaretPosition());
        
        }      
        }
        try{
        myline = display.getText().substring(display.getCaretPosition()-1, display.getCaretPosition()+1);
        }
        catch (Exception e){
        
        }
        
    }//GEN-LAST:event_displayKeyReleased

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        timer.cancel();
        if(Start.getLabel().equals("Start"))
        {   Start.setLabel("Continue");
        
        }
    }//GEN-LAST:event_PauseActionPerformed
    
   
    
    
    private static String direction = "";
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                chooser.showSaveDialog(null);
                File f = chooser.getSelectedFile();
                direction = f.getAbsolutePath();
               
                new MainFrame().setVisible(true);            
            }
        });
    }
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pause;
    private javax.swing.JButton STOP1;
    private javax.swing.JButton Start;
    private javax.swing.JTextArea display;
    private javax.swing.JFileChooser fileOpener;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFileChooser saveDialog;
    // End of variables declaration//GEN-END:variables
*/  public static javax.swing.JTextArea display;
    private javax.swing.JFileChooser fileOpener;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFileChooser saveDialog;
    private javax.swing.JButton Start;
    private javax.swing.JButton Pause;
    private javax.swing.JButton STOP1;
}
