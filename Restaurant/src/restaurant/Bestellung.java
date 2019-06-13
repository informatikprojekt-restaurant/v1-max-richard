package restaurant.neuer.versuch;
import java.util.Random;
import java.util.Arraylist

/**
 *
 * @author Richard Wimmer
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
            auswahl[i] = speisekarte.get(number.nextInt(9) + 1);
            auswahl[i + auftraggeber.gaesteZahlGeben()] = speisekarte.get(number.nextInt(3) + 11);
        }
    }
    
    public void inhaltAusgeben()
    {
        System.out.println("Bestellung " + bestellID + " von Tisch " auftraggeber.tischNummerGeben());
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
    
    public int bearbeitungsZeitGeben() 
    {
        int bearbeitungszeit = 0;
        for (int i = 0; i < auswahl.length; i++) 
        {
            bearbeitungszeit = bearbeitungszeit + auswahl[i].zubereitungsZeitGeben();
        }
    }
    
}
