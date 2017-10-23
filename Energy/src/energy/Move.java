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
public interface Move {
    void startMoving();
    void stopMoving();
    boolean getState();
    static double speed(int distance, double time) {        
        try {
            return distance/time;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return -1;
        }
    }
}
