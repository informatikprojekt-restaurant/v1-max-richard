package restaurant;
//author @Richard
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
        
    }
    
    public int IDGeben(){
        return ID;
    }
}
