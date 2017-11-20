/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kresleni;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ml
 */
public class Kresleni {

    private JFrame frame;
    private Color backgroundColour;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kresleni kresli = new Kresleni("Kreslení ve 2D", 600, 400, Color.WHITE);
    }
    
    private Kresleni(String title, int width, int height, Color bgColour) {
        // Vytvoření okna aplikace
        frame = new JFrame(title);
        // Nastavení výchozí operace uzavření okna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Platno());
        // Nastavení velikosti okna
        frame.setSize(width,height);
        // Okno bude viditelné
        frame.setVisible(true);
    }  
    
}
