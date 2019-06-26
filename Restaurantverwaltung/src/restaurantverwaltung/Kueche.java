package restaurantverwaltung;
import java.util.ArrayList;

/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
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
    
    public void bestellungBearbeitenManuell(Tisch t) {
        for(int i = 0; i<bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] != null && bearbeitungsliste[i].auftraggeberGeben() == t) {
                t.zustandSetzen(3);
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