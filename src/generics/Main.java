package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] matrix = {
                {"a", "b", "c", "d", "e"},
                {"f", "g", "h", "i", "j"},
                {"k", "l", "m", "n", "o"},
                {"p", "q", "r", "s", "t"},
                {"u", "v", "w", "x", "y"}
        };

        //-Q2
        /*

        MatrixTransposer<String> matrixTransposer
                = new MatrixTransposer<>(matrix);
        matrixTransposer.transpose();
        System.out.println(matrixTransposer.toString());

        */

        //-Q3
        Integer[] intArr = {666666, 55555, 4444, 333, 22, 1};

        Double[] doubleArr = {666666.666666, 55555.55555, 4444.4444, 333.333, 22.22, 1.1};

        String[] strArr = {"ffffff", "eeeee", "dddd", "ccc", "bb", "a"};

        Main.<Integer>printArray(intArr);
        Main.<Double>printArray(doubleArr);
        Main.<String>printArray(strArr);

//        Main.<Integer>printArray(intArr, 0, 1);
//        Main.<Double>printArray(doubleArr, 2, 3);
//        Main.<String>printArray(strArr, 4, 5);

        Main.<Integer>sortArray(intArr);
        Main.<Double>sortArray(doubleArr);
        Main.<String>sortArray(strArr);

        Main.<Integer>printArray(intArr);
        Main.<Double>printArray(doubleArr);
        Main.<String>printArray(strArr);
    }

    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static <T> void printArray(T[] array, int lower, int upper) {
        String vals = "";
        for (int i = lower; i <= upper; i++) {
            vals += array[i] + " ";
        }
        System.out.println(vals);
    }

    public static <T> void sortArray(T[] array) {
        Arrays.<T>sort(array);
    }
}
