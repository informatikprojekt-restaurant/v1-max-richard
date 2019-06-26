/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantverwaltung;

/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
 * clock????
 */
public class Angebot {
    
    String name;
    int ID;
    double preis;
    int zubereitungsZeit;
    
    public Angebot(String n, int nbr, double p, int z){
        name = n;
        ID = nbr;
        preis = p;
        zubereitungsZeit = z;
    }
    
//    public int zubereitungsZeitGeben() {
//        return zubereitungsZeit;
//    }
    
    public String datenGeben() {
        return (ID + " | " + name + " | " + preis + "€");
    }
    
    public double preisGeben() {
        return preis;
    }
    
}
