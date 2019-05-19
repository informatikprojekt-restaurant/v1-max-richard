package restaurant;
import java.util.ArrayList;

/**
 *
 * @author Thomas Weber
 */
public class Küche {
    
    Bestellung[] bearbeitungsliste;
    ArrayList<Bestellung> leistungsliste;
    Tisch[] t;
    
    public Küche(Tisch[] tischliste) {
        leistungsliste = new ArrayList<Bestellung>(0);
        t = tischliste;
        bearbeitungsliste = new Bestellung[t.length];
    }
    
    public void bestellungAufnehmen(int tNr) {
        for(int i = 0; i<bearbeitungsliste.length; i++) {
            if (bearbeitungsliste[i]!=null) {
                bearbeitungsliste[i] = t[tNr].bestellungAufgeben();
                
            }
            
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
