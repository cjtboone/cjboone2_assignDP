package main;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Main {

    public static JTextPane display;
    public static JFrame frame;
    public static int livingQueens;
    public static int fedHives;
    
    /**
     * Main method for running bee simulation, displays ASCII
     * map in a GUI.
     * @param args n/a
     */
    public static void main(String[] args) {
        
        
        frame = new JFrame("Bees, not Ants");
        display = new JTextPane();
        display.setEditable(false);
        
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_JUSTIFIED);
        display.setParagraphAttributes(attribs,true);
        
        frame.setLayout(new FlowLayout());
        frame.add(display);
        frame.setSize(1100,940);
        frame.setVisible(true);
        
        Apiary apiary;
        Apiary.setMapSize(30, 50);
        apiary = Apiary.getApiary();
        livingQueens();
        fedHives();
        
        while (livingQueens > 1 && fedHives > 0) {
            display.setText(Apiary.printMap());
            apiary.buzz();
            livingQueens();
            fedHives();
        }
        
    }
    
    /**
     * Quit condition, ends simulation when 1 queen remains.
     */
    public static void livingQueens() {
        livingQueens = 0;
        for (Hive hive : Apiary.getApiaryMap().getHives()) {
            if (hive.getAlive()) {
                livingQueens++;
            }
        }
    }
    
    /**
     * Alternative quit condition, hives seems to starve themselves frequently.
     */
    public static void fedHives() {
        fedHives++;
        for (Hive hive : Apiary.getApiaryMap().getHives()) {
            if (hive.getFood() > 0) {
                fedHives++;
            }
        }
    }

}
