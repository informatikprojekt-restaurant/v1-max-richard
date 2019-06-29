package restaurantverwaltung;

import javax.swing.*;

/**
 *
 * @author Thomas Weber
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
                if (tz >0 && tz < 11) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Die Eingabe war unpassend!");
            }
        }
        Restaurant r = new Restaurant(tz);
        Oberflaeche o = new Oberflaeche(r);
        while(true) {
            o.aktuallisieren();
            Clock c = new Clock();
            c.run(10);
        }
    }
}