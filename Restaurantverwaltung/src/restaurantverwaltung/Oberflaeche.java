package restaurantverwaltung;

//Importe
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
    
    //MyButtons bekommen die Tischnummern zugewiesen, da sie die Zustände der Tische so verwalten können
    public class MyButton extends JButton{
        int tischNr;
        public MyButton(int nr, String name){
            super(name);
            tischNr = nr;
        }
        
        //Gibt die Tischnummer, die dem MyButton zugewiesen wurde zurück
        public int getTischNr(){
            return tischNr;
        }
    }
    
    //Attribute
    private Restaurant r;
    private JFrame f1;
    private JList<String[]> jl1;
    private JList<String[]> jl2;
    private JList<String[]> jl3;
    private JList<String[]> jl4;
    private JLabel[] l;
    private JButton b1;
    private JButton b2;
    private MyButton[] b;
    private JPanel p1;
    
    //Konstruktor
    public Oberflaeche(Restaurant rs) {
        
        //Restaurant speichern
        r = rs;
        
        //neues Fenster
        f1 = new JFrame("Restaurantmanagement");
        f1.setVisible(true);
        f1.setBounds(500,500,1280,960);
        f1.setLocationRelativeTo(null);
            
        //neue Textfelder
        
        //JLabels (=einzeilige Textfelder)
        l = new JLabel[7];
        
        //JLists (=mehrzeilige Textfelder) werden mit Text erstellt
        jl1 = new JList(r.besetzteStuehleGeben());
        jl2 = new JList(r.bestellungenInBearbeitungGeben());
        jl3 = new JList(new String[0]);
        jl4 = new JList(r.abgeschlosseneBestellungenGeben());
        for(int i = 0; i < l.length; i++) {
            l[i]= new JLabel();
        }
        
        //Texte der JLabels setzen
        //Gibt die Einnahmen der Sequenz aus
        l[0].setText("Einnahmen des " + r.sequenzAnzahlGeben() + ". Sequenz: " + r.sequenzEinnahmenGeben() + "€");
        //Gibt die Einnahmen aller Sequenzen aus
        l[1].setText("Einnahmen von " + r.sequenzAnzahlGeben() + " Sequenz(en): " + r.gesamtEinnahmenGeben() + "€");
        //Gibt das Protokoll, also die Zustandsänderungen der tische aus
        l[2].setText("Protokoll");
        //Legende, welche den Farben der "MyButton"s die jeweiligen Zustände für die Tische zuordnet
        l[3].setText("Grau:   Tisch ist nicht besetzt und hat keine Bestellung aufgegeben");
        l[4].setText("Rot:    Tisch ist besetzt hat aber noch keine Bestellung aufgegeben");
        l[5].setText("Orange: Tisch ist besetzt und hat eine Bestellung aufgegeben");
        l[6].setText("Grün:   Tisch ist besetzt und die Bestellung wurde bearbeitet");
        
        //neue Knöpfe
        b1= new JButton("Bestellungsinhalt Anzeigen");
        b2 = new JButton("Sequenz abschließen");
        b = new MyButton[r.tischzahlGeben()];
        
        //neuer Layoutmanager
        p1= new JPanel();
        p1.setLayout(null);

        //verknüpfen der Elemente
        f1.add(p1);
        p1.add(jl1);
        p1.add(jl2);
        p1.add(jl3);
        p1.add(jl4);
        for(int i = 0; i < l.length; i++) {
            p1.add(l[i]);
        }
        p1.add(b1);
        p1.add(b2);    
         
        //Farben setzen
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
        jl3.setBounds(0,650,250,250);
        jl4.setBounds(1000, 0, 250, 900);
        l[0].setBounds(500, 650, 500, 75);
        l[1].setBounds(500, 725, 500, 75);
        l[2].setBounds(750, 400, 250, 250);
        l[3].setBounds(500, 800, 500, 25);
        l[4].setBounds(500, 825, 500, 25);
        l[5].setBounds(500, 850, 500, 25);
        l[6].setBounds(500, 875, 500, 25);
        
        //Rahmenlinien festlegen
        jl1.setBorder(new LineBorder(Color.BLACK));
        jl2.setBorder(new LineBorder(Color.BLACK));
        jl3.setBorder(new LineBorder(Color.BLACK));
        jl4.setBorder(new LineBorder(Color.BLACK));
        l[0].setBorder(new LineBorder(Color.BLACK));
        l[1].setBorder(new LineBorder(Color.BLACK));
        l[2].setBorder(new LineBorder(Color.BLACK));
        
        //Knopffunktionen setzen
        
        //Knopf, welcher den Inhalt einer, über ihre ID aufgerufene Bestellung ausgibt
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i;
                try {
                    i = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die nummer der Bestellung, deren Inhalt sie sehen wollen an: "));    
                    if (i <= r.bestellungsZahlGeben()) {
                        jl3.setVisible(false);
                        jl3 = new JList(r.bestellungGeben(i));
                        p1.add(jl3);
                        jl3.setBounds(0,650,250,250);
                        jl3.setBorder(new LineBorder(Color.BLACK));
                        p1.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Es ist ein Fehler aufgetreten.");
                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Es ist ein Fehler aufgetreten.");
                }
            }
        });
        
        //Knopf, welcher die Sequenz oder sogar das ganze Programm beendet
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i;
                boolean b = true;
                while (b) {
                    try {
                        i = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie 0 ein, wenn Sie doch nicht beenden wollen, 1, wenn Sie die Sequenz abschließen wollen und eine neue Sequenz mit dem selben Restaurant starten wollen und 2, wenn Sie das Programm beenden wollen: "));
                        if (i<3 && i>-1) {
                            switch(i) {
                                case 0:
                                    break;
                                case 1:
                                    r.alleProzesseAbschließen();
                                    JOptionPane.showMessageDialog(null, "Die Einnahmen der letzten (" + r.sequenzAnzahlGeben() + ".) Sequenz liegen bei " + r.sequenzEinnahmenGeben() + "€! Die Gesamteinnahmen liegen bei " + r.gesamtEinnahmenGeben() + "€!");
                                    r.neueSequenz();
                                    break;
                                case 2:
                                    r.alleProzesseAbschließen();
                                    JOptionPane.showMessageDialog(null, "Die Einnahmen der letzten (" + r.sequenzAnzahlGeben() + ".) Sequenz liegen bei " + r.sequenzEinnahmenGeben() + "€! Die Gesamteinnahmen liegen bei " + r.gesamtEinnahmenGeben() + "€!");
                                    System.exit(0);
                                    break;
                            }
                            break;
                        }
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Es ist ein Fehler aufgetreten.");
                    }
                }
            }
        });
        
        //Den Knöpfen für die Zustandsänderung der Tische ihre Positionen und Funktionen zuweisen
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
                            l[2].setText("Bestellung von Tisch " + (button.getTischNr() + 1) + " wurde bearbeitet!");
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
        
        //Festlegen, dass wenn das Fenster geschlossen wird, das Programm ebenfalls beendet wird
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
    
    //Methoden
    
    //Aktuallisiert alle Inhalte der Oberfläche
    public void aktuallisieren() {
        
        //Aktuallisieren der Anzeige für Besetzten Stühle pro Tisch
        jl1.setVisible(false);
        jl1= new JList(r.besetzteStuehleGeben());
        jl1.setBounds(250, 650, 250, 250);
        jl1.setBorder(new LineBorder(Color.BLACK));
        
        //Aktuallisieren der Anzeige für die Bestellungen in Bearbeitung
        jl2.setVisible(false);
        jl2= new JList(r.bestellungenInBearbeitungGeben());
        jl2.setBounds(500, 400, 250, 250);
        jl2.setBorder(new LineBorder(Color.BLACK));
        
        //Aktuallisierung der Anzeige für die Bestellungen welche bereits Bearbeitet wurden
        jl4.setVisible(false);
        jl4 = new JList(r.abgeschlosseneBestellungenGeben());
        jl4.setBounds(1000, 0, 250, 900);
        jl4.setBorder(new LineBorder(Color.GRAY));
        
        //Aktuallisieren der Textfelder, welche die Einnahmen ausgeben
        l[0].setText("Einnahmen: " + r.sequenzAnzahlGeben() + ". Sequenz: " + r.sequenzEinnahmenGeben() + "€");
        l[1].setText("Einnahmen: " + r.sequenzAnzahlGeben() + " Sequenz(en): " + r.gesamtEinnahmenGeben() + "€");
        
        //Einbauen aller aktuallisierten Elemente
        p1.add(jl1);
        p1.add(jl2);
        p1.add(jl4);
        p1.add(l[0]);
        p1.add(l[1]);
        p1.repaint();
    }
    
}