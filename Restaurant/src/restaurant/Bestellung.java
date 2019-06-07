/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.util.Random;
import java.util.Arraylist

/**
 *
 * @author Richard Wimmer
 */
public class Bestellung {
    private int bestellungID;
    private Angebot[] auswahl;
    private Tisch auftraggeber;
    private Random number;
    
    public Bestellung(int ID, Tisch t, ArrayList<Angebot> speisekarte)
    {
        bestellID = ID + 1;
        auftraggeber = t;
        auswahl = new Angebot[auftraggeber.gaesteZahlGeben() * 2];
        number = new Random();
        
        for(int i = 0; i < (auftraggeber.gaesteZahlGeben()); i++)
        {
            auswahl[i] = speisekarte.get(number.nextInt(9) + 1);
            auswahl[i + auftraggeber.gaesteZahlGeben()] = speisekarte.get(number.nextInt(3) + 11);
        }
    }
    
    public void inhaltAusgeben()
    {
        System.out.println("Bestellung " + bestellID);
        for(int i = 0; i < auswahl.length; i++)
        {
            auswahl[i].datenAusgeben();
        }
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
    
    public int elementAnzahlGeben()
    {
        return auswahl.length;
    }
    
    public Tisch auftraggeberGeben()
    {
        return auftraggeber;
    }
    
    public int bestellIDGeben()
    {
        return bestellID;
    }
    
    public Angebot inhaltGeben(int index)
    {
        return auswahl[index];
    }
    
}
