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
        while (tz>10 || tz<1){
            JOptionPane.showMessageDialog(null, "Die Zahl war unpassend!");
            tz = Integer.parseInt(JOptionPane.showInputDialog("Gib die Anzahl der Tische - zwischen 1 und 10 -  an, die im Restaurant stehen sollen an: "));
        }
        Simulation s = new Simulation(tz, new double[0]);
        int i = Integer.parseInt(JOptionPane.showInputDialog("Gib die Stundenzahl an, über welche das Restaurant geöffnet haben soll (diese entscheidet über die menge der Aktionen, welche an einem Tag ausgeführt werden): "));
        boolean restart = s.start(i);
        while (restart){
            s = new Simulation(s.restaurantGeben().tischzahlGeben(), s.restaurantGeben().einnahmenListeGeben());
            restart = s.start(i);
        }
    }
}
