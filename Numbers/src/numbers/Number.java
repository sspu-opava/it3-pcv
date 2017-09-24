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
public class Number {
    enum TypeOfNumber {
        NEGATIVE, ZERO, POSITIVE
    }
    private TypeOfNumber type;
    private int x = 0;
    public boolean valid = false;

    public Number(String num) {
        if (this.isInteger(num,10)) {
            this.valid = true;
            this.x = Integer.parseInt(num);
            if (x == 0)
                this.type = TypeOfNumber.ZERO;
            else if (x > 0)
                this.type = TypeOfNumber.POSITIVE;
            else
                this.type = TypeOfNumber.NEGATIVE;
        } else {
            this.valid = false;
            System.out.println("Nebylo zadáno celé číslo!");  
        };        
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), radix) < 0) {
                return false;
            }
        }
        return true;
    }

    public String toString() {        
        return this.valid == false ? "Neplatné číslo" : "Zadané číslo: " + String.valueOf(this.x);
    }

    public TypeOfNumber getType() {
        return type;
    }
        
}
