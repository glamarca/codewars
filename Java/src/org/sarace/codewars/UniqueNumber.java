package org.sarace.codewars;

public class UniqueNumber {

    public static double findUniq(double numbers[]) {
        assert numbers.length >= 3;
        return findUniqWhileHeadAndTail(numbers);
    }

    public static double findUniqRecHeadAndTail(double numbers[]) {
        double com = init(numbers);
        if(com != -1){
            return com;
        }
        return processRecHeadAndTail(numbers, com, 2, numbers.length-1);
    }

    private static double processRecHeadAndTail(double[] numbers, double common, int head_index, int tail_index) {
        if(head_index > tail_index) return -1;
        if(numbers[head_index] != common) return numbers[head_index];
        if(numbers[tail_index] != common) return numbers[tail_index];
        return processRecHeadAndTail(numbers, common, head_index + 1, tail_index - 1);
    }

    public static double findUniqRecHead(double numbers[]) {
        Double com = init(numbers);
        if(com != -1){
            return com;
        }
        return processRecHead(numbers, numbers[0], 2);
    }

    private static double processRecHead(double[] numbers, double common, int index) {
        return numbers[index] != common ? numbers[index]: index < numbers.length-1 ? processRecHead(numbers, common, index+1) : -1;
    }

    public static double findUniqWhileHeadAndTail(double numbers[]) {
        Double com = init(numbers);
        if(com != -1){
            return com;
        }
        return processWhileHeadTail(numbers, com);
    }

    private static double processWhileHeadTail(double[] numbers, Double common) {
        int headIndex = 1;
        int tailIndex = numbers.length-1;
        while (true){
            if(numbers[headIndex] != common) return numbers[headIndex];
            if(numbers[tailIndex] != common) return numbers[tailIndex];
            headIndex++;
            tailIndex--;
        }
    }

    public static double findUniqWhileHead(double numbers[]) {
        Double com = init(numbers);
        if(com != -1){
            return com;
        }
        return processWhileHead(numbers, com);
    }

    private static double processWhileHead(double[] numbers, Double common) {
        int headIndex = 0;
        while (true){
            if(numbers[headIndex] != common) return numbers[headIndex];
            headIndex++;
        }
    }

    public static double findUniqForLoop(double[] numbers) {
        double common = init(numbers);
        if(common == -1){
            return process(numbers, numbers[0]);
        }
        return common;
    }

    private static double process(double[] numbers, double common) {
        for(int i=2; i< numbers.length; i++){
            if(numbers[i] != common){
                return numbers[i];
            }
        }
        return -1;
    }

    private static double init(double[] numbers) {
        if(numbers[0] != numbers[1]) {
            if (numbers[0] != numbers[2]) return numbers[0];
            else return numbers[1];
        }
        return -1;
    }
}
