/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ml
 */
public class Graphics {
    
    private final JFrame window;
    private JButton btnDraw;
    private Platno platno;
    
    public Graphics(String title, int width, int height) {
        // Vytvoření okna aplikace
        window = new JFrame(title);
        // Nastavení výchozí operace uzavření okna
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Nastavení velikosti okna
        window.setSize(width,height);
        // Vytvoření objektu popisu Nadpis
        JLabel labHeading = new JLabel("Ukázka grafiky v JAVĚ");
        // Nastavení písma nadpisu
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font ("Arial", style , 20);
        labHeading.setFont(font);
        // Nastavení vnitřního odsazení nadpisu
        labHeading.setBorder(new EmptyBorder(10, 0, 10, 0));
        labHeading.setHorizontalAlignment(JLabel.CENTER);
        // Nastavení barvy nadpisu
        labHeading.setForeground(Color.WHITE);
        labHeading.setBackground(Color.BLACK);
        labHeading.setOpaque(true);
        // Vytvoření objektu tlačítka btnDraw s názvem "Náhodně"
        JButton btnDraw = new JButton("Náhodně");
        // Akce kliknutí na tlačítko
        btnDraw.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Do Something Clicked");
                int x = (int) Math.floor(Math.random()* window.getWidth());
                int y = (int) Math.floor(Math.random()* window.getHeight());
                platno.setPoint(x, y, true);
                platno.repaint();
            }
        });
        // Layout okna
        // Vytvoření kontejneru daného okna
        Container pane = window.getContentPane();
        // Přidání objektů do kontejneru s využitím BorderLayout
        // Objekt popisku labHeading bude vložen do horní části okna
        pane.add(labHeading, BorderLayout.PAGE_START);
        // Objekt tlačítka btnDraw bude vložen do spodní části okna
        pane.add(btnDraw, BorderLayout.PAGE_END);
        // Objekt plátna bude vložen do střední části okna
        platno = new Platno();
        platno.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.print(e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton()==1){
                    platno.setPoint(e.getX(),e.getY(),false);
                    platno.repaint();
                }
                if (e.getButton()==3){
                    platno.setPoint(e.getX(),e.getY(),true);
                    platno.repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        platno.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                platno.setCursor(e.getX(),e.getY());
                platno.repaint();
                labHeading.setForeground(platno.getColor(e.getXOnScreen(),e.getYOnScreen()));
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                platno.setCursor(e.getX(),e.getY());
                platno.repaint();
            }
        });
        pane.add(platno, BorderLayout.CENTER);
        // Okno bude viditelné
        window.setVisible(true);        
    }
    
    
    /**
     * @param args the command line arguments
     */        
    
    public static void main(String[] args) {
        // Vytvoření objektu okna aplikace
        Graphics graphics =  new Graphics("Grafika v Javě",800,600);
    }
    
}
