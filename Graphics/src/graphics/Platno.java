/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author ml
 */

class Bod {
    public Point point;
    public Color color;
    public boolean fill;
    
    public Bod(int x, int y, boolean fill) {
        this.point = new Point(x,y);
        int red = (int) Math.floor(Math.random() * 256);
        int green = (int) Math.floor(Math.random() * 256);
        int blue = (int) Math.floor(Math.random() * 256);
        this.color = new Color(red, green, blue);
        this.fill = fill;
    }       
}

class Platno extends JComponent {
    private int x = 200;
    private int y = 200;
    ArrayList<Bod> points;
    
    public Platno() {
        this.points = new ArrayList();
    }

    public void setPoint(int x, int y, boolean fill) {
        this.x = x;
        this.y = y;
        this.points.add(new Bod(x, y, fill));
    }

    public void setCursor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Color getColor(int x, int y) {
        Color color = Color.WHITE;
        try {
            Robot robot = new Robot();
            color = robot.getPixelColor(x, y);
        } catch (AWTException e) {
            e.printStackTrace();
        }    
        return color;
    }
    
    private void drawLinks(Graphics g, int x, int y) {
        Dimension size = this.getSize();
        Graphics2D g2d = (Graphics2D) g;
        float tloustka = 1f;
        float miterLimit = 20f;
        float[] dashPattern = {5f};
        float dashPhase = 5f;
        BasicStroke stroke = new BasicStroke(tloustka, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                 miterLimit, dashPattern, dashPhase);
        g2d.setStroke(stroke);
        g2d.setColor(Color.GRAY);
        g2d.drawLine(x, 0, x, size.height);
        g2d.drawLine(0, y, size.width, y);
        g2d.drawRect(x-40, y-40, 80, 80); 
        g2d.drawString(Integer.toString(x), 10, y-5);
        g2d.drawString(Integer.toString(y), x+5, 20);
    }
    
    private void drawPoints(Graphics g) {
        for (Bod b: this.points) {
            g.setColor(b.color);  
            if (b.fill)
                g.fillOval(b.point.x-20, b.point.y-20, 40, 40);
            else
                g.drawArc(b.point.x-20, b.point.y-20, 40, 40, 0, 360);
        }
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        drawPoints(g);
        drawLinks(g, x, y);
    }        
}
