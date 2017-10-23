/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energy;

/**
 *
 * @author ml
 */
public class Swimmer extends Sportsman implements Move {
    private Boolean stateOfMoving = false;
            
    @Override
    public void startMoving() {
        System.out.println("Swimming");
        this.stateOfMoving = true;
    }

    @Override
    public void stopMoving() {
        this.stateOfMoving = false;
    }

    @Override
    public boolean getState() {
        return this.stateOfMoving;
    }

    public enum Style {
        FRONTCRAWL("Front crawl", "kraul"),
        BACKSTROKE("Backstroke", "znak"),
        BUTTERFLY("Butterfly", "motýlek"),
        BREASTSTROKE("Breaststroke", "prsa"); 

        private final String english;
        private final String czech;

        private Style(String english, String czech) {
            this.english = english;
            this.czech = czech;
        }

        public String getEnglishName() {
            return this.english;
        }

        public String getCzechName() {
            return this.czech;
        }
    }    
    
    private Style style;
    
    public Swimmer(String name, Style style) {
        super(name);
        this.style = style;
    }

    public String getStyle() {
        return style.getCzechName();
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return super.toString() + ", swimming style: " + this.getStyle(); //To change body of generated methods, choose Tools | Templates.
    }        
    
}
