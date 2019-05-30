/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Thomas Weber
 */
public class Restaurant {
    
    private Küche k;
    private Tisch[] t;
    private ArrayList<Angebot> speisekarte;
    private Random number;
    
    public Restaurant(int tz) {
        speisekarte = new ArrayList<Angebot>(0);
        t = new Tisch[tz];
        k = new Küche(t.length);
        number = new Random();
        
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tisch((number.nextInt(8) + 2), (i + 1));
        }
        
        speisekarte.add(new Angebot("Knödel",1 ,10.50, false, 20)); 
        speisekarte.add(new Angebot("Schweinsbron",2 ,13.50, false, 30)); 
        speisekarte.add(new Angebot("Kaiserschmarn",3 ,9.99, false, 15)); 
        speisekarte.add(new Angebot("Russischer Zopfkuchen",4 ,10.50, false, 18)); 
        speisekarte.add(new Angebot("Brownies",5 ,4.20, false, 60)); 
        speisekarte.add(new Angebot("Rumkuchen",6 ,6.66, false, 40)); 
        speisekarte.add(new Angebot("Pizza",7 ,12.00, false, 35)); 
        speisekarte.add(new Angebot("Döner",8 ,10.50, false, 20)); 
        speisekarte.add(new Angebot("Menschenfleisch",9 ,10.50, false, 29)); 
        speisekarte.add(new Angebot("Goaßkrapfen",10,4.50, false, 30)); 
        speisekarte.add(new Angebot("0.5 Kg Tofuklotz ungekocht",11,0.50, false, 23)); 
        speisekarte.add(new Angebot ("Goaßmass",12, 4.50, true, 5));
        speisekarte.add(new Angebot ("S3x on the beach",13,6.69, true, 9));
        speisekarte.add(new Angebot ("Mojito", 14, 9.00, true, 14));
        speisekarte.add(new Angebot ("Wasser", 15, 14.00, true, 12));
    }
    
    public void tischDatenAusgeben() {
        for(int i = 0; i < t.length; i++) {
            t[i].datenAusgeben();
        }
    }
    
    public void kundenKommen() {
        int anzahl = number.nextInt(9) + 1;
        boolean platzGesucht = true;
        //gäste haben noch keinen platz
        for (int i = 0; i < t.length; i++) {
            if(t[i].gaesteZahlGeben() == 0 && anzahl <= t[i].stuhlZahlGeben() && platzGesucht) {
                t[i].gaesteKommen(anzahl);
                platzGesucht = !platzGesucht;
            }
        }
        if(platzGesucht) {
            System.out.println("Es war kein Platz für " + anzahl + " Gäste!");
        }
    }
    
    public void kundenGehen(int tNr) {
        t[tNr].gaesteGehen();
    }
    
    public void bestellungErstellen(int tNr) {
        if(t[tNr].gaesteZahlGeben() != 0) {
            k.bestellungAufnehmen(new Bestellung(k.anzahlBestellungenGeben(), t[tNr], speisekarte));
        } else {
            System.out.println("Es sitzen keine Gaeste an Tisch " + t[tNr].tischNummerGeben());
        }
    }
    
    public void unbearbeiteteBestellungenAusgeben(){
        k.ausstehendeBestellungenAusgeben();
    }
    
    public void bearbeiteBestellung() {
        k.bestellungBearbeiten();
    }
    
    public void bearbeiteteBestellungenAusgeben() {
        k.fertigeBestellungenAusgeben();
    }
    
}
