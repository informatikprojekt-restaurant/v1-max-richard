package restaurantverwaltung;

//Importe
import java.util.ArrayList;

/**
 *
 * @author Max Demel
 */

public class Kueche {
    
    //Attribute
    private Bestellung[] bearbeitungsliste;
    private ArrayList<Bestellung> leistungsliste;
    
    //Konstruktor
    public Kueche(int kapazität) {
        bearbeitungsliste = new Bestellung[kapazität];
        leistungsliste = new ArrayList<Bestellung>(0);
    }
    
    //Methoden
    
    //Eine übergebene Bestellung wird in der "bearbeitungsliste" eingereiht, wenn in dieser noch Platz ist
    public void bestellungAufnehmen(Bestellung b) {
        boolean eingereiht = false;
        for(int i = 0; i < bearbeitungsliste.length; i++) {
            if(bearbeitungsliste[i] == null && !eingereiht) {
                bearbeitungsliste[i] = b;
                eingereiht = !eingereiht;
            }
        }
    }
    
    //Wenn eine Bestellung des Übergebenen Tisches vorhanden ist, wird diese bearbeitet und von der "bearbeitungsliste" in die "leistungsliste" verschoben
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
    
    //Gibt die Anzahl der Bestellungen zurück, indem die Elemente in der "bearbeitungslste" und der "leistungsliste" zusammengezählt werden
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
    
    //Gibt den Gesamtpreis aller Bestellungen in der "leistungsliste" zurück
    public double gewinnGeben() {
        double gewinn = 0;
        for (int i = 0; i<leistungsliste.size(); i++) {
            gewinn = gewinn + leistungsliste.get(i).bestellungsPreisGeben();
        }
        return gewinn;
    }
    
    //Gibt die Bestellungen mit ihren Nummern und Auftraggebern in der "leistungsliste" so als String-Array zurück, dass die Bestellungen, die als Letztes bearbeitet wurden an der Ersten Stelle stehen
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
    
    //Gibt die Bestellungen mit ihren Nummern und Auftraggebern "bearbeitungsliste" so String-Array zurück
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
    
    //Gibt ein String-Array mit dem Inhalt einer Bestellung zurück
    public String[] bestellungsInhaltGeben(int id) {
        for (int j = 0; j < bearbeitungsliste.length; j++) {
            if (bearbeitungsliste[j] != null) {
                if (bearbeitungsliste[j].bestellIDGeben() == id) {
                    return bearbeitungsliste[j].alleDatenGeben();
                }
            }
        }
        for (int j = 0; j < leistungsliste.size(); j++) {
            if (leistungsliste.get(j).bestellIDGeben() == id) {
                return leistungsliste.get(j).alleDatenGeben();
            }
        }
        return new String[0];
    }
    
}