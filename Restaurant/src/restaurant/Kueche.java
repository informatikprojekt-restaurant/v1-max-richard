package restaurant;
import java.util.ArrayList;

/**
 *
 * @author Thomas Weber
 */
public class Kueche {
    
    Bestellung[] bearbeitungsliste;
    ArrayList<Bestellung> leistungsliste;
    Tisch[] t;
    
    public Kueche(Tisch[] tischliste) {
        leistungsliste = new ArrayList<Bestellung>(0);
        t = tischliste;
        bearbeitungsliste = new Bestellung[t.length];
    }
    
    public void bestellungenAufnehmen(int tNr) {
        int i = 0;
        while (bearbeitungsliste[i] != null && i < bearbeitungsliste.length) {
            i++;
        }
        bearbeitungsliste[i] = t[tNr].bestellungAufgeben();
    }
    
    public void ausstehendeBestellungenAusgeben() {
        if(bearbeitungsliste[0] != null) {
            for(int i=0; i<bearbeitungsliste.length; i++){
                bearbeitungsliste[i].inhaltAusgeben();
            }
        } else {
            System.out.println("Keine Bestellungen in der Bearbeitungsliste vorhanden!");
        }
    }
    
    public void bestellungBearbeiten() {
        if(bearbeitungsliste[0]!=null) {
            for(int i = 0; i < bearbeitungsliste[0].elementanzahlGeben(); i++) {
                //evtl inhalt der Bestellung im GUI ausgeben
            }
            leistungsliste.add(bearbeitungsliste[0]);
        }
    }
    
}
