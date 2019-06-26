package restaurantverwaltung;

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
 * nur noch überarbeiten
 * evtl zusätzliche funktionen
 * freie wahl der kundenzahl
 * freie wahl der Bestellungsinhalte
 */
public class Oberflaeche {
    
    public class MyButton extends JButton{
            int tischNr;
            public MyButton(int nr, String name){
                super(name);
                tischNr = nr;
            }
        
            public int getTischNr(){
                return tischNr;
            }
    }
    
    private Restaurant r;
    private JFrame f1;
    private JList<String[]> jl1;
    private JList<String[]> jl2;
    private JList<String[]> jl3;
    private JLabel[] l;
    private JButton b1;
    private JButton b2;
    private MyButton[] b;
    private JPanel p1;
    
    public Oberflaeche(Restaurant rs) {
        
        //Restaurant speichern
        r = rs;
        
        //neues Fenster
        f1 = new JFrame("Restaurant Simulation");
        f1.setVisible(true);
        f1.setBounds(500,500,1050,1050);
        f1.setLocationRelativeTo(null);
            
        //neue Textfelder
        l = new JLabel[7];
        
        jl1= new JList(r.besetzteStuehleGeben());
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        for(int i = 0; i < l.length; i++) {
            l[i]= new JLabel();
        }
        //Texte setzen
        l[0].setText("Einnahmen des " + r.sequenzAnzahlGeben() + ". Tages: " + r.sequenzEinnahmenGeben() + "€");
        l[1].setText("Einnahmen von " + r.sequenzAnzahlGeben() + " Tag(en): " + r.gesamtEinnahmenGeben() + "€");
        l[3].setText("Grau:   Tisch ist nicht besetzt und hat keine Bestellung aufgegeben");
        l[4].setText("Rot:    Tisch ist besetzt hat aber noch keine Bestellung aufgegeben");
        l[5].setText("Orange: Tisch ist besetzt und hat eine Bestellung aufgegeben");
        l[6].setText("Grün:   Tisch ist besetzt und die Bestellung wurde bearbeitet");
        
        //neue Knöpfe
        b1= new JButton("Inhalt Bestellungen Anzeigen");
        b2 = new JButton("Sequenz abschließen");
        b = new MyButton[r.tischzahlGeben()];
        
        //neuer Layoutmanager
        p1= new JPanel();
        p1.setLayout(null);

        //verknüpfen der Elemente
        f1.add(p1);
        p1.add(jl1);
        p1.add(jl2);
        for(int i = 0; i < l.length; i++) {
            p1.add(l[i]);
        }
        p1.add(b1);
        p1.add(b2);
        
        //Knöpfe für manuelle Steuerung
        for(int i = 0; i<r.tischzahlGeben(); i++) {
            b[i] = new MyButton(i, "Tisch " + r.tischGeben(i).tischNummerGeben());
            p1.add(b[i]);
            if (i%2==0) {
                b[i].setBounds((i/2*200), 0, 185, 185);
            } else {
                b[i].setBounds(((i-1)/2*200), 200, 185, 185);
            }
            b[i].setBackground(Color.GRAY);
            MyButton button = b[i];
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switch(r.tischGeben(button.getTischNr()).zustandGeben()){
                        case 0:
                            r.kundenKommen(button.getTischNr());
                            button.setBackground(Color.RED);
                            l[2].setText(r.tischGeben(button.getTischNr()).gaesteZahlGeben() + " Kunden haben sich an Tisch " + (button.getTischNr() + 1) + " gesetzt!");
                            break;
                        case 1:
                            r.bestellungErstellen(button.getTischNr());
                            button.setBackground(Color.ORANGE);
                            l[2].setText("Tisch " + (button.getTischNr() + 1) + " hat eine Bestellung eingereicht!");
                            break;
                        case 2:
                            r.bearbeiteBestellung(button.getTischNr());
                            button.setBackground(Color.GREEN);
                            l[2].setText("Die Bestellung von Tisch " + (button.getTischNr() + 1) + " wurde bearbeitet!");
                            break;
                        case 3:
                            r.kundenGehen(button.getTischNr());
                            button.setBackground(Color.GRAY);
                            l[2].setText("Die Kunden von Tisch " + (button.getTischNr() + 1) + " sind gegangen!");
                            break;
                    }
                }
            });
            b[i] = button;
        }      
         
        //farbe setzen
        b1.setBackground(Color.GRAY);
        b2.setBackground(Color.GRAY);
        l[3].setForeground(Color.GRAY);
        l[4].setForeground(Color.RED);
        l[5].setForeground(Color.ORANGE);
        l[6].setForeground(Color.GREEN);
        
        //Positionen festlegen
        b1.setBounds(0, 400, 250, 250);
        b2.setBounds(250, 400, 250, 250);
        jl1.setBounds(250, 650, 250, 250);
        jl2.setBounds(500, 400, 250, 250);
        l[0].setBounds(750, 400, 250, 250);
        l[1].setBounds(750, 650, 250, 250);
        l[2].setBounds(500, 650, 250, 250);
        l[3].setBounds(0, 915, 500, 25);
        l[4].setBounds(0, 930, 500, 25);
        l[5].setBounds(0, 945, 500, 25);
        l[6].setBounds(0, 960, 500, 25);
        
        //Rahmenlinien festlegen
        jl1.setBorder(new LineBorder(Color.BLACK));
        jl2.setBorder(new LineBorder(Color.BLACK));
        l[0].setBorder(new LineBorder(Color.BLACK));
        l[1].setBorder(new LineBorder(Color.BLACK));
        l[2].setBorder(new LineBorder(Color.BLACK));
        
        //Knopffunktionen setzen
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die nummer des Tisches, welcher die Bestellung aufgegeben hat an: "));
                if(i <= r.tischzahlGeben() && r.tischGeben(i-1).zustandGeben() == 2){
                    jl3 = new JList(r.inhaltUnbearbeiteteBestellungGeben(i));
                    p1.add(jl3);
                    jl3.setBounds(0,650,250,250);
                    jl3.setBorder(new LineBorder(Color.BLACK));
                } else {
                    JOptionPane.showMessageDialog(null, "Die Tischnummer oder die Bestellung existieren nicht!");
                }
            }
        });
        
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(JOptionPane.showInputDialog("Geben Sie 1 ein, wenn Sie die Sequenz wirklich beenden wollen: ")) == 1) {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie entweder 1 ein, wenn Sie das Programm neu starten wollen aber die bisherigen Einnahmen speichern wollen oder 2, wenn Sie das Programm beenden wollen: "));
                    while (i!=1 && i != 2) {
                        i = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie entweder 1 ein, wenn Sie eine neue Sequenz mit den bisherigen Einnahmen starten wollen oder 2, wenn Sie das Programm beenden wollen: "));
                    }
                    r.alleProzesseAbschließen();
                    JOptionPane.showMessageDialog(null, "Die Einnahmen der letzten (" + r.sequenzAnzahlGeben() + ".) Sequenz liegen bei " + r.sequenzEinnahmenGeben() + "€! Die Gesamteinnahmen liegen bei " + r.gesamtEinnahmenGeben() + "€!");
                        switch(i-1) {
                            case 0:
                                r = new Restaurant(r.tischzahlGeben(), r.einnahmenListeGeben());
                                break;
                            case 1:
                                System.exit(0);
                                break;
                        }
                }
            }
        });
        
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
    
    public void aktuallisieren() {
        jl1.setVisible(false);
        jl1= new JList(r.besetzteStuehleGeben());
        jl1.setBounds(250, 650, 250, 250);
        jl1.setBorder(new LineBorder(Color.BLACK));
        jl2.setVisible(false);
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        jl2.setBounds(500, 400, 250, 250);
        jl2.setBorder(new LineBorder(Color.BLACK));
        l[0].setText("Bruttoeinnahmen: " + r.sequenzAnzahlGeben() + ". Sequenz: " + r.sequenzEinnahmenGeben() + "€");
        l[1].setText("Bruttoeinnahmen: " + r.sequenzAnzahlGeben() + " Sequenz(en): " + r.gesamtEinnahmenGeben() + "€");
        
        for(int i = 0; i<r.tischzahlGeben(); i++) {
            switch(r.tischGeben(i).zustandGeben()){
                case 0:
                    b[i].setBackground(Color.GRAY);
                    break;
                case 1:
                    b[i].setBackground(Color.RED);
                    break;
                case 2:
                    b[i].setBackground(Color.ORANGE);
                    break;
                case 3:
                    b[i].setBackground(Color.GREEN);
                    break;    
            }
        }
        
        p1.add(jl1);
        p1.add(jl2);
        p1.add(l[0]);
        p1.add(l[1]);
        
        p1.repaint();
    }
    
}