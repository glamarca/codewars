package org.sarace.codewars;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class OnesAndZeros {

    public static int convertBinaryArrayToInt(List<Integer> binary) {
        /*int result = 0;
        int idx = 0;
        for (Integer i : binary){
            int rang =  binary.size() - 1 - idx;
            result += i*(Math.pow(2, rang));
            idx++;
        }
        return result;*/
        return convertRecursive(new LinkedList<>(binary),0, binary.size() -1, 0 , binary.size() -1 );
    }


    public static int convertRecursive(LinkedList<Integer> binary, Integer idx, Integer rang, Integer value, Integer last_index){
        if(idx <= last_index){
            Integer bin_val = binary.pop();
            Double val_rang = Math.pow(2, rang);
            Integer value_cell = val_rang.intValue() * bin_val;
            value += value_cell;
            idx++;
            return convertRecursive(binary,idx, last_index - idx,value,last_index);
        }
        return value;
    }
}
