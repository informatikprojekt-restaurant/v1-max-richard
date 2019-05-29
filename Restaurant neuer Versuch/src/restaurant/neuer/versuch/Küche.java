/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.util.ArrayList;

/**
 *
 * @author Thomas Weber
 */
public class Küche {
    
    private Bestellung[] bearbeitungsliste;
    private ArrayList<Bestellung> leistungsliste;
    
    public Küche(int kapazität) {
        bearbeitungsliste = new Bestellung[kapazität];
        leistungsliste = new ArrayList<Bestellung>(0);
    }
    
    public void bestellungAufnehmen(Bestellung b) {
        for(int i = 0; i < bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] == null) {
                bearbeitungsliste[i] = b;
                System.out.println("Die Bestellung wurde erfolgreich auf dem " + (i + 1) + ". Platz eingereit");
            } else {
                if (i == (bearbeitungsliste.length - 1)) {
                    System.out.println("Die Warteschlange ist voll!");
                }
            }
        }
    }
    
    public void ausstehendeBestellungenAusgeben() {
        if(bearbeitungsliste[0] != null) {
            for(int i=0; i<bearbeitungsliste.length; i++){
                if(bearbeitungsliste[i] != null) {
                    bearbeitungsliste[i].inhaltAusgeben();
                }
            }
        } else {
            System.out.println("Keine Bestellungen in der Bearbeitungsliste vorhanden!");
        }
    }
    
    public void bestellungBearbeiten() {
        //besetllung angebot für angebot entsprechend den Zeiten durcharbeiten und bestellung in leistungsliste einfuegen
    }
    
    public int anzahlBestellungenGeben() {
        int anz = 0;
        for(int i = 0; i < bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] != null) {
                anz++;
            }
        }
        for(int i = 0; i < leistungsliste.size(); i++){
            if(leistungsliste.get(i) != null) {
                anz++;
            }
        }
        return anz;
    }
    
}
