package restaurant;
import java.util.Random;

/**
 *
 * @author Sina Lemke
 */
public class Tisch {
    
    private int stuhlzahl;
    private int tischnr;
    private int besetzt;
    
    Tisch(int sz,int nr)
    {
        stuhlzahl=sz;
        tischnr=nr;
        besetzt=0;
    }
    
    public void neueGäste()
    {
        Random number = new Random();
        int be = number.nextInt(stuhlzahl-1)+1;
        besetzt=be;
    }
    
    public void datenAusgeben() {
        System.out.println("Tisch " + tischnr + " Gästezahl: "+ besetzt + " von " + stuhlzahl);
    }
    
    public void gehendeGäste()
    {
        besetzt=0;
    }
    
    public int stuhlzahlGeben()
    {
        return stuhlzahl;
    }
    
    public Bestellung bestellungAufgeben()
    {
        if (besetzt != 0) {
            Bestellung b = new Bestellung(tischnr, besetzt, this);
            return b;
        } else {
            return null;
        }
    }
    
}