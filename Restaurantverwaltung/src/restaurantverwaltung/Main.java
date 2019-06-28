/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantverwaltung;

import javax.swing.*;

/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tz;
        while(true) {
            try {
                tz = Integer.parseInt(JOptionPane.showInputDialog("Gib die Anzahl der Tische - zwischen 1 und 10 -  an, die im Restaurant stehen sollen an: "));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Die Eingabe war unpassend!");
            }
        }
        Restaurant r = new Restaurant(tz, new double[0]);
        Oberflaeche o = new Oberflaeche(r);
        for(int i =0; i < 7; i++) {
            while(true) {
                o.aktuallisieren();
                Clock c = new Clock();
                c.run(10);
            }
        }
    }
}