package restaurant.neuer.versuch;
import java.util.ArrayList;

/**
 *
 * @author Thomas Weber
 */
public class Kueche {
    
    private Bestellung[] bearbeitungsliste;
    private ArrayList<Bestellung> leistungsliste;
    
    public Kueche(int kapazität) {
        bearbeitungsliste = new Bestellung[kapazität];
        leistungsliste = new ArrayList<Bestellung>(0);
    }
    
    public void bestellungAufnehmen(Bestellung b) {
        boolean istEingereiht = false;
        for(int i = 0; i < bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] == null && !istEingereiht) {
                bearbeitungsliste[i] = b;
                System.out.println("Die Bestellung von Tisch " + (b.auftraggeberGeben()).tischNummerGeben() + " wurde erfolgreich auf dem " + (i + 1) + ". Platz eingereit");
                istEingereiht = !istEingereiht;
            } else {
                if (i == (bearbeitungsliste.length - 1) && !istEingereiht) {
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
                    System.out.println();
                }
            }
        } else {
            System.out.println("Keine Bestellungen in der Bearbeitungsliste vorhanden!");
        }
    }
    
    public void bestellungBearbeiten() {
        if(bearbeitungsliste[0] != null) {
            bearbeitungsliste[0].auftraggeberGeben().bestelltSetzen(3);
            leistungsliste.add(bearbeitungsliste[0]);
            for(int i = 0; (i + 1) < bearbeitungsliste.length; i++) {
                bearbeitungsliste[i] = bearbeitungsliste[i+1];
            }
        } else {
            System.out.println("Keine Bestellungen zur Bearbeitung vorhanden");
        }
    }
    
    public void bestellungBearbeitenManuell(Tisch t) {
        for(int i = 0; i<bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i].auftraggeberGeben() == t) {
                t.bestelltSetzen(3);
                leistungsliste.add(bearbeitungsliste[i]);
                for(int j = i; (j+1) < bearbeitungsliste.length; j++) {
                    bearbeitungsliste[j] = bearbeitungsliste[j+1];
                }
            }            
        }
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
    
    public void fertigeBestellungenAusgeben() {
        for(int i = 0; i < leistungsliste.size(); i++) {
            leistungsliste.get(i).inhaltAusgeben();
            System.out.println();
        }
    }
    
    public Bestellung[] ausstehendeBestellungenGeben() {
        return bearbeitungsliste;
    }
    
    public double gewinnGeben() {
        double gewinn = 0;
        for (int i = 0; i<leistungsliste.size(); i++) {
            gewinn = gewinn + leistungsliste.get(i).bestellungsPreisGeben();
        }
        return gewinn;
    }
    
}