/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantverwaltung;
import java.util.Random;

/**
 *
 * @author Thomas Weber
 * nur noch überarbeiten
 */
public class Restaurant {
    
    private Kueche k;
    private Tisch[] t;
    private Angebot[] speisekarte;
    private Random number;
    private double[] einnahmen;
    
    public Restaurant(int tz, double[] e) {
        speisekarte = new Angebot[51];
        t = new Tisch[tz];
        k = new Kueche(t.length);
        number = new Random();
        
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tisch((number.nextInt(7) + 3), (i + 1));
        }
        
        speisekarte[0] = new Angebot( "Pizza Margherita", 1, 5.70, 10);
        speisekarte[1] = new Angebot("Pizza Salami", 2, 6.50, 10);
        speisekarte[2] = new Angebot("Pizza Funghi", 3, 6.30, 10);
        speisekarte[3] = new Angebot("Pizza Napoli", 4, 6.50, 10);
        speisekarte[4] = new Angebot("Pizza Hawaii", 5, 7.20, 10);
        speisekarte[5] = new Angebot("Pizza Quattro Stagioni", 6, 7.20, 12);
        speisekarte[6] = new Angebot("Pizza Mozzarella", 7, 7.40, 10);
        speisekarte[7] = new Angebot("Pizza Spezial", 8, 8.20, 12);
        speisekarte[8] = new Angebot("Pizza Regina", 9, 6.90, 10);
        speisekarte[9] = new Angebot("Pizza Capricciosa", 10, 8.20, 12);
        speisekarte[10] = new Angebot("Pizza Frutti di Mare", 11, 8.90, 12);
        speisekarte[11] = new Angebot("Pizza Sorentina", 12, 8.90, 12);
        speisekarte[12] = new Angebot("Pizza Parma", 13, 8.90, 10);
        speisekarte[13] = new Angebot("Pizza Tonno", 14, 6.90, 10);
        speisekarte[14] = new Angebot("Pizza Prosciutto", 15, 6.90, 12);
        speisekarte[15] = new Angebot("Pizza Romana", 16, 6.90, 10);
        speisekarte[16] = new Angebot("Pizza Diavola", 17, 7.20, 10);
        speisekarte[17] = new Angebot("Pizza Caprese", 18, 7.90, 12);
        speisekarte[18] = new Angebot("Pizza Italia", 19, 8.40, 12);
        speisekarte[19] = new Angebot("Pizzabrot", 20, 4.00, 8);
        speisekarte[20] = new Angebot("Bolognese", 21, 5.90, 20);
        speisekarte[21] = new Angebot("Spaghetti Napoli", 22, 5.20, 20);
        speisekarte[22] = new Angebot("Spaghetti Aglio e olio", 23, 5.90, 20);
        speisekarte[23] = new Angebot("Rigatoni Cinque Formaggi", 24, 7.40, 20);
        speisekarte[24] = new Angebot("Penne Arrabiata", 25, 5.90, 20);
        speisekarte[25] = new Angebot("Lasagne Bolognese", 26, 6.50, 28);
        speisekarte[26] = new Angebot("Spaghetti Carbonara", 27, 6.50, 22);
        speisekarte[27] = new Angebot("Gnocchi Sorrentina", 28, 6.50, 20);
        speisekarte[28] = new Angebot("Tortellini Speziale", 29,7.20, 22);
        speisekarte[29] = new Angebot("Rigatoni Al Forno", 30, 7.20, 22);
        speisekarte[30] = new Angebot("Chicken Nuggets (6 Stück)", 31, 3.90, 15);
        speisekarte[31] = new Angebot("Chicken Nuggets (9 Stück)", 32, 4.90, 18);
        speisekarte[32] = new Angebot("Country Wedges", 33, 4.70, 15);
        speisekarte[33] = new Angebot("Pommes Frites", 34, 4.90, 15);
        speisekarte[34] = new Angebot("Chicken Wings (6 Stück)", 35, 5.20, 15);
        speisekarte[35] = new Angebot("Chicken Wings (20 Stück)", 36, 13.90, 20);
        speisekarte[36] = new Angebot("Bruschetta Italiana", 37, 5.20, 18);
        speisekarte[37] = new Angebot("Gemischter Salat", 38, 4.20, 10);
        speisekarte[38] = new Angebot("Tomatensalat", 39, 5.20, 10);
        speisekarte[39] = new Angebot("Meeresfrüchtesalat", 40, 8.20, 15);
        speisekarte[40] = new Angebot("Tafelwasser",41, 2.50, 3);
        speisekarte[41] = new Angebot("Softdrink 0.3l", 42, 2.70, 3);
        speisekarte[42] = new Angebot("Softdrink 0.5l", 43, 3.80, 3);
        speisekarte[43] = new Angebot("Säfte 0.2l", 44, 2.90, 4);
        speisekarte[44] = new Angebot("Säfte 0.5l", 45, 3.80, 4);
        speisekarte[45] = new Angebot("Virgin Colada", 46, 5.50, 6);
        speisekarte[46] = new Angebot("Sex on the Beach", 47, 7.50, 6);
        speisekarte[47] = new Angebot("Weißbier 0.5l", 48, 3.50, 5);
        speisekarte[48] = new Angebot("Radler hell/dunkel 0.5l", 49, 3.60, 5);
        speisekarte[49] = new Angebot("Chardonnay 0.2l", 50, 3.90, 5);
        speisekarte[50] = new Angebot("Heilbronner Rotwein 0.2l", 51, 4.50, 5);
        
