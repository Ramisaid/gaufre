/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.*;
import java.util.logging.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import java.util.Hashtable;
import Modele.*;
import Controleur.*;

/**
 *
 * @author farid
 */


public class Visuel extends javax.swing.JFrame {
    public Hashtable< Hashtable<Integer, Integer>,Integer> myHTable = new Hashtable<>();
    /**
     * Creates new form Visuel
     */
    public Visuel() {
        
        initComponents();
        
    }
    
    public void setgaufre(Gaufre gaufre) {
        this.gaufre = gaufre;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gauffre Empoisonné");

        jProgressBar1.setAutoscrolls(true);
        jProgressBar1.setString("0");
        jProgressBar1.setStringPainted(true);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(33, 122, 222));
        label1.setText("Progression");

        jButton1.setText("Annuler tout les Coups");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Précédent");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(92, 65, 133));
        jLabel1.setText("Joueur : 1");

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledSelectedBackground"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setDoubleBuffered(false);
        jPanel1.setEnabled(false);
        jPanel1.setName(""); // NOI18N
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Source Code Pro", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nombre de partie :");

        jLabel3.setFont(new java.awt.Font("Source Code Pro", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 255));
        jLabel3.setText("Statistiques");

        jLabel4.setFont(new java.awt.Font("Source Code Pro", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Perdue : ");

        jLabel5.setFont(new java.awt.Font("Source Code Pro", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 102));
        jLabel5.setText("Gagné :");

        jMenu1.setText("Option");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        jMenuItem1.setText("Nouvelle Partie");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Historique");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jMenuItem2.setText("Sauvegarder");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        jMenuItem3.setText("Charger");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("IA");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");
        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);
        jLabel2.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Visuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Visuel().setVisible(true);
                
            }
        });
    }
    
    
    
    
    @Override
   public void paint(Graphics g) {
       if(topaint == false ) {
           return;
       }
       topaint = true;
       try {
        this.jProgressBar1.setValue((int) gaufre.progression());
           this.jProgressBar1.setString(String.valueOf(gaufre.progression())+'%');
       super.paint(g);
       super.paintComponents(g);
       
          
        
       g.setColor(Color.red);
       
       Point test = jPanel1.getLocationOnScreen();
   
                  File file = new File("C:\\Users\\farid\\Documents\\NetBeansProjects\\Gauffre\\1.png");
                   File file2 = new File("C:\\Users\\farid\\Documents\\NetBeansProjects\\Gauffre\\2.png");
                     File file3 = new File("C:\\Users\\farid\\Documents\\NetBeansProjects\\Gauffre\\3.png");

            BufferedImage image = ImageIO.read(file);
            BufferedImage image2 = ImageIO.read(file2);
            BufferedImage image3 = ImageIO.read(file3);
       
  
        int uniteX = jPanel1.getWidth()/COLONNE_GRILLE;
        int uniteY = jPanel1.getHeight()/LIGNE_GRILLE;
        g.setColor(Color.RED);
        for(int i =0; i< COLONNE_GRILLE; i++) { // colone
            for(int j = 0; j< LIGNE_GRILLE; j++) { // ligne
                   
                    if (gaufre.tableau[i][j] == gaufre.POISON ) {
                        g.drawImage(image2,test.x+(i*uniteX), test.y+(j*uniteY), uniteX, uniteY,null);
                    }
                    else if (gaufre.tableau[i][j] == gaufre.VIDE )   {
                               g.drawImage(image,test.x+(i*uniteX), test.y+(j*uniteY), uniteX, uniteY,null);
                    }
                    else if (gaufre.tableau[i][j] == gaufre.CROQUE )   {
                         g.drawImage(image3,test.x+(i*uniteX), test.y+(j*uniteY), uniteX, uniteY,null);
                    }
               

                
                
                
                
	    }
        }
        
        changemap = false;
        
        if(counter > 5) {
            
            counter = 0;
        }
        counter++;
        
          } catch (IOException e) {
            e.printStackTrace();
        }

       
       
   }
    
   
   
    
   
    
  
    
   
        
    public int counter = 1;
    public boolean changemap = false;
    public Point poschange = new Point() ;
    public int COLONNE_GRILLE = 0;
    public int LIGNE_GRILLE = 0;
    public boolean topaint = false;
    public Gaufre gaufre ;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}