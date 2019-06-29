package restaurantverwaltung;
import java.util.ArrayList;

/**
 *
 * @author Max Demel
 */
public class Kueche {
    
    private Bestellung[] bearbeitungsliste;
    private ArrayList<Bestellung> leistungsliste;
    
    public Kueche(int kapazität) {
        bearbeitungsliste = new Bestellung[kapazität];
        leistungsliste = new ArrayList<Bestellung>(0);
    }
    
    //
    public void bestellungAufnehmen(Bestellung b) {
        boolean eingereiht = false;
        for(int i = 0; i < bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] == null && !eingereiht) {
                bearbeitungsliste[i] = b;
                eingereiht = !eingereiht;
            }
        }
    }
    
    //
    public void bestellungBearbeiten(Tisch t) {
        for(int i = 0; i<bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] != null && bearbeitungsliste[i].auftraggeberGeben() == t) {
                t.zustandSetzen(3);
                leistungsliste.add(bearbeitungsliste[i]);
                for(int j = i; (j+1) < bearbeitungsliste.length; j++) {
                    bearbeitungsliste[j] = bearbeitungsliste[j+1];
                }
                bearbeitungsliste[bearbeitungsliste.length-1] = null;
            }            
        }
    }
    
    //
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
    
    //
    public double gewinnGeben() {
        double gewinn = 0;
        for (int i = 0; i<leistungsliste.size(); i++) {
            gewinn = gewinn + leistungsliste.get(i).bestellungsPreisGeben();
        }
        return gewinn;
    }
    
    //
    public String[] leistungslisteGeben() {
        String[] s = new String[leistungsliste.size() + 1];
        s[0] = ("Bearbeitete Bestellungen:");
        for(int i = 0; i < leistungsliste.size(); i++) {
            if(leistungsliste.get(leistungsliste.size() - (i + 1)) != null) {
                s[i + 1] = ("Bestellung " + leistungsliste.get(leistungsliste.size() - (i + 1)).bestellIDGeben() + " von Tisch " + leistungsliste.get(leistungsliste.size() - (i + 1)).auftraggeberGeben().tischNummerGeben());
            }
        }
        return s;
    }
    
    public String[] bearbeitungslisteGeben() {
        String[] s = new String[bearbeitungsliste.length + 1];
        s[0] = ("Unbearbeitete Bestellungen:");
        for(int i = 0; i < bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] != null){
                s[i + 1] = ("Bestellung " + bearbeitungsliste[i].bestellIDGeben() + " von Tisch " + bearbeitungsliste[i].auftraggeberGeben().tischNummerGeben());
            }
        }
        return s;
    }
    
    public String[] bestellungsInhaltGeben(int i) {
        for (int j = 0; j < bearbeitungsliste.length; j++) {
            if (bearbeitungsliste[j] != null) {
                if (bearbeitungsliste[j].bestellIDGeben() == i) {
                    return bearbeitungsliste[j].alleDatenGeben();
                }
            }
        }
        for (int j = 0; j < leistungsliste.size(); j++) {
            if (leistungsliste.get(j).bestellIDGeben() == i) {
                return leistungsliste.get(j).alleDatenGeben();
            }
        }
        return new String[0];
    }
    
}