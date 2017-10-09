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
public class Energy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Human student = new Human("Jarda", Human.Sex.MAN, 18);
        Human studentka = new Human("Monika", Human.Sex.WOMAN, 17);
        studentka.setAge(15);
        studentka.sleep(480);
        student.setWeight(74);
        System.out.println(student.toString());
        System.out.println(studentka.toString());
    }
    
}
