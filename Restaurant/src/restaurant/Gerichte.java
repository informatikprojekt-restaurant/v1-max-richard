package restaurant;
//author @Richard
public class Gerichte extends Angebot {
    
    String bezeichnung;
    int ID;
    double preis;
    
    public Gerichte(String n, int nbr, double p){
        bezeichnung = n;
        ID = nbr;
        preis = p;
    }
    
    public void datenAusgeben(){
        
    }
    
    public int IDGeben(){
        return ID;
    }
    
    public double preisGeben() {
        return preis;
    }
}
