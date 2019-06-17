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
    private JButton b1;
//    private JButton b2;
//    private JButton b3;
    private JPanel p1;
    
    public Oberflaeche(Restaurant rs, boolean manuelleSteuerung) {
        
        //neues Restaurant
        r = rs;
        
        //neues Fenster
        f1 = new JFrame("Restaurant Simulation");
        f1.setVisible(true);
        if (manuelleSteuerung) {
            f1.setBounds(500,500,2000,1500);
        } else {
            f1.setBounds(500,500,1500,1500);
        }
            
        //neue Textfelder
        jl1= new JList(r.besetzteStuehleGeben());
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        l1= new JLabel();
        l2= new JLabel();
        
        //Texte setzen
        l1.setText("Bruttoeinnahmen des " + r.tagesAnzahlGeben() + ". Tages: " + r.tagesEinnahmenGeben() + "€");
        l2.setText("Bruttoeinnahmen von " + r.tagesAnzahlGeben() + " Tag(en): " + r.gesamtEinnahmenGeben() + "€");
        
        //neue Knöpfe
        b1= new JButton("Inhalt Bestellungen Anzeigen");
        
        //farbe setzen
        b1.setBackground(Color.GRAY);
        
        //neuer Layoutmanager
        p1= new JPanel();
        p1.setLayout(null);

        //verknüpfen der Elemente
        f1.add(p1);
        p1.add(jl1);
        p1.add(jl2);
        p1.add(l1);
        p1.add(l2);
        p1.add(b1);
        
        //Positionen festlegen
        b1.setBounds(0,750,375,375);
        jl1.setBounds(375,750,375,750);
        jl2.setBounds(750,750,375,750);
        l1.setBounds(1125,750,375,375);
        l2.setBounds(1125, 1125, 375,375);
        
        
        //Rahmenlinien festlegen
        jl1.setBorder(new LineBorder(Color.BLACK));
        jl2.setBorder(new LineBorder(Color.BLACK));
        l1.setBorder(new LineBorder(Color.BLACK));
        l2.setBorder(new LineBorder(Color.BLACK));
        
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
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        l1.setText("Bruttoeinnahmen des " + r.tagesAnzahlGeben() + ". Tages: " + r.tagesEinnahmenGeben() + "€");
        l2.setText("Bruttoeinnahmen von " + r.tagesAnzahlGeben() + " Tag(en): " + r.gesamtEinnahmenGeben() + "€");
        
        p1.add(jl1);
        p1.add(l1);
        p1.add(l2);
        
        p1.repaint();
    }
    
}
