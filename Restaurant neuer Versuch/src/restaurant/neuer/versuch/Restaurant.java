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
    
    private Kueche k;
    private Tisch[] t;
    private Angebot[] speisekarte;
    private Random number;
    private double[] bisherigeEinnahmen;
    
    public Restaurant(int tz, double[] einnahmen) {
        speisekarte = new Angebot[15];
        t = new Tisch[tz];
        k = new Kueche(t.length);
        number = new Random();
        
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tisch((number.nextInt(8) + 2), (i + 1));
        }
        
        speisekarte[0] =new Angebot("Knödel",1 ,10.50, false, 20); 
        speisekarte[1] =new Angebot("Schweinsbron",2 ,13.50, false, 30); 
        speisekarte[2] =new Angebot("Kaiserschmarn",3 ,9.99, false, 15); 
        speisekarte[3] =new Angebot("Russischer Zopfkuchen",4 ,10.50, false, 18); 
        speisekarte[4] =new Angebot("Brownies",5 ,4.20, false, 60); 
        speisekarte[5] =new Angebot("Rumkuchen",6 ,6.66, false, 40); 
        speisekarte[6] =new Angebot("Pizza",7 ,12.00, false, 35); 
        speisekarte[7] =new Angebot("Döner",8 ,10.50, false, 20); 
        speisekarte[8] =new Angebot("Menschenfleisch",9 ,10.50, false, 29); 
        speisekarte[9] =new Angebot("Goaßkrapfen",10,4.50, false, 30); 
        speisekarte[10] =new Angebot("0.5 Kg Tofuklotz ungekocht",11,0.50, false, 23); 
        speisekarte[11] =new Angebot ("Goaßmass",12, 4.50, true, 5);
        speisekarte[12] =new Angebot ("S3x on the beach",13,6.69, true, 9);
        speisekarte[13] = new Angebot ("Mojito", 14, 9.00, true, 14);
        speisekarte[14] = new Angebot ("Wasser", 15, 14.00, true, 12);
        
        bisherigeEinnahmen = new double[einnahmen.length + 1];
        for (int i = 0; i<einnahmen.length;i++) {
            bisherigeEinnahmen[i] = einnahmen[i];
        }
        
    }
    
    public void tischDatenAusgeben() {
        for(int i = 0; i < t.length; i++) {
            t[i].datenAusgeben();
        }
    }
    
    public void kundenKommen(int anzahl) {
        for (int i = 0; i < t.length; i++) {
            //Abfragen nach Tisch?
            if(t[i].gaesteZahlGeben() == 0 && anzahl <= t[i].stuhlZahlGeben()) {
                t[i].gaesteKommen(anzahl);
                System.out.println("yay");
                return;
            }
        }
        System.out.println("Es war kein Platz für " + anzahl + " Gäste!");
    }
    
    public void kundenGehen() {
        for(int i = 0; i<t.length; i++) {
            t[i].gaesteGehen();
        }
    }
    
    public void bestellungenErstellen() {
        for(int i = 0; i<t.length; i++) {
            if(t[i].gaesteZahlGeben() != 0 && t[i].bestelltGeben()==1) {
                k.bestellungAufnehmen(new Bestellung(k.anzahlBestellungenGeben(), t[i], speisekarte));
            } else {
                System.out.println("Es sitzen keine Gaeste an Tisch " + t[i].tischNummerGeben());
            }
        }
    }
    
    public void bestellungErstellen(int tNr) {
        if(t[tNr].gaesteZahlGeben() != 0 && t[tNr].bestelltGeben()==1) {
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
    
    public String[] unbearbeiteteBestellungsinhalteGeben(int i) {
        Bestellung[] b = k.ausstehendeBestellungenGeben();
        for(int j = 0; j < b.length; j++) {
            if (b[j].auftraggeberGeben().tischNummerGeben() == i) {
                return b[j].alleDatenGeben();
            }
        }
        return null;
    }
    
    public int tischzahlGeben() {
        return t.length;
    }
    
    public Tisch tischGeben(int i) {
        return t[i];
    }
    
    public String[][] besetzteStuehleMitTischGeben(){
       String[][] i = new String[t.length][3];
       for(int j = 0; j<t.length; j++) {
           i[j][0] = "Tisch " + String.valueOf(t[j].tischNummerGeben());
           i[j][1] = String.valueOf(t[j].gaesteZahlGeben());
           i[j][2] = String.valueOf(t[j].stuhlZahlGeben());
       }
       return i;
    }
    
    public String[] besetzteStuehleGeben(){
       String[] s= new String[t.length];
       for(int i=0; i<t.length; i++){
           s[i]= t[i].datenGeben();
           t[i].datenAusgeben();
       }
       
       return s;
    }

    public String[] bestellungenInBearbeitungGeben(){
       String[] s= new String[t.length];
       Bestellung[] b = k.ausstehendeBestellungenGeben();
       for(int i=0; i<t.length;i++){
           if(b[i]!=null){
               s[i]=("Bestellung "+b[i].bestellIDGeben()+ " von Tisch "+ b[i].auftraggeberGeben().tischNummerGeben());
           }
       }
       return s;
    }
    
    public String tagesEinnahmenGeben() {
        return   String.valueOf(k.gewinnGeben());
    }
    
    public String tagesAnzahlGeben() {
        return String.valueOf(bisherigeEinnahmen.length);
    }
    
    public String gesamtEinnahmenGeben() {
        double e = 0;
        for(int i = 0; i<bisherigeEinnahmen.length; i++) {
            e = e + bisherigeEinnahmen[i];
        }
        return String.valueOf(k.gewinnGeben() + e);
    }
    
    public double[] einnahmenListeGeben() {
        return bisherigeEinnahmen;
    }
    
    public void einnhamenAktuallisieren() {
        bisherigeEinnahmen[bisherigeEinnahmen.length-1] = k.gewinnGeben();
    }
    
    public int kundenZahlGeben() {
        int kundenZahl = 0;
        for (int i = 0; i<t.length; i++) {
            kundenZahl = kundenZahl + t[i].gaesteZahlGeben();
        }
        return kundenZahl;
    }
    
}
