/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantverwaltung;
import java.util.Random;


/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
 * clock???????
 */
public class Bestellung {
    private int bestellID;
    private Angebot[] auswahl;
    private Tisch auftraggeber;
    private Random number;
    
    public Bestellung(int ID, Tisch t, Angebot[] speisekarte)
    {
        bestellID = ID + 1;
        auftraggeber = t;
        auswahl = new Angebot[auftraggeber.gaesteZahlGeben() * 2];
        number = new Random();
        
        for(int i = 0; i < (auftraggeber.gaesteZahlGeben()); i++)
        {
            auswahl[i] = speisekarte[number.nextInt(39)];
            auswahl[i + auftraggeber.gaesteZahlGeben()] = speisekarte[number.nextInt(11) + 40];
        }
        
        t.zustandSetzen(2);
    }
    
    public double bestellungsPreisGeben()
    {
        double gesamtpreis = 0;
        for (int i = 0; i < auswahl.length; i++)
        {
            gesamtpreis = auswahl[i].preisGeben() + gesamtpreis;
        }
        return gesamtpreis;
    }
    
    public Tisch auftraggeberGeben()
    {
        return auftraggeber;
    }
    
    public int bestellIDGeben()
    {
        return bestellID;
    }
    
//    public int bearbeitungsZeitGeben() 
//    {
//        int bearbeitungszeit = 0;
//        for (int i = 0; i < auswahl.length; i++) 
//        {
//            bearbeitungszeit = bearbeitungszeit + auswahl[i].zubereitungsZeitGeben();
//        }
//        return bearbeitungszeit;
//    }
    
    public String[] alleDatenGeben() {
        String[] s = new String[auswahl.length + 1];
        s[0] = ("Bestellung " + bestellID + " von Tisch " + auftraggeber.tischNummerGeben());
        for(int i = 0; i < auswahl.length; i++) {
            s[i + 1] = auswahl[i].datenGeben();
        }
        return s;
    }
    
}
