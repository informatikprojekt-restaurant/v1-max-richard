/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantverwaltung;
import java.util.Random;

/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
 */
public class Tisch {

    //stuhlzahl gibt die Anzahl der Maximalen Gäste des Tisches an
    private int stuhlzahl;
    
    //tischnr gibt die Tischnummer des Tisches an
    private int tischnr;
    
    //besetzt gibt an wieviele Gäste an dem Tisch sitzen
    private int besetzt;
    private Random number;
    private int zustand;

    public Tisch (int sz, int nr){

        stuhlzahl = sz;
        tischnr = nr;
        besetzt = 0;
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

    //Methode gaesteKommen setzt Gäste an den Tisch setzen
    public void gaesteKommen(int anzahl) {
        if(stuhlzahl < anzahl && besetzt != 0) {
            System.out.println(anzahl + "kein platz an tisch " + tischnr);
        } else {
            besetzt = anzahl;
            zustand = 1;
            System.out.println(besetzt + "sitzt an tisch " + tischnr);
        }
    }
    
    //Lässt die Gäste gehen, unter der Bedingung, dass diese bereits eine Bestellung aufgegeben haben und diese auch schon überarbeitet wurde
    public void gaesteGehen(){
        if (zustand == 3) {
            besetzt = 0;
            zustand = 0;
        }
    }

    //Gibt die Stuhlzahl des jeweiligen Tisches
    public int stuhlZahlGeben(){

        return stuhlzahl;
    }

    //Gibt die Anzahl der Gäste die an diesem Tisch sitzen
    public int gaesteZahlGeben(){

        return besetzt;
    }
    
    //Gibt die Nummer des Tisches zurück
    public int tischNummerGeben(){

        return tischnr;
    }
    
    //Gibt den Zustand des Tisches zurück
    public int zustandGeben() {
        return zustand;
    }
    
    //Ändert den Zustand des Tisches
    public void zustandSetzen(int z) {
        zustand = z;
    }
    
    //Gibt die Daten des Tisches als String aus
    public String datenGeben() {
        return ("Tisch " + tischnr + ": Gästezahl = " + besetzt + " von " + stuhlzahl);
    }
    
}
