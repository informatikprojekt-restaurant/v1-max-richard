package restaurant;
import java.util.Random;

/**
 *
 * @author Sina Lemke
 */
public class Bestellung {
    
    private int bestellNummer;
    private Speisekarte s;
    private Angebot[] auswahl;
    Tisch auftraggeber;
    
    Bestellung (int nr,int anzahl, Tisch t)
    {
        bestellNummer=nr;
        Random number = new Random();
        auftraggeber = t;
        
        for (int i=0;i<anzahl;i++)
        {
            int n = number.nextInt(10)+1; //GerichteIndizes
            auswahl[i]=s.speisekarte[n];
        }
        
        for (int i=anzahl;i<anzahl*2;i++)
        {
            int m = number.nextInt(20)+11;//GetränkIndize
            auswahl[i]=s.speisekarte[m];
        }
        
    }
    
    public void inhaltAusgeben()
    {
        
    }
    
    public double preisBerechnen()
    {
        double gesamtpreis =0;
        for (int i=0;i<auswahl.length;i++) {
            gesamtpreis = auswahl[i].preisGeben()+gesamtpreis;
        }
        return gesamtpreis;
    }
    
}