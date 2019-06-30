package restaurantverwaltung;

//Importe
import javax.swing.*;

/**
 *
 * @author Thomas Weber
 */

public class Main {
    
    public static void main(String[] args) {
        //tz ist die Spätere Tischzahl des Restaurants
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
        
        //Erstellen der Klassen "Restaurant" und "Oberflaeche"
        Restaurant r = new Restaurant(tz);
        Oberflaeche o = new Oberflaeche(r);
        Clock c = new Clock();
        
        //Regelmäßige Aktuallisierung der Anzeigen auf der Oberfläche
        while(true) {
            o.aktuallisieren();
            
            //mithilfe von "Clock" wird die Oberflaeche in regelmäßigen zeitlichen Abständen aktuallisiert
            c.run();
        }
    }
}