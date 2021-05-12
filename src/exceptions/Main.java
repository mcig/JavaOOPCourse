package exceptions;

public class Main {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        Integer[] arr = {21, 354, 41, 39, 5, 32, 9, 2, 3, 489};

        tasks.printArray(arr);

        tasks.recursion(1000);

        tasks.printOneWord("Hello World");

        tasks.inputTester();
    }
}
