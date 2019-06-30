package restaurantverwaltung;

//Importe
import java.util.Random;

/**
 *
 * @author Richard Wimmer
 */

public class Bestellung {
    
    //Attribute
    private int bestellID;
    private Angebot[] auswahl;
    private Tisch auftraggeber;
    private Random number;
    
    //Konstruktor
    public Bestellung(int ID, Tisch t, Angebot[] speisekarte)
    {
        bestellID = ID + 1;
        auftraggeber = t;
        auswahl = new Angebot[auftraggeber.gaesteZahlGeben() * 2];
        number = new Random();
        
        for(int i = 0; i < (auftraggeber.gaesteZahlGeben()); i++)
        {
            //"(39)", da die Indexe von 0 bis 39 in der Speisekarte von Speisen belegt sind
            auswahl[i] = speisekarte[number.nextInt(39)];
            //"(10) + 40", da die Indexe von 40 bis 50 in der Speisekarte von Getränken belegt sind
            auswahl[i + auftraggeber.gaesteZahlGeben()] = speisekarte[number.nextInt(10) + 40];
        }
        
        //Der Zustand des Tisches ist damit: "Gaeste sitzen am Tisch und haben eine Bestellung aufgegeben, welche noch nicht bearbeitet wurde"
        t.zustandSetzen(2);
    }
    
    //Methoden
    
    //Gibt den Gesamtpreis aller Angebote in der Bestellung als double-Wert zurück
    public double bestellungsPreisGeben()
    {
        double gesamtpreis = 0;
        for (int i = 0; i < auswahl.length; i++)
        {
            gesamtpreis = auswahl[i].preisGeben() + gesamtpreis;
        }
        return gesamtpreis;
    }
    
    //Gibt den Tisch, welcher die Bestellung aufgegeben hat zurück
    public Tisch auftraggeberGeben()
    {
        return auftraggeber;
    }
    
    //Gibt die ID der Bestellung als int-Wert zurück
    public int bestellIDGeben()
    {
        return bestellID;
    }
    
    //Gibt die Daten aller Angebote, welche die Bestellung enthält als String-Array zurück
    public String[] alleDatenGeben() {
        String[] s = new String[auswahl.length + 1];
        s[0] = ("Bestellung " + bestellID + " von Tisch " + auftraggeber.tischNummerGeben());
        for(int i = 0; i < auswahl.length; i++) {
            s[i + 1] = auswahl[i].datenGeben();
        }
        return s;
    }
    
}
