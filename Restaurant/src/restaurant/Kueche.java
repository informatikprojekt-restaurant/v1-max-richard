package restaurant;
import java.util.ArrayList;

/**
 *
 * @author Max Demel
 */

public class Kueche {
    
    private Bestellung[] bearbeitungsliste;
    private ArrayList<Bestellung> leistungsliste;
    
    public Kueche(int Kapazität){
        bearbeitungsliste = new Bestellung[Kapazität];
        leistungsliste= new ArrayList<Bestellung>(0);
    }
    
    public void BestellungAufnehmen(Bestellung b){
        boolean istEingereiht=false;
        for(int i=0; i<bearbeitungsliste.length; i++){
            if(bearbeitungsliste[i] == null && !istEingereiht)[
                bearbeitungsliste[i]=b;
                System.out.println("Die Bestellung von Tisch"+ (b.auftraggebenGeben()).tischNummerGeben()+ "wurde erfolgreich auf dem"+     (i+1)+". Platz eingereiht");
                istEingereiht=!istEingereiht;
                } else{
                    if(i==(bearbeitungsliste.length-1)&&!istEingereiht){
                       System.out.println("Die warteschlange ist Voll!");
		    }
		}
    }
     
     public void ausstehendeBestellungenAusgeben(){
        if(bearbeitungsliste[0] != null){
            for(int i=0; i<bearbeitungsliste.length; i++){
                if(bearbeitungsliste[i]!=null) {
                    bearbeitungsliste[i].inhaltAusgeben();
                    System.out.println();
                }
            }
        }else{
            System.out.println("Keine Bestellungen in der Bearbeitungsliste vorhanden!");
        }
    }
    
    public void bestellungBearbeiten(){
        if(bearbeitungsliste[0] != null){
            System.out.println("Bestellung " + bearbeitungsliste[0].bestellIDGeben() + " wird nun bearbeitet!");
            for(int i = 0; i < bearbeitungsliste[0].elementAnzahlGeben(); i++){
                CitchenClock cc = new CitchenClock();
                cc.run((bearbeitungsliste[0].inhaltGeben(i)).zubereitungsZeitGeben());
                System.out.println("Zu " + ((double)i + 1) / ((double)bearbeitungsliste[0].elementAnzahlGeben()) * 100 + "% fertiggestellt!");
            }
            leistungsliste.add(bearbeitungsliste[0]);
            for(int i = 0; (i + 1) < bearbeitungsliste.length; i++){
                bearbeitungsliste[i] = bearbeitungsliste[i+1];
            }
        }else{
            System.out.println("Keine Bestellungen zur Bearbeitung vorhanden");
        }
    }
    
    public int anzahlBestellungenGeben(){
        int anz = 0;
        for(int i = 0; i < bearbeitungsliste.length; i++)
            if(bearbeitungsliste[i] != null){
                anz++;
            }
        }
        for(int i = 0; i < leistungsliste.size(); i++){
            if(leistungsliste.get(i) != null) {
                anz++;
            }
        }
        return anz;
    }
    
    public void fertigeBestellungenAusgeben() {
        for(int i = 0; i < leistungsliste.size(); i++) {
            leistungsliste.get(i).inhaltAusgeben();
            System.out.println();
        }
    }
    
}
