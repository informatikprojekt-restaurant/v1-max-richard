package restaurant;
//author @Richard
public class Getränke extends Angebot{
    
    String bezeichnung;
    int ID;
    double preis;
    Vorrat[] zutatenliste;
    

    public Getränke(String n, int nbr, double p){
        bezeichnung = n;
        ID = nbr;
        preis = p;
        zutatenliste = new Vorrat[3];
    }
    
    public void bestellen(){
        
    }
    
    public void datenAusgeben(){
        
    }
    
    public int IDGeben(){
        
    }
}
