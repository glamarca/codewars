package org.sarace.codewars;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ExpandedFormNumber {

    public static String expandedForm(int num)
    {
        String numS = ""+num;
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        for (char nums : numS.toCharArray()){
            if(Character.getNumericValue(nums) != 0){
                if(idx != 0){
                    builder.append(" + ");
                }
                builder.append(nums).append(String.join("", Collections.nCopies(numS.length() - idx -1, "0")));
            }
            idx ++;
        }
        return builder.toString();
    }

    private static StringBuilder expandFormRec(int num, StringBuilder builder) {
        if(num / 10 == 0) builder.append(num % 10);
        else {
            if(num % 10 != 0){
                builder.append((num / 10)*(num % 10)).append(" + ");
            }
            return expandFormRec(num/10, builder);
        }
        return builder;
    }
}
