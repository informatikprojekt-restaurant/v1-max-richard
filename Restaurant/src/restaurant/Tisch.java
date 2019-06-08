package restaurant;
import java.util.Random;

/**
 *
 * @author Katharina Lainer
 */
public class Tisch {
public class Tisch{

    private int stuhlzahl;
    private int tischnr;
    private int besetzt;
    private Random number;

    public Tisch (int sz, int nr){

        stuhlzahl = sz;
        tischnr = nr;
        besetzt = 0;
        number = new Random();
    }

    public boolean gaesteKommen (int anzahl){

        if(stuhlzahl < anzahl){

            return false;
        }else{

            besetzt = anzahl;
            return true;
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
}
