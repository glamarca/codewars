package org.sarace.codewars;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneNCycle {
    public static int cycle(int n) {
        if(pgcd(10, n) == 1){
            return getCycle(n);
        }
        return -1;
    }

    private static int getCycle(int n) {
        if (n % 5 != 0 && n % 2 != 0){
            int numNine = 1;
            int n_mult = 9;
            while(n_mult % n != 0){
                n_mult = n_mult * 10 + 9;
                numNine ++;
            }
            return numNine;
        }
        return -1;
    }

    private static int pgcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        return pgcd(num2, num1 % num2);
    }
}
