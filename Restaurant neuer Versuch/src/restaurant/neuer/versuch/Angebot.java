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
public class Angebot {
    
    String name;
    int ID;
    double preis;
    boolean istGetraenk;
    int zubereitungsZeit;
    
    public Angebot(String n, int nbr, double p, boolean b, int z){
        name = n;
        ID = nbr;
        preis = p;
        istGetraenk = b;
        zubereitungsZeit = z;
    }
    
    public void datenAusgeben(){
        System.out.println(ID + " " + name + " " + preis);
    }
    
    public int IDGeben(){
        return ID;
    }
    
    public double preisGeben() {
        return preis;
    }
    
    public int zubereitungsZeitGeben() {
        return zubereitungsZeit;
    }
    
    public String datenGeben() {
        return (ID + " " + name + " " + preis);
    }
    
}
