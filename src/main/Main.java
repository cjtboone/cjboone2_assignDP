package main;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Main {

    public static JTextPane display;
    public static JFrame frame;
    
    public static void main(String[] args) {
        
        frame = new JFrame("Bees, not Ants");
        display = new JTextPane();
        display.setEditable(false);
        
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_JUSTIFIED);
        display.setParagraphAttributes(attribs,true);
        
        frame.setLayout(new FlowLayout());
        frame.add(display);
        frame.setSize(1100,940);
        frame.setVisible(true);
        
        Apiary apiary;
        Apiary.setMapSize(50, 75);
        apiary = Apiary.getApiary();
        while (true) {
            display.setText(Apiary.printMap());
            apiary.buzz();
        }
        
    }

}
