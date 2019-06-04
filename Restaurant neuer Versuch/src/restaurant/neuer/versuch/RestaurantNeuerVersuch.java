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
        Oberflaeche o = new Oberflaeche(r);
        r.tischDatenAusgeben();
        
        System.out.println();
        
        r.kundenKommen();
        r.tischDatenAusgeben();
        
        System.out.println();
        
        r.kundenKommen();
        r.tischDatenAusgeben();
        
        System.out.println();
        
        r.kundenGehen(1);
        r.tischDatenAusgeben();
        
        System.out.println();
        
        r.bestellungErstellen(1);
        r.bestellungErstellen(2);
        r.bestellungErstellen(3);
        r.bestellungErstellen(4);
        r.bestellungErstellen(0);
        
        System.out.println();
        
        r.unbearbeiteteBestellungenAusgeben();
        
        System.out.println();
        
        r.bearbeiteBestellung();
        
        System.out.println();
        
        r.unbearbeiteteBestellungenAusgeben();
        
        System.out.println();
        
        r.bearbeiteteBestellungenAusgeben();
        
    }
    
}
