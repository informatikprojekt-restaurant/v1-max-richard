package restaurantverwaltung;

/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
 */
public class Angebot {
    
    String name;
    int ID;
    double preis;
    int zubereitungsZeit;
    
    public Angebot(String n, int nbr, double p){
        name = n;
        ID = nbr;
        preis = p;
    }
    
    public String datenGeben() {
        return (ID + " | " + name + " | " + preis + "€");
    }
    
    public double preisGeben() {
        return preis;
    }
    
}
