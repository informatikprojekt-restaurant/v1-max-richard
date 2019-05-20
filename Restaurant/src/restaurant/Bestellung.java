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
    private Tisch auftraggeber;
    
    Bestellung (int nr,int anzahl, Tisch t)
    {
        bestellNummer=nr;
        Random number = new Random();
        auftraggeber = t;
        auswahl = new Angebot[anzahl * 2];
        
        for (int i=0;i<anzahl;i++)
        {
            int n = number.nextInt(9)+1; //GerichteIndizes
            auswahl[i]=s.speisekarte[n];
            int m = number.nextInt(4)+11;//GetränkIndize
            auswahl[i + anzahl]=s.speisekarte[m];
        }
        
    }
    
    public void inhaltAusgeben()
    {
        for(int i= 0;i<auswahl.length;i++) {
            auswahl[i].datenAusgeben();
        }
    }
    
    public double preisBerechnen()
    {
        double gesamtpreis =0;
        for (int i=0;i<auswahl.length;i++) {
            gesamtpreis = auswahl[i].preisGeben()+gesamtpreis;
        }
        return gesamtpreis;
    }
    
    public int elementanzahlGeben()
    {
        return auswahl.length;
    }
    
}