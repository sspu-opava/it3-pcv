package kresleni;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.ColorModel;
import javax.swing.*;

/*******************************************************************************
 * Instance třídy Platno představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Platno extends JComponent
{
    //== Datové atributy (statické i instancí)======================================
   
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Platno()
    {
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(Color.BLACK);

        Graphics2D g2d = (Graphics2D) g;
        float tloustka = 1f;
        /*BasicStroke stroke = new BasicStroke(tloustka);
        g2d.setStroke(stroke);*/

        float miterLimit = 20f;
        float[] dashPattern = {5f};
        float dashPhase = 5f;
        BasicStroke stroke = new BasicStroke(tloustka, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                 miterLimit, dashPattern, dashPhase);
        g2d.setStroke(stroke);

        this.mrizka((Graphics2D)g, size, 20);
        this.terc(g,size,10,30);
        Point bod = new Point(150,30);
        this.popisek(g, bod, "Grafika v Javě", Color.RED);
        
        int xpoints[] = {25, 95, 25, 95, 25};
        int ypoints[] = {25, 25, 95, 95, 25};
        this.polygon(g2d, xpoints, ypoints, Color.white, Color.blue);
        
        this.kopirujObraz((Graphics2D) g);
        

/*        g2d.setColor(Color.red);
        g2d.draw(new Line2D.Double(200,300,400,0));
        QuadCurve2D shape = new QuadCurve2D.Double();
        shape.setCurve(250D,250D,100D,100D,200D,150D);
        g2d.setStroke(stroke1);
        g2d.draw(shape);
        CubicCurve2D c = new CubicCurve2D.Double();
        c.setCurve(250D,250D,400D,300D,200D,150D,0D,0D);
        g2d.setColor(Color.green);
        g2d.draw(c);*/
    }    

    //== Soukromé metody (instancí i třídy) ========================================

    private void mrizka (Graphics g, Dimension d, int krok) {
        g.setColor(Color.GRAY);
       
        for (int x = 0; x < d.width; x += krok) {
            g.drawLine(x, 0, x, d.height);
        }
        for (int y = 0; y < d.height; y += krok) {
            g.drawLine(0, y, d.width, y);
        }
    }
    
    private void terc (Graphics g, Dimension d, int circles, int gap){
       Color barva; 
       for(int i=0; i<circles*gap; i+=gap){
           int red = (int) Math.floor(Math.random()*256);
           int green = (int) Math.floor(Math.random()*256);
           int blue = (int) Math.floor(Math.random()*256);
           barva = new Color(red, green, blue); 
           g.setColor(barva);
           // g.fillOval(i, i, d.width-2*i, d.height-2*i);
           g.drawOval(i, i, d.width-2*i, d.height-2*i);
       } 
    }
    
    private void popisek (Graphics g, Point bod, String titulek, Color barva) {
        g.setColor(barva);
        Font f = new Font("Verdana",Font.BOLD | Font.ITALIC,30);
        g.setFont(f);
        int sirka = g.getFontMetrics(f).stringWidth(titulek);
        int vyska = g.getFontMetrics(f).getHeight();
        g.fillRoundRect(bod.x, bod.y, sirka+20, vyska+20, 10, 10);
        g.setColor(Color.WHITE);
        g.drawString(titulek, bod.x+10, bod.y+vyska+10);
    }
    
    private void polygon (Graphics2D g, int[] xs, int[] ys, Color startBarva, Color endBarva){
        GradientPaint gradient = new GradientPaint(0, 0, startBarva, 5, 5, endBarva, true);
        g.setPaint(gradient);
        g.fillPolygon(xs, ys, 5);
    }
     
    private void kopirujObraz (Graphics2D g){
        g.copyArea(0, 0, 200, 200, 300, 300);
    }
    
}
