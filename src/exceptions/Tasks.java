package exceptions;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tasks {
    public <T> void printArray(T[] array) {
        int i = 0;
        while (true) {
            try {
                System.out.print(array[i] + " ");
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("\nThe end of the array: " + Arrays.toString(array));
                break;
            }
        }
    }

    public void recursion(int i) {
        try {
            i *= i * i;
            recursion(i);
        } catch (StackOverflowError e) {
            System.err.println("The memory is full");
        }
    }

    public void printOneWord(String str) throws RuntimeException {
        if (str.split(" ").length == 1)
            System.out.println(str);
        else {
            try {
                throw new RuntimeException("The space is not expected.");
            } catch (RuntimeException e) {
                System.err.println("Error occured: " + e);
            }
        }
    }

    public void inputTester() throws IllegalAgeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, what is your name?");
        try {
            Integer age = scanner.nextInt();
            if (age < 0)
                throw new IllegalAgeException("Illegal Age!!!");
        } catch (InputMismatchException e) {
            System.err.println("Oh no, i wanted to ask your age not your name!!! Err:" + e);
        } catch (IllegalAgeException e) {
            System.err.println("Please enter a valid age:" + e);
        } finally {
            scanner.close();
            System.out.println("Closed scanner!");
        }
    }
}
