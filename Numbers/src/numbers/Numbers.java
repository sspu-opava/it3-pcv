/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers;

/**
 *
 * @author ml
 */


public class Numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Number n = new Number(args[0]);
            if (n.valid) {
                System.out.println(n.toString());
                System.out.printf("Typ čísla %s%n", n.getType());
            }
        } catch (Exception e) {
            System.out.println("Chyba: " + e);
        }
    }
    
}
