package restaurantverwaltung;

//Importe
import java.util.Random;

/**
 *
 * @author Katharina Lainer
 */
public class Tisch {
    
    //Attribute
    private int stuhlzahl;
    private int tischNr;
    private int gaesteZahl;
    private Random number;
    private int zustand;

    //Konstruktor
    public Tisch (int sz, int nr){
        
        stuhlzahl = sz;
        tischNr = nr;
        gaesteZahl = 0;
        number = new Random();
        zustand = 0;
        /*
        das Attribut zustand gibt den Zustand des Tisches an.
        zustand = 0: Es sitzen keine Kunden am Tisch
        zustand = 1: Es sitzen Kunden am Tisch aber es wurde noch keine Bestellung aufgegeben
        zustand = 2: Es sitzen Kunden am Tisch und es wurde eine Bestellung aufgegeben
        zustand = 3: Es sitzen Kunden am Tisch und die aufgegebenen Bestellung wurde bearbeitet
        */
    }
    
    //Methoden

    //Anzahl an Gästen die sich an den Tisch setzen wird übergeben und abgespeichert
    public void gaesteKommen(int anzahl) {
        if(stuhlzahl >= anzahl && gaesteZahl == 0 && zustand == 0) {
            gaesteZahl = anzahl;
            zustand = 1;
        }
    }
    
    //Lässt die Gäste gehen, unter der Bedingung, dass diese bereits eine Bestellung aufgegeben haben und diese Bestellung auch schon bearbeitet wurde
    public void gaesteGehen(){
        if (zustand == 3) {
            gaesteZahl = 0;
            zustand = 0;
        }
    }

    //Gibt die Stuhlzahl des jeweiligen Tisches zurück
    public int stuhlZahlGeben(){

        return stuhlzahl;
    }

    //Gibt die Anzahl der Gäste die an diesem Tisch sitzen zurück
    public int gaesteZahlGeben(){

        return gaesteZahl;
    }
    
    //Gibt die Nummer des Tisches zurück
    public int tischNummerGeben(){

        return tischNr;
    }
    
    //Gibt den Zustand des Tisches zurück
    public int zustandGeben() {
        return zustand;
    }
    
    //Ändert den Zustand des Tisches
    public void zustandSetzen(int z) {
        if (-1 < z && z < 4) {
            zustand = z;
        }
    }
    
    //Gibt die Daten des Tisches als String zurück
    public String datenGeben() {
        return ("Tisch " + tischNr + ": Gästezahl = " + gaesteZahl + " von " + stuhlzahl);
    }
    
}
