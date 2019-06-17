/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;

import javax.swing.*;

/**
 *
 * @author Thomas Weber
 */
public class RestaurantNeuerVersuch {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tz = Integer.parseInt(JOptionPane.showInputDialog("Gib die Anzahl der Tische - zwischen 1 und 10 -  an, die im Restaurant stehen sollen an: "));
        while (tz>10){
            JOptionPane.showMessageDialog(null, "Die Zahl war zu groß!");
            tz = Integer.parseInt(JOptionPane.showInputDialog("Gib die Anzahl der Tische - zwischen 1 und 10 -  an, die im Restaurant stehen sollen an: "));
        }
        Simulation s = new Simulation(tz, new double[0]);
        boolean restart = s.start();
        if (restart){
            s = new Simulation(s.restaurantGeben().tischzahlGeben(), s.restaurantGeben().einnahmenListeGeben());
        }
    }
}
