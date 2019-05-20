package restaurant;

/**
 *
 * @author Richard Wimmer
 */
public class Getränke extends Angebot{
    
    String bezeichnung;
    int ID;
    double preis;
    

    public Getränke(String n, int nbr, double p){
        bezeichnung = n;
        ID = nbr;
        preis = p;
    }
    
    public double preisGeben() {
        return preis;
    }
    
    public void datenAusgeben(){
        System.out.println(ID + bezeichnung + preis + " | ");
    }
    
    public int IDGeben(){
        return ID;
    }
}
