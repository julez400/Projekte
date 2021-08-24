import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Main extends JFrame {

    int kontostand = 20000;
    int einsatz = 200;
    int gewinn;
    Icon Spin = new ImageIcon(this.getClass().getResource("/SlotIcons/SpinButton.png"));
    Icon Plus = new ImageIcon(this.getClass().getResource("/SlotIcons/Plus.png"));
    Icon Minus = new ImageIcon(this.getClass().getResource("/SlotIcons/Minus.png"));
    Icon Bet = new ImageIcon(this.getClass().getResource("/SlotIcons/Bet.png"));
    Icon GA = new ImageIcon(this.getClass().getResource("/SlotIcons/GuthabenAufladen.png"));

    Zahlengenerator zahlengenerator = new Zahlengenerator();
    Slot slot = new Slot();

    JPanel walzenPanel = new JPanel(new GridLayout(1, 3));
    JPanel gewinnDisplayPanel = new JPanel(new GridLayout(1, 6));
    JPanel betragsPanel = new JPanel(new GridLayout(1, 4));

    JLabel slotWalze1 = new JLabel();
    JLabel slotWalze2 = new JLabel();
    JLabel slotWalze3 = new JLabel();

    JLabel kontoDisplay = new JLabel("Guthaben: " + kontostand + "CHF");
    JLabel einsatzDisplay = new JLabel("Einsatz: " + einsatz + "CHF");
    JLabel gewinnDisplay = new JLabel("Gewinn: " + gewinn + "CHF");

    JButton plus = new JButton(Plus);
    JButton minus = new JButton(Minus);
    JButton spin = new JButton(Spin);
    JButton changeBet = new JButton(Bet);
    JButton guthabenAufladen = new JButton(GA);

    JCheckBox w = new JCheckBox("L");
    JCheckBox l = new JCheckBox("W");


    /**
     * Dieser Konstruktor initialisiert die Buttons.
     */
    public Main() {
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEinsatz();
            }
        });

        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lowerEinsatz();
            }
        });

        spin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    spin();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        while(true) {
            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie das Guthaben ein",
                    "Eingabeaufforderung",
                    JOptionPane.PLAIN_MESSAGE);
            try {
                kontostand = Integer.parseInt(eingabe);
                if(kontostand > 0) {
                    kontoDisplay.setText("Guthaben: " + kontostand + "CHF");
                    break;
                }
            }catch(Exception exception) {

            }
        }

        guthabenAufladen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eingabe5;
                int eingabe4;

                while(true) {
                    eingabe5 = JOptionPane.showInputDialog(null, "Wie viel möchten sie aufladen?",
                            "Eingabeaufforderung",
                            JOptionPane.PLAIN_MESSAGE);
                    try {
                        eingabe4 = Integer.parseInt(eingabe5);
                        if(eingabe4 >= 0) {
                            kontostand = kontostand + eingabe4;
                            kontoDisplay.setText("Guthaben: " + kontostand + "CHF");
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Bitte gültigen Einsatz setzen!");
                        }
                    }catch(Exception exception) {

                    }
                }
            }
        });

        changeBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int eingabe2 = 0;

                while(true) {
                    String eingabe = JOptionPane.showInputDialog(null, "Geben Sie den Einsatz ein",
                            "Eingabeaufforderung",
                            JOptionPane.PLAIN_MESSAGE);
                    try {
                        eingabe2 = Integer.parseInt(eingabe);
                        break;
                    }catch(Exception exception) {

                    }
                }

                if( eingabe2 <= kontostand && eingabe2 > 0){
                    einsatz = eingabe2;
                    einsatzDisplay.setText("Einsatz: "+einsatz+"CHF");
                }
                else{
                    System.out.println("Else");
                    JOptionPane.showMessageDialog(null,"Bitte Treffen sie eine gültige Eingabe!");

                }

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        spin.setBorder(null);
        spin.setContentAreaFilled(false);

        plus.setBorder(null);
        plus.setContentAreaFilled(false);

        minus.setBorder(null);
        minus.setContentAreaFilled(false);

        changeBet.setBorder(null);
        changeBet.setContentAreaFilled(false);

        guthabenAufladen.setBorder(null);
        guthabenAufladen.setContentAreaFilled(false);

        betragsPanel.add(plus);
        betragsPanel.add(einsatzDisplay);
        betragsPanel.add(changeBet);
        betragsPanel.add(minus);

        walzenPanel.add(slotWalze1);
        walzenPanel.add(slotWalze2);
        walzenPanel.add(slotWalze3);


        gewinnDisplayPanel.add(gewinnDisplay);
        gewinnDisplayPanel.add(spin);
        gewinnDisplayPanel.add(kontoDisplay);
        gewinnDisplayPanel.add(guthabenAufladen);
        gewinnDisplayPanel.add(w);
        gewinnDisplayPanel.add(l);



        this.getContentPane().setLayout(new GridLayout(3, 1));
        this.getContentPane().add(gewinnDisplayPanel);
        this.getContentPane().add(walzenPanel);
        this.getContentPane().add(betragsPanel);
        this.pack();
        this.setVisible(true);



    }

    /**
     * Diese Methode erhöht den Aktuellen Einsatz.
     */
    public void addEinsatz() {
        if (einsatz < kontostand) {
            einsatz = einsatz + 1;
            einsatzDisplay.setText("Einsatz: " + einsatz + "CHF");
        } else {
            JOptionPane.showMessageDialog(null, "Nicht Genügend Guthaben");
        }
    }

    /**
     * Diese Methode verkleinert den Aktuellen Einsatz.
     */
    public void lowerEinsatz() {
        if (einsatz > 1) {
            einsatz--;
            einsatzDisplay.setText("Einsatz: " + einsatz + "CHF");
        } else {
            JOptionPane.showMessageDialog(null, "Mindesteinsatz 1CHF");
        }
    }

    /**
     * Diese Methode verändert den Kontostand.
     * @throws InterruptedException
     */
    public void spin() throws InterruptedException {
        int multiplier;
        if (einsatz <= kontostand) {
            if (w.isSelected()) {
                int random = zahlengenerator.zufallsGenerator();
                slot.ergebnisse[0] = random;
                slot.ergebnisse[1] = random;
                slot.ergebnisse[2] = random;
                multiplier = slot.schpinW();
                kontostand = kontostand - einsatz;
                gewinn = einsatz * multiplier;
                kontostand = kontostand + gewinn;

                gewinnDisplay.setText("Gewinn: " + gewinn + "CHF");
                kontoDisplay.setText("Guthaben: " + kontostand + "CHF");

                spinning();
            }else if (l.isSelected()){
                multiplier = slot.schpinL();
                kontostand = kontostand - einsatz;
                gewinn = einsatz * multiplier;
                kontostand = kontostand + gewinn;

                gewinnDisplay.setText("Gewinn: " + gewinn + "CHF");
                kontoDisplay.setText("Guthaben: " + kontostand + "CHF");

                spinning();
            } else {
                multiplier = slot.schpin();
                kontostand = kontostand - einsatz;
                gewinn = einsatz * multiplier;
                kontostand = kontostand + gewinn;

                gewinnDisplay.setText("Gewinn: " + gewinn + "CHF");
                kontoDisplay.setText("Guthaben: " + kontostand + "CHF");

                spinning();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nicht genügend Guthaben!");
        }
    }

    /**
     * Diese Methode ist für die Animation der Walzen zuständig.
     * @throws InterruptedException
     */
    public void spinning() throws InterruptedException {

        Timer simpleTimerWalze1 = new Timer(100, new ActionListener() {
            int schleifenZaehlerRolle1 = 0;

            public void actionPerformed(ActionEvent e) {
                int random = zahlengenerator.zufallsGenerator();
                ImageIcon walze1 = new ImageIcon(this.getClass().getResource("/SlotIcons/" + random + ".jpg"));
                slotWalze1.setIcon(walze1);
                slotWalze1.revalidate();
                slotWalze1.repaint();
                revalidate();
                repaint();
                schleifenZaehlerRolle1++;
                if (schleifenZaehlerRolle1 == 20) {
                    Timer s = (Timer) e.getSource();
                    s.stop();

                    walze1 = new ImageIcon(this.getClass().getResource("/SlotIcons/" + slot.ergebnisse[0] + ".jpg"));
                    slotWalze1.setIcon(walze1);
                    slotWalze1.revalidate();
                    slotWalze1.repaint();
                    revalidate();
                    repaint();
                }
            }
        });


        simpleTimerWalze1.start();


        Timer simpleTimerWalze2 = new Timer(100, new ActionListener() {
            int schleifenZaehlerRolle2 = 0;

            public void actionPerformed(ActionEvent e) {
                int random = zahlengenerator.zufallsGenerator();
                ImageIcon walze2 = new ImageIcon(this.getClass().getResource("/SlotIcons/" + random + ".jpg"));
                slotWalze2.setIcon(walze2);
                slotWalze2.revalidate();
                slotWalze2.repaint();
                revalidate();
                repaint();
                schleifenZaehlerRolle2++;
                if (schleifenZaehlerRolle2 == 20) {
                    Timer s = (Timer) e.getSource();
                    s.stop();

                    walze2 = new ImageIcon(this.getClass().getResource("/SlotIcons/" + slot.ergebnisse[1] + ".jpg"));
                    slotWalze2.setIcon(walze2);
                    slotWalze2.revalidate();
                    slotWalze2.repaint();
                    revalidate();
                    repaint();
                }
            }
        });

        simpleTimerWalze2.start();

        Timer simpleTimerWalze3 = new Timer(100, new ActionListener() {
            int schleifenZaehlerRolle3 = 0;

            public void actionPerformed(ActionEvent e) {
                int random = zahlengenerator.zufallsGenerator();
                ImageIcon walze3 = new ImageIcon(this.getClass().getResource("/SlotIcons/"+ random + ".jpg"));
                slotWalze3.setIcon(walze3);
                slotWalze3.revalidate();
                slotWalze3.repaint();
                revalidate();
                repaint();
                schleifenZaehlerRolle3++;
                if (schleifenZaehlerRolle3 == 20) {
                    Timer s = (Timer) e.getSource();
                    s.stop();

                    walze3 = new ImageIcon(this.getClass().getResource("/SlotIcons/" + slot.ergebnisse[2]+ ".jpg"));
                    slotWalze3.setIcon(walze3);
                    slotWalze3.revalidate();
                    slotWalze3.repaint();
                    revalidate();
                    repaint();

                }
            }
        });


        simpleTimerWalze3.start();

    }

    /**
     * Dies ist die Main Methode
     * @param args optionale Übergabeparameter, werden nicht genutzt.
     */
    public static void main(String[] args) {
        new Main();
    }

}
