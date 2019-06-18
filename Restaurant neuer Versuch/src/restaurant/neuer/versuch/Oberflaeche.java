/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.neuer.versuch;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.*;

/**
 *
 * @author Max Demel, Thomas Weber
 */
public class Oberflaeche {
    
    private Restaurant r;
    private JFrame f1;
    private JList<String[]> jl1;
    private JList<String[]> jl2;
    private JList<String[]> jl3;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b10;
    private JButton b11;
    private JPanel p1;
    private boolean manSt;
    private int turns;
    
    public Oberflaeche(Restaurant rs, boolean manuelleSteuerung) {
        
        manSt = manuelleSteuerung;
        
        //neues Restaurant
        r = rs;
        
        //neues Fenster
        f1 = new JFrame("Restaurant Simulation");
        f1.setVisible(true);
        f1.setBounds(500,500,1520,1560);
            
        //neue Textfelder
        jl1= new JList(r.besetzteStuehleGeben());
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        l1= new JLabel();
        l2= new JLabel();
        l3 = new JLabel();
        
        //Texte setzen
        l1.setText("Bruttoeinnahmen des " + r.tagesAnzahlGeben() + ". Tages: " + r.tagesEinnahmenGeben() + "€");
        l2.setText("Bruttoeinnahmen von " + r.tagesAnzahlGeben() + " Tag(en): " + r.gesamtEinnahmenGeben() + "€");
        
        //neue Knöpfe
        b1= new JButton("Inhalt Bestellungen Anzeigen");
       
        
        //neuer Layoutmanager
        p1= new JPanel();
        p1.setLayout(null);

        //verknüpfen der Elemente
        f1.add(p1);
        p1.add(jl1);
        p1.add(jl2);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(b1);
        
        //Knöpfe für manuelle Steuerung
        switch(10 - r.tischzahlGeben()) {
            case 0:
                b2 = new JButton("Tisch 10");
                p1.add(b2);
                b2.setBounds(1200, 330, 290, 320);
                b2.setBackground(Color.GRAY);
                if(manSt) {
                    b2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(9).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(9));
                                    b2.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 10 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(9);
                                    b2.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 10 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(9));
                                    b2.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 10 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(9).gaesteGehen();
                                    b2.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 10 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 1:
                b3 = new JButton("Tisch 9");
                p1.add(b3);
                b3.setBounds(1200, 0, 290, 320);
                b3.setBackground(Color.GRAY);
                if(manSt) {
                    b3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(8).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(8));
                                    b3.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 9 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(8);
                                    b3.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 9 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(8));
                                    b3.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 9 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(8).gaesteGehen();
                                    b3.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 9 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 2:
                b4 = new JButton("Tisch 8");
                p1.add(b4);
                b4.setBounds(900, 330, 290, 320);
                b4.setBackground(Color.GRAY);
                if(manSt) {
                    b4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(7).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(7));
                                    b4.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 8 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(7);
                                    b4.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 8 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(7));
                                    b4.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 8 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(7).gaesteGehen();
                                    b4.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 8 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 3:
                b5 = new JButton("Tisch 7");
                p1.add(b5);
                b5.setBounds(900, 0, 290, 320);
                b5.setBackground(Color.GRAY);
                if(manSt) {
                    b5.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(6).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(6));
                                    b5.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 7 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(6);
                                    b5.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 7 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(6));
                                    b5.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 7 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(6).gaesteGehen();
                                    b5.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 7 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 4:
                b6 = new JButton("Tisch 6");
                p1.add(b6);
                b6.setBounds(600, 330, 290, 320);
                b6.setBackground(Color.GRAY);
                if(manSt) {
                    b6.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(5).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(5));
                                    b6.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 6 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(5);
                                    b6.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 6 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(5));
                                    b6.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 6 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(5).gaesteGehen();
                                    b6.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 6 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 5:
                b7 = new JButton("Tisch 5");
                p1.add(b7);
                b7.setBounds(600, 0, 290, 320);
                b7.setBackground(Color.GRAY);
                if(manSt) {
                    b7.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(4).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(4));
                                    b7.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 5 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(4);
                                    b7.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 5 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(4));
                                    b7.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 5 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(4).gaesteGehen();
                                    b7.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 5 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 6:
                b8 = new JButton("Tisch 4");
                p1.add(b8);
                b8.setBounds(300, 330, 290, 320);
                b8.setBackground(Color.GRAY);
                if(manSt) {
                    b8.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(3).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(3));
                                    b8.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 4 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(3);
                                    b8.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 4 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(3));
                                    b8.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 4 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(3).gaesteGehen();
                                    b8.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 4 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 7:
                b9 = new JButton("Tisch 3");
                p1.add(b9);
                b9.setBounds(300, 0, 290, 320);
                b9.setBackground(Color.GRAY);
                if(manSt) {
                    b9.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(2).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(2));
                                    b9.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 3 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(2);
                                    b9.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 3 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(2));
                                    b9.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 3 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(2).gaesteGehen();
                                    b9.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 3 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 8:
                b10 = new JButton("Tisch 2");
                p1.add(b10);
                b10.setBounds(0, 330, 290, 320);
                b10.setBackground(Color.GRAY);
                if(manSt) {
                    b10.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(1).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(1));
                                    b10.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 2 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(1);
                                    b10.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 2 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(1));
                                    b10.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 2 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(1).gaesteGehen();
                                    b10.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 2 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
            case 9:
                b11 = new JButton("Tisch 1");
                p1.add(b11);
                b11.setBounds(0, 0, 290, 320);
                b11.setBackground(Color.GRAY);
                if(manSt) {
                    b11.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            switch(r.tischGeben(0).bestelltGeben()){
                                case 0:
                                    r.kundenKommenManuell(r.tischGeben(0));
                                    b11.setBackground(Color.RED);
                                    l3.setText("Kunden haben sich an Tisch 1 gesetzt!");
                                    break;
                                case 1:
                                    r.bestellungErstellen(0);
                                    b11.setBackground(Color.ORANGE);
                                    l3.setText("Tisch 1 hat eine Bestellung aufgegeben!");
                                    break;
                                case 2:
                                    r.bearbeiteBestellungManuell(r.tischGeben(0));
                                    b11.setBackground(Color.GREEN);
                                    l3.setText("Die Bestellung von Tisch 1 wurde bearbeitet!");
                                    break;
                                case 3:
                                    r.tischGeben(0).gaesteGehen();
                                    b11.setBackground(Color.GRAY);
                                    l3.setText("Die Kunden von Tisch 1 sind gegangen!");
                                    break;
                            }
                            turns++;
                        }
                    });
                }
        }
        
         
        //farbe setzen
        b1.setBackground(Color.GRAY);
        
        //Positionen festlegen
        b1.setBounds(0,750,375,375);
        jl1.setBounds(375,750,375,750);
        jl2.setBounds(750,750,375,375);
        l1.setBounds(1125,750,375,375);
        l2.setBounds(1125, 1125, 375,375);
        l3.setBounds(750, 1125, 375, 375);
        
        //Rahmenlinien festlegen
        jl1.setBorder(new LineBorder(Color.BLACK));
        jl2.setBorder(new LineBorder(Color.BLACK));
        l1.setBorder(new LineBorder(Color.BLACK));
        l2.setBorder(new LineBorder(Color.BLACK));
        l3.setBorder(new LineBorder(Color.BLACK));
        
        //Knopffunktionen setzen
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die nummer des Tisches, welcher die Bestellung aufgegeben hat an: "));
                if(i <= r.tischzahlGeben() && r.tischGeben(i-1).bestelltGeben() == 2){
                    jl3 = new JList(r.unbearbeiteteBestellungsinhalteGeben(i));
                    p1.add(jl3);
                    jl3.setBounds(0,1125,375,375);
                    jl3.setBorder(new LineBorder(Color.BLACK));
                } else {
                    JOptionPane.showMessageDialog(null, "Die Tischnummer oder die Bestellung existieren nicht!");
                }
                
            }
        });
        
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
    
    public void aktuallisieren() {
        jl1.setVisible(false);
        jl1= new JList(r.besetzteStuehleGeben());
        jl1.setBounds(375,750,375,750);
        jl1.setBorder(new LineBorder(Color.BLACK));
        jl2.setVisible(false);
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        jl2.setBounds(750,750,375,750);
        jl2.setBorder(new LineBorder(Color.BLACK));
        l1.setText("Bruttoeinnahmen des " + r.tagesAnzahlGeben() + ". Tages: " + r.tagesEinnahmenGeben() + "€");
        l2.setText("Bruttoeinnahmen von " + r.tagesAnzahlGeben() + " Tag(en): " + r.gesamtEinnahmenGeben() + "€");
        
        switch(10 - r.tischzahlGeben()) {
            case 0:
                switch(r.tischGeben(9).bestelltGeben()){
                    case 0:
                        b2.setBackground(Color.GRAY);
                        break;
                    case 1:
                        b2.setBackground(Color.RED);
                        break;
                    case 2:
                        b2.setBackground(Color.ORANGE);
                        break;
                    case 3:
                        b2.setBackground(Color.GREEN);
                        break;    
                }
            case 1:
                switch(r.tischGeben(8).bestelltGeben()) {
                    case 0:
                        b3.setBackground(Color.GRAY);
                        break;
                    case 1:
                        b3.setBackground(Color.RED);
                        break;
                    case 2:
                        b3.setBackground(Color.ORANGE);
                        break;
                    case 3:
                        b3.setBackground(Color.GREEN);
                        break;
                }
            case 2:
                switch(r.tischGeben(7).bestelltGeben()) {
                    case 0:
                        b4.setBackground(Color.GRAY);
                        break;
                    case 1:
                        b4.setBackground(Color.RED);
                        break;
                    case 2:
                        b4.setBackground(Color.ORANGE);
                        break;
                    case 3:  
                        b4.setBackground(Color.GREEN);
                        break; 
                }         
            case 3:        
                switch(r.tischGeben(6).bestelltGeben()) {           
                    case 0:               
                        b5.setBackground(Color.GRAY);                  
                        break;                        
                    case 1:                   
                        b5.setBackground(Color.RED);                        
                        break;                        
                    case 2:                   
                        b5.setBackground(Color.ORANGE);                        
                        break;                        
                    case 3:                     
                        b5.setBackground(Color.GREEN);                 
                        break;                
                }           
            case 4:      
                switch(r.tischGeben(5).bestelltGeben()) {            
                    case 0:               
                        b6.setBackground(Color.GRAY);                   
                        break;                    
                    case 1:              
                        b6.setBackground(Color.RED);           
                        break;               
                    case 2:           
                        b6.setBackground(Color.ORANGE);                  
                        break;                    
                    case 3:                
                        b6.setBackground(Color.GREEN);              
                        break;          
                }          
            case 5:    
                switch(r.tischGeben(4).bestelltGeben()) {         
                    case 0:          
                        b7.setBackground(Color.GRAY);                  
                        break;              
                    case 1:            
                        b7.setBackground(Color.RED);               
                        break;                
                    case 2:           
                        b7.setBackground(Color.ORANGE);               
                        break;                
                    case 3:               
                        b7.setBackground(Color.GREEN);                 
                        break;               
                }                       
            case 6:        
                switch(r.tischGeben(3).bestelltGeben()) {             
                    case 0:                  
                        b8.setBackground(Color.GRAY);                       
                        break;                       
                    case 1:                   
                        b8.setBackground(Color.RED);                        
                        break;                        
                    case 2:                    
                        b8.setBackground(Color.ORANGE);                    
                        break;                        
                    case 3:                     
                        b8.setBackground(Color.GREEN);                       
                        break;                
                }                                
            case 7:            
                switch(r.tischGeben(2).bestelltGeben()) {                
                    case 0:                    
                        b9.setBackground(Color.GRAY);                        
                        break;                        
                    case 1:                    
                        b9.setBackground(Color.RED);                        
                        break;                        
                    case 2:                    
                        b9.setBackground(Color.ORANGE);                        
                        break;                        
                    case 3:                    
                        b9.setBackground(Color.GREEN);                      
                        break;              
                }             
            case 8:           
                switch(r.tischGeben(1).bestelltGeben()) {               
                    case 0:                   
                        b10.setBackground(Color.GRAY);                       
                        break;                       
                    case 1:                   
                        b10.setBackground(Color.RED);                        
                        break;                        
                    case 2:                    
                        b10.setBackground(Color.ORANGE);                 
                        break;           
                    case 3:                
                        b10.setBackground(Color.GREEN);                  
                        break;               
                }                           
            case 9:          
                switch(r.tischGeben(0).bestelltGeben()) {              
                    case 0:                    
                        b11.setBackground(Color.GRAY);                        
                        break;
                    case 1:
                        b11.setBackground(Color.RED);                        
                        break;                        
                    case 2:                                                
                        b11.setBackground(Color.ORANGE);
                        break;
                    case 3:  
                        b11.setBackground(Color.GREEN);
                        break;
                }
        }
        
        p1.add(jl1);
        p1.add(jl2);
        p1.add(l1);
        p1.add(l2);
        
        p1.repaint();
    }
    
    public int turnsGeben() {
        return turns;
    }
    
}
