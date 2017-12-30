package org.sarace.codewars;

public class DoubleCola {
    public static String WhoIsNext(String[] names, int n)
    {
        if(n == 0){
            return "";
        }
        int rang = 0;
        while(true){
            if(n < Math.pow(rang, 2) * 5){
                if(n <= 5) return names[n-1];
                int valueAtRangeMinus1 = (int)(Math.pow(rang -1 , 2)) * 5;
                int x = n - valueAtRangeMinus1;
                int y = x / rang;
                if(x % rang == 0) y = y-1;
                return names[y];
            }
            rang ++;
        }
    }
}
