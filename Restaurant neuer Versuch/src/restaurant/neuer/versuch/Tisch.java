/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.util.Random;

/**
 *
 * @author Thomas Weber
 */
public class Tisch {

    private int stuhlzahl;
    private int tischnr;
    private int besetzt;
    private Random number;
    private int bestellt;

    public Tisch (int sz, int nr){

        stuhlzahl = sz;
        tischnr = nr;
        besetzt = 0;
        number = new Random();
        bestellt = 0;
    }

    public void gaesteKommen(int anzahl) {
        if(stuhlzahl < anzahl && besetzt != 0) {
            System.out.println(anzahl + "kein platz an tisch " + tischnr);
        } else {
            besetzt = anzahl;
            bestellt = 1;
            System.out.println(besetzt + "sitzt an tisch " + tischnr);
        }
    }
    
    public void gaesteGehen(){
        if (bestellt == 3) {
            besetzt = 0;
            bestellt = 0;
        }
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
    
    public int bestelltGeben() {
        return bestellt;
    }
    
    public void bestelltSetzen(int b) {
        bestellt = b;
    }
    
    public String datenGeben() {
        return ("Tisch " + tischnr + ": Gästezahl = " + besetzt + " von " + stuhlzahl);
    }
    
}
