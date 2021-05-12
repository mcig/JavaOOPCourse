package Lab8;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        Integer[] intArr = {1, 123, 754, 3, 4, 8, 2, 7, 2, 7, 89, 87, 24};
        Double[] doubleArr = {1.1, 1.2, 1.3, 3.1, 4.1, 8.1, 2.1, 7.1, 2.1, 7.1, 89.22, 87.3, 24.4};
        Short[] shortArr = {24, 35, 45, 632, 385, 4, 238, 453, 45, 21, 752};

        Question1.<Integer>findFrequency(intArr, 2);
        Question1.<Double>findFrequency(doubleArr, 7.1);
        Question1.<Short>findFrequency(shortArr, (short) 4);

    }

    public static <T extends Number> Integer findFrequency(T[] array, T value) {
        int length = array.length;
        int counter = 0;

        System.out.println("Input array:\n" + Arrays.toString(array));
        for (int i = 0; i < length; i++) {
            if (array[i].equals(value))
                counter++;
        }
        System.out.println("Frequency of value " + value + " is" + " " + counter + "\n");
        return counter;
    }
}
