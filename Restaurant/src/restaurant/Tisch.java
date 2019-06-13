package restaurant;
import java.util.Random;

/**
 *
 * @author Katharina Lainer
 */
public class Tisch {

    private int stuhlzahl;
    private int tischnr;
    private int besetzt;
    private Random number;
    private boolean bestellt;

    public Tisch (int sz, int nr){

        stuhlzahl = sz;
        tischnr = nr;
        besetzt = 0;
        number = new Random();
        bestellt = false;
    }

    public void gaesteKommen (int anzahl){

        if(anzahl < stuhlzahl){

            besetzt = anzahl;
        }
    }

    public void gaesteGehen(){

        besetzt = 0;
    }

    public int stuhlZahlGeben(){

        return stuhlzahl;
    }

    public int gaesteZahlGeben(){

        return besetzt;
    }

    public void datenAusgeben(){

        System.out.println("Tisch " + tischnr + ": Gästezahl = " + besetzt + " von " + stuhlzahl);
    }

    public int tischNummerGeben(){

        return tischnr;
    }
    
    public boolean bestelltGeben() {
        return bestellt;
    }
    
    public void bestelltSetzen(boolean b) {
        bestellt = b;
    }
    
}
