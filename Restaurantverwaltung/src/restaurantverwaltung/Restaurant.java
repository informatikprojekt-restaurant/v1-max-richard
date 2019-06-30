package restaurantverwaltung;

//Improte
import java.util.Random;

/**
 *
 * @author Sina Lemke
 */

public class Restaurant {
    
    //Attribute
    private Kueche k;
    private Tisch[] t;
    private Angebot[] speisekarte;
    private Random number;
    private double[] einnahmen;
    
    //Konstruktor
    public Restaurant(int tz) {
        
        speisekarte = new Angebot[51];
        t = new Tisch[tz];
        k = new Kueche(t.length);
        number = new Random();
        einnahmen = new double[1];
        
        //Erstellen der Tische mit zufälligen Stuhlzahlen zwischen 3 und 10
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tisch((number.nextInt(7) + 3), (i + 1));
        }
        
        /**
         * Speisekarte:
         * @author Katharina Lainer
         */
        
        //Array "speisekarte" enthält das Angebot des Restaurants welches im Restaurant erstellt wird gespeichert ist
        speisekarte[0] = new Angebot( "Pizza Margherita", 1, 5.70);
        speisekarte[1] = new Angebot("Pizza Salami", 2, 6.50);
        speisekarte[2] = new Angebot("Pizza Funghi", 3, 6.30);
        speisekarte[3] = new Angebot("Pizza Napoli", 4, 6.50);
        speisekarte[4] = new Angebot("Pizza Hawaii", 5, 7.20);
        speisekarte[5] = new Angebot("Pizza Quattro Stagioni", 6, 7.20);
        speisekarte[6] = new Angebot("Pizza Mozzarella", 7, 7.40);
        speisekarte[7] = new Angebot("Pizza Spezial", 8, 8.20);
        speisekarte[8] = new Angebot("Pizza Regina", 9, 6.90);
        speisekarte[9] = new Angebot("Pizza Capricciosa", 10, 8.20);
        speisekarte[10] = new Angebot("Pizza Frutti di Mare", 11, 8.90);
        speisekarte[11] = new Angebot("Pizza Sorentina", 12, 8.90);
        speisekarte[12] = new Angebot("Pizza Parma", 13, 8.90);
        speisekarte[13] = new Angebot("Pizza Tonno", 14, 6.90);
        speisekarte[14] = new Angebot("Pizza Prosciutto", 15, 6.90);
        speisekarte[15] = new Angebot("Pizza Romana", 16, 6.90);
        speisekarte[16] = new Angebot("Pizza Diavola", 17, 7.20);
        speisekarte[17] = new Angebot("Pizza Caprese", 18, 7.90);
        speisekarte[18] = new Angebot("Pizza Italia", 19, 8.40);
        speisekarte[19] = new Angebot("Pizzabrot", 20, 4.00);
        speisekarte[20] = new Angebot("Bolognese", 21, 5.90);
        speisekarte[21] = new Angebot("Spaghetti Napoli", 22, 5.20);
        speisekarte[22] = new Angebot("Spaghetti Aglio e olio", 23, 5.90);
        speisekarte[23] = new Angebot("Rigatoni Cinque Formaggi", 24, 7.40);
        speisekarte[24] = new Angebot("Penne Arrabiata", 25, 5.90);
        speisekarte[25] = new Angebot("Lasagne Bolognese", 26, 6.50);
        speisekarte[26] = new Angebot("Spaghetti Carbonara", 27, 6.50);
        speisekarte[27] = new Angebot("Gnocchi Sorrentina", 28, 6.50);
        speisekarte[28] = new Angebot("Tortellini Speziale", 29,7.20);
        speisekarte[29] = new Angebot("Rigatoni Al Forno", 30, 7.20);
        speisekarte[30] = new Angebot("Chicken Nuggets (6 Stück)", 31, 3.90);
        speisekarte[31] = new Angebot("Chicken Nuggets (9 Stück)", 32, 4.90);
        speisekarte[32] = new Angebot("Country Wedges", 33, 4.70);
        speisekarte[33] = new Angebot("Pommes Frites", 34, 4.90);
        speisekarte[34] = new Angebot("Chicken Wings (6 Stück)", 35, 5.20);
        speisekarte[35] = new Angebot("Chicken Wings (20 Stück)", 36, 13.90);
        speisekarte[36] = new Angebot("Bruschetta Italiana", 37, 5.20);
        speisekarte[37] = new Angebot("Gemischter Salat", 38, 4.20);
        speisekarte[38] = new Angebot("Tomatensalat", 39, 5.20);
        speisekarte[39] = new Angebot("Meeresfrüchtesalat", 40, 8.20);
        speisekarte[40] = new Angebot("Tafelwasser",41, 2.50);
        speisekarte[41] = new Angebot("Softdrink 0.3l", 42, 2.70);
        speisekarte[42] = new Angebot("Softdrink 0.5l", 43, 3.80);
        speisekarte[43] = new Angebot("Säfte 0.2l", 44, 2.90);
        speisekarte[44] = new Angebot("Säfte 0.5l", 45, 3.80);
        speisekarte[45] = new Angebot("Virgin Colada", 46, 5.50);
        speisekarte[46] = new Angebot("Sex on the Beach", 47, 7.50);
        speisekarte[47] = new Angebot("Weißbier 0.5l", 48, 3.50);
        speisekarte[48] = new Angebot("Radler hell/dunkel 0.5l", 49, 3.60);
        speisekarte[49] = new Angebot("Chardonnay 0.2l", 50, 3.90);
        speisekarte[50] = new Angebot("Heilbronner Rotwein 0.2l", 51, 4.50);
    }
    
    //Methoden
    
    //Eine zufällige Anzahl Kunden, welche kleiner als die jeweilige Stuhlzahl des Tisches ist, wird an die "gaesteKommen"-Methode in "Tisch" übergeben
    public void kundenKommen(int tNr) {
        t[tNr].gaesteKommen(number.nextInt(t[tNr].stuhlZahlGeben()-2) + 2);
    }
    
    //Der Tisch mit der entsprechenden Tischnummer wird von den Gästen (wenn vorhanden) verlassen
    public void kundenGehen(int tNr) {
        t[tNr].gaesteGehen();
    }
    
    //eine neue Bestellung wird, wenn gerade Gäste an dem Tisch sitzen, welche noch nichts bestellt haben, mit dem entsprechenden Auftraggeber erstellt und an die Küche übergeben
    public void bestellungErstellen(int tNr) {
        if(t[tNr].zustandGeben()==1) {
            k.bestellungAufnehmen(new Bestellung(k.anzahlBestellungenGeben(), t[tNr], speisekarte));
            
        }
    }
    
    //Der zu der übergebenen Tischnummer zugehörige Tisch wird der "bestellungBearbeiten"-Methode in Küche übergeben
    public void bearbeiteBestellung(int tNr) {
        k.bestellungBearbeiten(t[tNr]);
    }
    
    //Die Tsichzahl wird zurückgegeben
    public int tischzahlGeben() {
        return t.length;
    }
    
    //Der zu dem Index zugehörige Tisch wird zurückgegeben
    public Tisch tischGeben(int i) {
        if(i<t.length){
            return t[i];
        } else {
            return null;
        }
    }
    
    //Aus den Methoden "datenGeben" in jedem Tisch wird ein String-Array erstellt und zurückgegeben
    public String[] besetzteStuehleGeben(){
       String[] s = new String[t.length];
       for(int i = 0; i < t.length; i++) {
           s[i]= t[i].datenGeben();
       }
       return s;
    }

    //Die Methode "bearbeitungslisteGeben" in Küche wird zurückgegeben
    public String[] bestellungenInBearbeitungGeben(){
       return k.bearbeitungslisteGeben();
    }
    
    //die Einnahmen der jetzigen Sequenz werden als gerundeter double-Wert zurückgegeben
    public double sequenzEinnahmenGeben() {
        einnahmen[einnahmen.length - 1] = k.gewinnGeben();
        return   Math.round(einnahmen[einnahmen.length-1] * 100) / 100.0;
    }
    
    //Die Anzahl der Sequenzen wird als int-Wert zurückgegeben
    public int sequenzAnzahlGeben() {
        return einnahmen.length;
    }
    
    //Die Einnahmen aus allen bisherigen Sequenzen werden zusammengezählt und zurückgegeben
    public double gesamtEinnahmenGeben() {
        double e = 0;
        einnahmen[einnahmen.length - 1] = k.gewinnGeben();
        for(int i = 0; i<einnahmen.length; i++) {
            e = e + einnahmen[i];
        }
        return Math.round(e * 100) / 100.0;
    }
    
    //Bearbeitet alle Tische so lange bis sie in den Ursprungszustand zurückwechseln
    public void alleProzesseAbschließen() {
        for(int i = 0; i<t.length; i++) {
            switch(t[i].zustandGeben()) {
                case 0:
                    break;
                case 1:
                    this.bestellungErstellen(i);
                case 2:
                    this.bearbeiteBestellung(i);
                case 3:
                    t[i].gaesteGehen();
            }
        }
        einnahmen[einnahmen.length-1] = k.gewinnGeben();
    }
    
    //Gibt die Methode "leistungslisteGeben" in Küche als String-Array zurück
    public String[] abgeschlosseneBestellungenGeben() {
        return k.leistungslisteGeben();
    }
    
    //Gibet die Methode "bestellungsZahlGeben" in Küche zurück
    public int bestellungsZahlGeben() {
        return k.anzahlBestellungenGeben();
    }
    
    //Gibt die Methode "bestellungsInhaltGeben" in Küche mit der gesuchten BestellungsID als Übergabeparameter zurück 
    public String[] bestellungGeben(int id) {
        return k.bestellungsInhaltGeben(id);
    }
    
    //Erstellt ein neues einnahmen-Array, welches die selben Werte enthält, aber um einen Index länger ist
    public void neueSequenz() {
        double[] einnahmenNeu = new double[einnahmen.length + 1];
        for (int i = 0; i<einnahmen.length;i++) {
            einnahmenNeu[i] = einnahmen[i];
        }
        einnahmen = einnahmenNeu;
    }
    
}
