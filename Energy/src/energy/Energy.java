/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ml
 */
public class Energy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Human> lide = new ArrayList<Human>();
        Human student = new Human("Pepa", Human.Sex.MAN, 18);
        student.setWeight(74);
        Human studentka = new Human("Monika", Human.Sex.WOMAN, 17);        
        studentka.setAge(15);
        Sportsman player1 = new Sportsman("Jarda", Human.Sex.MAN, 45, 20000);
        lide.add(student);
        lide.add(studentka);
        lide.add(player1);
        lide.add(new Swimmer("Ploutev", Swimmer.Style.BACKSTROKE));
        /*System.out.println(student.toString());
        System.out.println(studentka.toString());
        System.out.println(player1.toString());*/
        for (Human clovek : lide) {
            clovek.setAge(clovek.getAge()+1);
            if (clovek instanceof Sportsman) {
                ((Sportsman) clovek).eat(5000);
            }
            System.out.println(clovek.toString());
        }
    }
}
    

