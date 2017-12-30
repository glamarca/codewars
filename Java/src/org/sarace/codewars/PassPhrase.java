package org.sarace.codewars;

import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sarace on 22/12/17.
 */
public class PassPhrase {

    public static String passPhrase(String clear, int shifts){
        return new StringBuilder(IntStream.range(0, clear.length()).mapToObj(idxChar -> {
            char c = clear.charAt(idxChar);
            if(Character.isDigit(c)){
                return String.valueOf(9 - Character.getNumericValue(c));
            } else if (Character.isLetter(c)){
                c = (char)(((Character.toLowerCase(c) - 'a' + shifts) % 26)+'a');
                if(idxChar % 2 == 0){
                    c = Character.toUpperCase(c);
                } else c = Character.toLowerCase(c);
            }
            return String.valueOf(c);
        }).collect(Collectors.joining())).reverse().toString();
    }
}
