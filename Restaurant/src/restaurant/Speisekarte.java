package restaurant;

/**
 *
 * @author Max Demel
 */
public class Speisekarte {
     public Angebot[] speisekarte;
     
    public void Speisekarte(){
        speisekarte= new Angebot[15];
        
        
        speisekarte[0] =new Gerichte("Knödel",1 ,10.50); 
        speisekarte[1] =new Gerichte("Schweinsbron",2 ,13.50); 
        speisekarte[2] =new Gerichte("Kaiserschmarn",3 ,9.99); 
        speisekarte[3] =new Gerichte("Russischer Zopfkuchen",4 ,10.50); 
        speisekarte[4] =new Gerichte("Brownies",5 ,4.20); 
        speisekarte[5] =new Gerichte("Rumkuchen",6 ,6.66); 
        speisekarte[6] =new Gerichte("Pizza",7 ,12.00); 
        speisekarte[7] =new Gerichte("Döner",8 ,10.50); 
        speisekarte[8] =new Gerichte("Menschenfleisch",9 ,10.50); 
        speisekarte[9] =new Gerichte("Goaßkrapfen",10,4.50); 
        speisekarte[10]=new Gerichte("0.5 Kg Tofuklotz ungekocht",11,0.50); 
        speisekarte[11]=new Getränke ("Goaßmass",12, 4.50);
        speisekarte[12]=new Getränke ("S3x on the beach",13,6.69);
        speisekarte[13]=new Getränke ("Mojito", 14, 9.00);
        speisekarte[14]=new Getränke ("Wasser", 15, 14.00);
    }
    
    
}
