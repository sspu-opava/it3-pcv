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
public class Sportsman extends Human {   
    private int energy = 15000;
    
    public Sportsman(String name) {
        super(name);
    }

    public Sportsman(String name, Sex sex, int age, int energy) {
        super(name, sex, age);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void eat(int energy) {
        this.energy += energy;
    }

    public void train(int energy) {
        this.energy -= energy;
    }
    
    @Override
    public String toString() {
        String output = super.toString();
        return output + "[Sportsman]";
    }       
        
}
