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

public class Human {
    public enum Sex { 
        MAN, WOMAN      
    }
    private String name = "";
    private Sex sex;
    private int age;
    private int height = 180;
    private int weight = 70;
    
    public Human(String name){
        this.name = name;
    }

    public Human(String name, Sex sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString(){
        return "My name is " + this.name + ", I'm a " + this.sex + ", " + this.age + " years old, " + this.height + " cm, " + this.weight + " kg";
    }
}
