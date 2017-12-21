package org.sarace.codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class UniqueNumberTest {

    Logger LOGGER = Logger.getLogger("UniqueNumberTest");



    private void makeTestsAndPrint(double[] array, double unique, double common, String methodName, Function<double[], Double> func){
        System.out.println(String.format("### Method : %s", methodName));
        System.out.println(String.format("Array  : %s ...", Arrays.toString(Arrays.copyOfRange(array, 0, 10))));
        System.out.println(String.format("Array length : %d", array.length));
        System.out.println(String.format("CommonNumber : %1$,.2f", common));
        System.out.println(String.format("UniqueNumber : %1$,.2f", unique));
        double solution = -1;
        try{
            Long startTime = new Date().getTime();
            solution  = func.apply(array);
            Long stopTime = new Date().getTime();
            Long processTime = stopTime - startTime;
            System.out.println(String.format("Result from function : %1$,.2f", solution));
            System.out.println(String.format("Process time : %d", processTime));
        } catch (StackOverflowError e){
            solution = -1;
            System.out.println(String.format("StackOverflow on length %d", array.length));
            e.printStackTrace();
        }
        assertTrue(String.format("Solution should be %1$,.2f", unique), unique == solution);
    }

    @Test
    public void findUniqOnN() {
        Random random = new Random();
        double common = random.nextDouble();
        double single = random.nextDouble();
        double[] array = createArray(100000000, common, single);
        //makeTestsAndPrint(array,single, common, "recursive head and tail", UniqueNumber::findUniqRecHeadAndTail);
        //makeTestsAndPrint(array,single, common, "recursive tail", UniqueNumber::findUniqRecHead);
        //makeTestsAndPrint(array,single, common, "while head and tail", UniqueNumber::findUniqWhileHeadAndTail);
        //makeTestsAndPrint(array,single, common, "while head", UniqueNumber::findUniqWhileHead);
        makeTestsAndPrint(array,single, common, "for loop", UniqueNumber::findUniqForLoop);
    }

    private double[] createArray(int size, double common, double single){
        double[] array = new double[size];
        Random rand = new Random();
        int single_index = rand.nextInt(size);
        for (int i = 0; i < size; i ++){
            array[i] = common;
        }
        array[single_index] = single;
        return array;
    }

}