        einnahmen = new double[e.length + 1];
        for (int i = 0; i<e.length;i++) {
            einnahmen[i] = e[i];
        }
        
    }
    
    public void kundenKommen(Tisch t) {
        t.gaesteKommen(number.nextInt(t.stuhlZahlGeben()-2) + 2);
    }
    
    public void kundenGehen() {
        for(int i = 0; i<t.length; i++) {
            t[i].gaesteGehen();
        }
    }
    
    public void bestellungErstellen(Tisch t) {
        if(t.gaesteZahlGeben() != 0 && t.zustandGeben()==1) {
            k.bestellungAufnehmen(new Bestellung(k.anzahlBestellungenGeben(), t, speisekarte));
        } else {
            System.out.println("Es sitzen keine Gaeste an Tisch " + t.tischNummerGeben());
        }
    }
    
    public void bearbeiteBestellung(Tisch t) {
        k.bestellungBearbeitenManuell(t);
    }
    
    public String[] inhaltUnbearbeiteteBestellungenGeben(int i) {
        Bestellung[] b = k.ausstehendeBestellungenGeben();
        for(int j = 0; j < b.length; j++) {
            if (b[j].auftraggeberGeben().tischNummerGeben() == i) {
                return b[j].alleDatenGeben();
            }
        }
        return null;
    }
    
    public int tischzahlGeben() {
        return t.length;
    }
    
    public Tisch tischGeben(int i) {
        if(i<t.length){
            return t[i];
        } else {
            return null;
        }
    }
    
    public String[] besetzteStuehleGeben(){
       String[] s= new String[t.length];
       for(int i=0; i<t.length; i++){
           s[i]= t[i].datenGeben();
       }
       
       return s;
    }

    public String[] bestellungenInBearbeitungGeben(){
       String[] s= new String[t.length];
       Bestellung[] b = k.ausstehendeBestellungenGeben();
       for(int i=0; i<s.length;i++){
           if(b[i]!=null){
               s[i]=("Bestellung "+b[i].bestellIDGeben()+ " von Tisch "+ b[i].auftraggeberGeben().tischNummerGeben());
           }
       }
       return s;
    }
    
    public double sequenzEinnahmenGeben() {
        return   Math.round(einnahmen[einnahmen.length-1] * 100) / 100.0;
    }
    
    public int sequenzAnzahlGeben() {
        return einnahmen.length;
    }
    
    public double gesamtEinnahmenGeben() {
        double e = 0;
        for(int i = 0; i<einnahmen.length; i++) {
            e = e + einnahmen[i];
        }
        return Math.round(e * 100) / 100.0;
    }
    
    public void einnahmenAktuallisieren() {
        einnahmen[einnahmen.length-1] = k.gewinnGeben();
    }
    
    public double[] einnahmenListeGeben() {
        return einnahmen;
    }
    
    public void alleProzesseAbschließen() {
        for(int i = 0; i<t.length; i++) {
            switch(t[i].zustandGeben()) {
                case 0:
                    break;
                case 1:
                    this.bestellungErstellen(t[i]);
                case 2:
                    this.bearbeiteBestellung(t[i]);
                case 3:
                    t[i].gaesteGehen();
            }
        }
        einnahmen[einnahmen.length-1] = k.gewinnGeben();
    }
    
}
