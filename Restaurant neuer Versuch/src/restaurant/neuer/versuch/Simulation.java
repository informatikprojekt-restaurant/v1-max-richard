/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;

import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Thomas Weber
 */
public class Simulation {
    
    private Random number;
    private Restaurant rs;
    private Oberflaeche o;
    private CitchenClock cc;
    
    public Simulation(int tz, double[] einnahmen) {
        rs = new Restaurant(tz, einnahmen);
        if(Integer.parseInt(JOptionPane.showInputDialog("Gib 1 ein, wenn du die Simulation manuell steuern willst: "))==1) {
            o = new Oberflaeche(rs, true);
        } else {
            o = new Oberflaeche(rs, false);
        }
        number = new Random();
    }
    
    public boolean start() {
        int runden = 4 * Integer.parseInt(JOptionPane.showInputDialog("Wieviele Stunden soll das Restaurant geöffnet haben (dies entscheidet über die Anzahl der zufälligen Ereignisse eines Simulationsdurchlaufs): "));
        for(int i = 0; i < runden; i++) {
            switch(number.nextInt(3)) {
                case 0:
                    for(int j = 0; j<number.nextInt(rs.tischzahlGeben()); j++) {
                        rs.kundenKommen(number.nextInt(8) + 2);
                    }
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    break;
                case 1:
                    if(rs.kundenZahlGeben() > 0) {
                        rs.bestellungenErstellen();
                    } else {
                        rs.kundenKommen(number.nextInt(8) + 2);
                    }
                    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                    break;
                case 2:
                    if(rs.kundenZahlGeben() > 0) {
                        rs.kundenGehen();
                    } else {
                        rs.kundenKommen(number.nextInt(8) + 2);
                    }
                    System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
                    break;
                case 3:
                    System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                    break;
            }
            rs.bearbeiteBestellung();
            CitchenClock cc = new CitchenClock();
            cc.run(50);
            o.aktuallisieren();
        }
        boolean restart = Integer.parseInt(JOptionPane.showInputDialog("Gib 0 ein, wenn du die Simulation noch einen Tag laufen lassen willst!"))==0;
        return restart;
    }
    
    public Restaurant restaurantGeben() {
        return rs;
    }
}
