/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gauffre;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.*;
/**
 *
 * @author farid
 */
public class Gauffre {

    public static void main(String[] args) {
        
        MenuPrincipal menu = new MenuPrincipal();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - menu.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - menu.getHeight()) / 2);
            menu.setLocation(x, y);
        menu.setVisible(true);
        
        
        
    }
    
    
}
