/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;

/**
 *
 * @author Thomas Weber
 */
public class RestaurantNeuerVersuch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Restaurant r = new Restaurant(5);
        
        r.tischDatenAusgeben();
        r.kundenKommen();
        r.tischDatenAusgeben();
        r.kundenKommen();
        r.tischDatenAusgeben();
        r.kundenGehen(1);
        r.tischDatenAusgeben();
        r.bestellungErstellen(2);
        r.zuBearbeitendeBestellungenAusgeben();
        
    }
    
}
