/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.util.Random;

/**
 *
 * @author Thomas Weber
 */
public class Restaurant {
    
    private Küche k;
    private Tisch[] t;
    private Angebot[] speisekarte;
    private Random number;
    
    public Restaurant(int tz) {
        speisekarte = new Angebot[15];
        t = new Tisch[tz];
        k = new Küche(t.length);
        number = new Random();
        
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tisch((number.nextInt((9) + 1)), (i + 1));
        }
        
        speisekarte[0] = new Angebot("Knödel",1 ,10.50, false, 10); 
        speisekarte[1] = new Angebot("Schweinsbron",2 ,13.50, false, 10); 
        speisekarte[2] = new Angebot("Kaiserschmarn",3 ,9.99, false, 10); 
        speisekarte[3] = new Angebot("Russischer Zopfkuchen",4 ,10.50, false, 10); 
        speisekarte[4] = new Angebot("Brownies",5 ,4.20, false, 10); 
        speisekarte[5] = new Angebot("Rumkuchen",6 ,6.66, false, 10); 
        speisekarte[6] = new Angebot("Pizza",7 ,12.00, false, 10); 
        speisekarte[7] = new Angebot("Döner",8 ,10.50, false, 10); 
        speisekarte[8] = new Angebot("Menschenfleisch",9 ,10.50, false, 10); 
        speisekarte[9] = new Angebot("Goaßkrapfen",10,4.50, false, 10); 
        speisekarte[10] = new Angebot("0.5 Kg Tofuklotz ungekocht",11,0.50, false, 10); 
        speisekarte[11] = new Angebot ("Goaßmass",12, 4.50, true, 10);
        speisekarte[12] = new Angebot ("S3x on the beach",13,6.69, true, 10);
        speisekarte[13] = new Angebot ("Mojito", 14, 9.00, true, 10);
        speisekarte[14] = new Angebot ("Wasser", 15, 14.00, true, 10);
    }
    
    public void tischDatenAusgeben() {
        for(int i = 0; i < t.length; i++) {
            t[i].datenAusgeben();
        }
    }
    
    public void kundenKommen() {
        int anzahl = number.nextInt(9) + 1;
        boolean istPlatz = false;
        for (int i = 0; i < t.length; i++) {
            if(!istPlatz) {
                t[i].gaesteKommen(anzahl);
            }
        }
        if(!istPlatz) {
            System.out.println("Es war kein Platz!");
        }
    }
    
    public void kundenGehen(int tNr) {
        t[tNr].gaesteGehen();
    }
    
    public void bestellungErstellen(int tNr) {
        if(t[tNr].gaesteZahlGeben() != 0) {
            k.bestellungAufnehmen(new Bestellung(k.anzahlBestellungenGeben(), t[tNr], speisekarte));
        } else {
            System.out.println("Es sitzen keine Gaeste an Tisch " + tNr);
        }
    }
    
    public void zuBearbeitendeBestellungenAusgeben(){
        k.ausstehendeBestellungenAusgeben();
    }
    
}
