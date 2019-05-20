package restaurant;

/**
 *
 * 
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tisch[] t = new Tisch[5];
        t[0]=new Tisch(5,1);
        t[1]=new Tisch(4,2);
        t[2]=new Tisch(6,3);
        t[3]=new Tisch(7,4);
        t[4]=new Tisch(3,5);
        Kueche k = new Kueche(t);
        t[0].neueGäste();
        t[0].datenAusgeben();
        k.ausstehendeBestellungenAusgeben();
        k.bestellungenAufnehmen(0);
        k.ausstehendeBestellungenAusgeben();
        // TODO code application logic here
    }
    
}
