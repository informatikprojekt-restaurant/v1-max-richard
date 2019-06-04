/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.geom.*;

/**
 *
 * @author Max Demel, Thomas Weber
 */
public class Oberflaeche {
    public Restaurant r;
    public Oberflaeche(Restaurant rs) {
        
        //neues Restaurant
         r = rs;
        
        //neues Fenster
        JFrame f1 = new JFrame("Restaurant Simulation");
        f1.setVisible(true);
        f1.setBounds(500,500,3000,1500);
        //neue Knöpfe
        
    }
    
    
}
