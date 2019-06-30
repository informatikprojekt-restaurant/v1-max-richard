package restaurantverwaltung;

/**
 *
 * @author Richard Wimmer
 */

public class Angebot {
    
    //Attribute
    String name;
    int ID;
    double preis;
    
    //Konstruktor
    public Angebot(String n, int nbr, double p){
        name = n;
        ID = nbr;
        preis = p;
    }
    
    //Methoden
    
    //Gibt alle daten des Angebots als String-Wert zurück
    public String datenGeben() {
        return (ID + " | " + name + " | " + preis + "€");
    }
    
    //Gibt den Preis als double-Wert zurück
    public double preisGeben() {
        return preis;
    }
    
}
