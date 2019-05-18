/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;
import java.util.Random;

/**
 *
 * @author Sina Lemke
 */
public class Tisch {
    
    private int stuhlzahl;
    private int tischnr;
    private int besetzt;
    
    Tisch(int sz,int nr)
    {
        stuhlzahl=sz;
        tischnr=nr;
        besetzt=0;
    }
    
    public void neueGäste()
    {
        Random number = new Random();
        int be = number.nextInt(stuhlzahl-1)+1;
        besetzt=be;
    }
    
    public void gehendeGäste()
    {
        besetzt=0;
    }
    
    public int stuhlzahlGeben()
    {
        return stuhlzahl;
    }
    
    public Bestellung bestellungAufgeben()
    {
        Bestellung b = new Bestellung(tischnr,stuhlzahl);
        return b;
    }
    
}